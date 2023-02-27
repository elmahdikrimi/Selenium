package Practices;

import java.util.ArrayList;

public class JavaConcepts {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int[] arr2 = {1,2,3,5,6};

        for(int s:arr2){
            System.out.println(s);
        }

        //ArrayList
        ArrayList<String> a = new ArrayList<>();
        a.add("Mehdi");
        System.out.println(a.get(0));


    }
}
