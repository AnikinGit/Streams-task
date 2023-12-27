package tasks.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        getMap(editedMap(createMap()));

    }

    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Monday", 8);
        map.put("Tuesday", 9);
        map.put("Wednesday", 10);
        map.put("Thursday", 11);
        map.put("Friday", 12);
        map.put("Saturday", 13);
        map.put("Sunday", 15);

        return map;
    }

    public static Map<String, Integer> editedMap(Map<String, Integer> map){
        return map.entrySet().stream()
                .filter(frt -> frt.getValue() >= 10 && frt.getValue() <= 13)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void getMap(Map<String, Integer> map){
        AtomicInteger cnt = new AtomicInteger(0);
        map.forEach((key, value) -> {
            cnt.getAndIncrement();
            System.out.println(cnt + ") " + key + ", " +  value);
        });
    }
}
