package lab7;

import java.io.IOException;
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
            double population = reader.getDouble("population");
            double area = reader.getDouble("area");
            double density = reader.getDouble("density");

            AdminUnit unit = new AdminUnit(name, adminLevel, population, area, density, null, null);
            units.add(unit);
            unit2id.put(unit, reader.getLong("id"));

            if (!parentid2child.containsKey(parent)) {
                parentid2child.put(parent, new ArrayList<>());
            }
            parentid2child.get(parent).add(unit);
        }

        for (AdminUnit unit : units) {
            if (parentid2child.containsKey(unit2id.get(unit))) {
                unit.children = parentid2child.get(unit2id.get(unit));
            }
            for (AdminUnit child: unit.children) {
                child.parent = unit;
            }
        }
    }
}
