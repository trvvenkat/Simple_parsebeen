package com.kgisl.parsebeen;

import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class App {
//@SuppressWarnings("resources")

    public static void main(String[] args) throws IOException {

        String fileName = "src/main/resources/Employee.csv";
        Path myPath = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(myPath,
                StandardCharsets.UTF_8)) {

            ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
            strategy.setType(Employee.class);
            String[] fields = {"id", "name", "salary"};
            strategy.setColumnMapping(fields);

            CsvToBean csvToBean = new CsvToBeanBuilder(br)
                    .withType(Employee.class)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<Employee> emp = csvToBean.parse();
            Map amap = new HashMap();
            for (int i = 0; i < emp.size(); i++) {
                amap.put(i + 1, emp.get(i));
              }

            //emp.forEach(System.out::println);
            System.out.println(amap.toString());
        }
    }
}