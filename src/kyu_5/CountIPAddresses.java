package kyu_5;

import java.util.Arrays;

public class CountIPAddresses {

    /*Normal Solution*/
    public static long ipsBetweenFirstSolution(String start, String end) {

        long output = 0L;
//    Stream<String> stream_start = Arrays.stream(start.split("."));
//            stream_start.forEach(System.out::println);
//    Stream<String> stream_end = Arrays.stream(end.split("."));
//    stream_end.forEach(System.out::println);

        String[] startArray = start.split("\\.");
        String[] endArray = end.split("\\.");

        for(int i = 0 ; i <= startArray.length-1 ; i++){
            if(i == 0) output += (Long.parseLong(startArray[i])-Long.parseLong(endArray[i]))*Math.pow(2,24);
            if(i == 1) output += (Long.parseLong(startArray[i])-Long.parseLong(endArray[i]))*Math.pow(2,16);;
            if(i == 2) output += (Long.parseLong(startArray[i])-Long.parseLong(endArray[i]))*Math.pow(2,8);;
            if(i == 3) output += (Long.parseLong(startArray[i])-Long.parseLong(endArray[i]))*Math.pow(2,0);;
        }

        return Math.abs(output);
    }



    /*Stream Solution*/
    public static long ipsBetweenSecondSolution(String start, String end) {
        int[] startParts = ipToParts(start);
        int[] endParts = ipToParts(end);
        long result = 0;
        for(int i = startParts.length - 1, multiplier = 1; i >= 0; i--, multiplier *= 256) {
            result += multiplier * (endParts[i] - startParts[i]);
        }
        return Math.abs(result);
    }

    private static int[] ipToParts(String ipAddress) {
        return Arrays.stream(ipAddress.split("\\."))
                .mapToInt(Integer::parseInt)
                .toArray();
    }


    public static void main(String[] args){

        long result = ipsBetweenFirstSolution("10.0.0.0", "10.0.0.50");
        long result1 = ipsBetweenFirstSolution("20.0.0.10", "20.0.1.0");
        long result2 = ipsBetweenFirstSolution("25.0.0.0", "24.0.0.0");
        long result3 = ipsBetweenFirstSolution("0.0.0.10", "2.15.18.4");

        long result11 = ipsBetweenSecondSolution("10.0.0.0", "10.0.0.50");
        long result12 = ipsBetweenSecondSolution("20.0.0.10", "20.0.1.0");
        long result21 = ipsBetweenSecondSolution("25.0.0.0", "24.0.0.0");
        long result31 = ipsBetweenSecondSolution("0.0.0.10", "2.15.18.4");


    }

}
