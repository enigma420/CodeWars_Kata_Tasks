package kyu_4.MostFrequentlyUsedWordsInText;

import javax.swing.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toList;

public class TopWords {

    public static List<String> top3(String s) {
        Map<String,Long> map;

        String specialChars = "!@#$%^&*(),.?\":{}|<>']|[!@#$%^&*(),.?\":{}|<>'";
        s = s.trim().toLowerCase().replaceAll("((?<=\\w)\\W+(?!\\w)|(?<!\\w)\\W+(?=\\w)|(?<!\\w)\\W+(?!\\w))", " ")
                .replaceAll("^\\s+","")
                .replaceAll("/\\s+/g", "")
                .replaceAll("[\n\t]", " ");

        if(s.equals("")) return Collections.emptyList();
        List<String> list = new ArrayList<>(Arrays.asList(s.split(" +")));
        map = list
                .stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return map.entrySet().stream()
                .sorted(comparingByValue(reverseOrder()))
                .limit(3)
                .map(Entry::getKey)
                .collect(toList());
    }

    public static void main(String[] args){

        List<String> result = top3("a a a  b  c c  d d d d  e e e e e");
        List<String> result1 = top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e");
        List<String> result2 = top3("  //wont won't won't ");
        List<String> result3 = top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e");
        List<String> result4 = top3("e e e e DDD ddd DdD: ddd ddd aa aA Aa, bb cc cC e e e");
        List<String> result5 = top3("  , e   .. ");
        List<String> result6 = top3("  ...  ");
        List<String> result7 = top3("  '  ");
        List<String> result8 = top3("  '''  ");
        List<String> result9 = top3(Stream
                .of("In a village of La Mancha, the name of which I have no desire to call to",
                        "mind, there lived not long since one of those gentlemen that keep a lance",
                        "in the lance-rack, an old buckler, a lean hack, and a greyhound for",
                        "coursing. An olla of rather more beef than mutton, a salad on most",
                        "nights, scraps on Saturdays, lentils on Fridays, and a pigeon or so extra",
                        "on Sundays, made away with three-quarters of his income.")
                .collect(Collectors.joining("\n")) );
        List<String> result10 = top3("  12  14  13. 15;  12; 15 12 0 9 3 4 52  53 0 14 15 /12 /13 ;18 ");
    }


}
