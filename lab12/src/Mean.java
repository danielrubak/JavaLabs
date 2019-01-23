import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Mean {
    static BlockingQueue<Double> results = new ArrayBlockingQueue<Double>(100);
    static double[] array;

    public static void main(String[] args) {
        initArray(100000000);
        for (int cnt : new int[]{1, 2, 4, 8, 16, 32, 64, 128}) {
            parallelMean(cnt);
        }
    }

    static void initArray(int size) {
        array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = Math.random() * size / (i + 1);
        }
    }

    static class MeanCalc extends Thread {
        private final int start;
        private final int end;
        double mean = 0;

        MeanCalc(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            double sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            mean = sum / (end - start);
            try {
                results.put(mean);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Calculates the average of array elements by running parallel threads.
     * It prints the time of the operation
     *
     * @param cnt - number of threads
     */
    static void parallelMean(int cnt) {
        MeanCalc threads[] = new MeanCalc[cnt];

        int range_size = array.length / cnt;
        for (int i = 0; i < cnt; i++) {
            threads[i] = new MeanCalc(i * range_size, i * range_size + range_size);
        }

        double t1 = System.nanoTime() / 1e6;

        for (MeanCalc mc : threads) {
            mc.start();
        }

        double t2 = System.nanoTime() / 1e6;

        double mean = 0;
        for (MeanCalc mc : threads) {
            try {
                mean += results.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mean = mean / cnt;

        double t3 = System.nanoTime() / 1e6;
        System.out.printf(Locale.US, "Size = %d cnt=%d > t2-t1=%f   t3-t1=%f > Mean = %f\n",
                array.length,
                cnt,
                t2 - t1,
                t3 - t1,
                mean);
    }
}