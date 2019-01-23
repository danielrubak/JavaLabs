public class NameUnit {
    int year;
    String name;
    long birthCount;
    String gender;

    public NameUnit(int year, String name, long birthCount, String gender) {
        this.year = year;
        this.name = name;
        this.birthCount = birthCount;
        this.gender = gender;
    }

    public String toString() {
        return "NameUnit{" +
                "year='" + year + '\'' +
                "name='" + name + '\'' +
                "birthCount='" + birthCount + '\'' +
                "gender='" + gender + '\'' +
                '}';
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBirthCount() {
        return birthCount;
    }

    public void setBirthCount(long birthCount) {
        this.birthCount = birthCount;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
