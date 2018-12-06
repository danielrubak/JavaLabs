package lab7;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminUnitList {
    List<AdminUnit> units = new ArrayList<>();

    public void read(String filename) throws IOException {
        Map<Long,List<AdminUnit>> parentid2child = new HashMap<>();
        Map<AdminUnit, Long> unit2id = new HashMap<>();

        CSVReader reader = new CSVReader(filename,",",true);
        while(reader.next()) {
            String name = reader.get("name");
            long parent = reader.getLong("parent");
            int adminLevel = reader.getInt("admin_level");
            double population = reader.getDouble("population", -1);
            double area = reader.getDouble("area", -1);
            double density = reader.getDouble("density", -1);

            AdminUnit unit = new AdminUnit(name, adminLevel, population, area, density, null, null, null);
            units.add(unit);
            unit2id.put(unit, reader.getLong("id"));

            if (!parentid2child.containsKey(parent)) {
                parentid2child.put(parent, new ArrayList<>());
            }
            parentid2child.get(parent).add(unit);
        }

        for (AdminUnit unit : units) {
            if (parentid2child.containsKey(unit2id.get(unit))) {
                unit.setChildren(parentid2child.get(unit2id.get(unit)));
            }
            if ( unit.getChildren() != null ) {
                for (AdminUnit child: unit.children) {
                    child.setParent(unit);
                }
            }
        }
    }

    void list( PrintStream out ){
        for( AdminUnit unit : units ) {
            out.println(unit.toString());
        }
    }

    void list( PrintStream out, int offset, int limit ) {
        for( int i = offset; i < Math.min(offset+limit, units.size()); i++ ) {
            out.println(units.get(i).toString());
        }
    }

    /**
     * Zwraca nową listę zawierającą te obiekty AdminUnit, których nazwa pasuje do wzorca
     * @param pattern - wzorzec dla nazwy
     * @param regex - jeśli regex=true, użyj finkcji String matches(); jeśli false użyj funkcji contains()
     * @return podzbiór elementów, których nazwy spełniają kryterium wyboru
     */
    AdminUnitList selectByName(String pattern, boolean regex){
        AdminUnitList ret = new AdminUnitList();
        // przeiteruj po zawartości units
        // jeżeli nazwa jednostki pasuje do wzorca dodaj do ret
        return ret;
    }
}
