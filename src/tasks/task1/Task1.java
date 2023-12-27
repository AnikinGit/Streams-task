package tasks.task1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class Task1 {

    public static void main(String[] args) {

        getList(editedList(createList()));
    }

    public static List<String> createList() {
        List<String> names = new ArrayList<>();
        names.add("Tom");
        names.add("Alice");
        names.add("Bob");
        names.add("Toby");
        names.add("Lucy");
        names.add("Tim");

        return names;
    }

    public static List<String> editedList(List<String> list){
        return list.stream().filter(str -> str.startsWith("T"))
                .toList();
    }

    public static void getList(List<String> list){
        AtomicInteger cnt = new AtomicInteger(0);
        Consumer<String> consumer = name -> System.out.println(cnt.incrementAndGet() +") " + name);
        list.forEach(consumer);
    }
}
