package kyu_5.Simple_Pig_Latin;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PigLatin {

    public static String pigIt(String str) {
        String specialCharacter = "";
        if(str.substring(str.length()-1,str.length()).matches("[!@#$%&*()_+=|<>?{}\\[\\]~-]")){
            specialCharacter = str.substring(str.length()-2,str.length());
            str = str.substring(0,str.length()-1);
        }
        String output = Stream.of(str.split(" "))
                .map(s -> s.substring(1,s.length())+s.substring(0,1)+"ay")
                .collect(Collectors.joining(" "));

        return output+specialCharacter;
    }

    public static void main(String[] args){

        String result = pigIt("Pig latin is cool");
        String result1 = pigIt("Hello world !");

    }


}
