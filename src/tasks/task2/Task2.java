package tasks.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
        getMap(editedMap(createMap()));
    }
    public static Map<String, Double> createMap() {
        Map<String, Double> map = new HashMap<>();
        map.put("orange", 1.05);
        map.put("banana", 3.0);
        map.put("lemon", 1.5);
        map.put("pineapple", 1.18);
        map.put("grape", 2.0);
        map.put("mango", 3.15);

        return map;
    }

    public static Map<String, Double> editedMap(Map<String, Double> map){
        return map.entrySet().stream()
                .filter(frt -> frt.getValue() <= 2.0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void getMap(Map<String, Double> map){
        AtomicInteger cnt = new AtomicInteger(0);
        map.forEach((key, value) -> {
            cnt.getAndIncrement();
            System.out.println(cnt + ") " + key + ", " +  value);
        });
    }
}
