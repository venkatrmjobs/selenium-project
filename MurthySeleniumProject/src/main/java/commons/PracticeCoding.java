package commons;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class PracticeCoding {

    public static boolean cheeckPalindrome(String value ){

        String tempValue = "";
        String[] characters = value.split("");
        for(int i= characters.length-1; i>=0; i-- ){
            tempValue = tempValue.concat(characters[i]);
        }
        if (tempValue.equalsIgnoreCase(value)) {
            return true;
        }
        return false;
    }

    public static boolean checkAnagram(String originalString, String reverseString){
        String tempsString = "";
        String[] characters = originalString.split("");

        for(int i = characters.length-1; i>=0; i--){
            tempsString = tempsString.concat(characters[i]);
        }
        if(tempsString.equalsIgnoreCase(reverseString)){
            return true;
        }
        return false;
    }

    public static void removeDuplicateCharacter(String value){
        String[] characters = value.split("");
        Set<String> result = new LinkedHashSet<>();
        for(String c : characters){
            if(result.add(c)){
                System.out.print(c);
            }
        }
    }

    public static void findDuplicates (String value){
        String[] characters = value.split("");
        Set<String> result = new LinkedHashSet<>();
        for(String c : characters){
            if(!result.add(c)){
                System.out.print(c);
            }
        }
    }

    public static String reverseStringWords(String value) {

        String tempString = "";
        String[] characters = value.split(" ");
        for (int i = characters.length - 1; i >= 0; i--) {
            tempString = tempString.concat(characters[i] + " ");
        }
        return tempString;
    }

    public static String reverseStringWithinStrings(String value){

        String tempString = "";
        String[] characters = value.split(" ");
        for(int i = 0; i< characters.length; i++){
            String str = characters[i]+ " ";
            String[] reverse = str.split("");
            for(int j = reverse.length-1; j>=0; j--){
                tempString = tempString.concat(reverse[j]);
            }
        }
        return tempString;
    }


    public static Map<String, Integer> vowelAndConsonants(String value){
        Map<String, Integer> result = new HashMap<>();

        int vowels = 0;
        int consanants = 0;

        String[] characters = value.split("");
        for(String c : characters){
            switch (c){
                case "a":
                case "e":
                case "i":
                case "o":
                case"u":
                    vowels ++;
                    break;
                    default:
                        consanants ++;
            }

        }
        result.put("vowels count", vowels);
        result.put("consonants count", consanants);
        return result;
    }

    public static void main (String[] args){

        System.out.println(reverseStringWithinStrings("Naga Siva Karthik upputuri"));
    }

}
