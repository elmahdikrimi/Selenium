import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JavaStreams {
    public static void main(String[] args) {
        //iterate through an array and count the elements that start with A using Java Streams
        ArrayList<String> names = new ArrayList<String>();
        names.add("Mehdi");
        names.add("El Mahdi");
        names.add("Zlatan");
        names.add("Rahul");
        names.add("Eric Lamela");
        //using stream filter, to filter by condition
        //converting the arrayList into Stream using .stream()
        // .filter gets executed when condition is true
        Long c = names.stream().filter(s -> s.startsWith("E")).count();
        System.out.println(c);
        //using stream directly
        Long b = Stream.of("Milan","Napoli","Atalanta","Juve").filter(t -> t.startsWith("A")).count();
        System.out.println(b);
        //Print names in the array using stream with condition
        names.stream().filter(n -> n.length()>4).forEach(n -> System.out.println(n));
        //limit the stream by using limit(n)
        names.stream().filter(n -> n.length()>4).limit(1).forEach(n -> System.out.println(n));//forEach will be applied only on the first item

        //map - help modify the result of a stream

        //print names which end with "E" and Uppercase them
        // -> lambda expression
        Stream.of("Vidic","West Brown","Rio","Evra","Gary Neville").filter(n -> n.endsWith("e")).map(n -> n.toUpperCase())
                .forEach(s -> System.out.println(s));

        //print names that start with N, uppercased and sorted using .sorted()
        List<String> langs = Arrays.asList("Java","JavaScript","C#","C++","CocaCola");
        langs.stream().filter(s -> s.startsWith("C")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //Merging and concatenating two arrays
        Stream<String> newStream = Stream.concat(names.stream(), langs.stream());
        newStream.sorted().forEach(s -> System.out.println(s));

        //find element in array using anyMatch()
        boolean flag = Stream.of("Pizza","Raviolli","Parmesano").anyMatch(s -> s.equalsIgnoreCase("pizza"));
        System.out.println(flag);
        Assert.assertTrue(flag);

        //Collect: converts the results of Streams to a list
        List<String> ls = Stream.of("Ciro","Del Piero","Totti","Cannavaro").filter(s -> s.endsWith("o"))
                .map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));

        //remove duplicates using distinct()
        List<Integer> nums = Arrays.asList(1,2,3,3,3,5,5,5,4,4,9,9);
        nums.stream().distinct().sorted().forEach(n -> System.out.println(n));


    }



}
