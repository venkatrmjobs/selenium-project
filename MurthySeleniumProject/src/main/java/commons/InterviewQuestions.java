package commons;

import java.util.*;

public class InterviewQuestions {
    public static boolean checkPalindrome(String value){
        String reverseString = "";
        String[] a = value.split("");
        for(int i = a.length-1; i>=0; i--){
            reverseString = reverseString.concat(a[i]);
        }
        if (value.equalsIgnoreCase(reverseString)){
            return true;
        }
        return false;
    }
    public static boolean checkAnagram (String originalValue, String reverseValue){
        String tempValue = "";
        String[] characters = originalValue.split("");
        for(int i = characters.length-1; i>=0; i--){
            tempValue = tempValue.concat(characters[i]);
        }
        if(tempValue.equalsIgnoreCase(reverseValue)){
            return true;
        }
        return false;
    }
    public static String removeDuplicateCharacters(String originalString){
        String[] characters = originalString.split ("");
        for(int i = 0; i<characters.length; i++){
            for(int j = i+1; j< characters.length; j++){
                if (characters[i].equals(characters[j])){
                    String s = characters[i];
                    originalString = originalString.replace(s, "");
                }
            }
        }
        return originalString.substring(0,1);
    }

    /*
    with set
     */
    public static void removeDuplicates(String value){
        Set<String> has = new LinkedHashSet<>();
        String[] characters = value.split("");

        for(String s : characters){
            if(has.add(s)){
                System.out.print(s);
            }
        }

    }
    public static String FindDuplicateCharacters(String value){
        String tempValue = "";
        String[] characters = value.split ("");
        for(int i = 0; i<characters.length; i++){
            for(int j = i+1; j< characters.length; j++){
                if (characters[i].equals(characters[j])){
                    if(!tempValue.contains(characters[i])){
                        tempValue =  tempValue.concat(characters[i]);
                    }
                }
            }
        }
        System.out.println(tempValue);
        return tempValue;
    }
    public static String reverseString(String value){
        String reverseString = "";
        String[] characters = value.split("");
        for(int i = characters.length-1; i >=0; i--){
            reverseString = reverseString.concat(characters[i]);
        }
        return reverseString;
    }
    public static String reverseStringWords(String value){

        String reverseString = "";
        String[] characters = value.split(" ");
        for(int i = characters.length-1; i>=0; i--){
            reverseString = reverseString.concat(characters[i] + " ");
        }
        return reverseString;

    }
    public static String revereWithinString(String value){
        String reversString = "";
        String[] characters = value.split(" ");
        for(int i = 0; i<=characters.length-1; i++){
            String str = characters[i] + " ";
            String[] rev = str.split("");
            for(int j = rev.length-1; j>=0; j--){
                reversString = reversString.concat(rev[j]);
            }
        }
        return reversString;
    }
    public static Map<String, Integer> vowelAndConsonants(String value){
        Map<String, Integer> result = new HashMap<String, Integer>();
        String[] characters = value.split("");
        int vowels =0;
        int consonants = 0;
        for(String c : characters){
            switch (c){
                case "a":
                case "e":
                case"i":
                case"o":
                case"u":
                    vowels ++;
                    break;
                default:
                    consonants ++;

            }
        }
        result.put("vowels count", vowels);
        result.put("consonants count", consonants);
        return result;
    }
    public static int numberOfOccurrence(String value, String character){

        String[] characters = value.split("");
        int charCount = 0;
        for(int i = 0; i<characters.length; i++){
            if (characters[i].equalsIgnoreCase(character)){
                charCount++;
            }
        }
        return charCount;
    }
    public static void findDuplicateInArray(){
        int[] arr = {1, 2, 3, 4, 5, 8, 9, 10, 3, 3, 2, 5};
        Set<Integer> values = new LinkedHashSet<>();
        for(Integer i : arr){
            if(!values.add(i)){

            }
        }
    }
    public static boolean  armStrongNumber(int a){
        String value = Integer.toString(a);
        String[] characters = value.split("");
        int sum = 0;
        for(String s : characters){
            sum = sum +(Integer.parseInt(s)* Integer.parseInt(s)*Integer.parseInt(s));
        }
        if(sum == a){
            return true;
        }
        System.out.println(sum);
        return false;
    }
    public static void missingNumbers () {
        int value[] = {3, 4, 5, 7, 8, 9, 12, 13, 56, 89, 76, 55, 15};
        Arrays.sort(value);
        int highestValue = Arrays.stream(value).max().getAsInt();
        for (int j = 0; j <= highestValue; j++) {
            int i = j;
            if (Arrays.stream(value).anyMatch(x -> x == i)) {
//                System.out.println("Available Number: " + i);
            }
            else{
                System.out.println("Missing Number: " + i);
            }
        }
    }
    public static boolean primeNumber(int a){
        for(int i =2; i<=a/2; i++){
            if(a % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void findPairValuesOfGivenSum(){
        int sum = 9;
        int []value = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i<value.length; i++){

            for (int j = 1; j< value.length; j++){
                if (value[i] + value [j] == sum){
                    System.out.println (" pair values are " +  value[i] +", " +  value [j] );
                }
            }
        }

    }
    public static void sortAnArray(){
        int [] array = {6, 4, 2, 1, 7};
        int temp;
        for(int i = 1; i<array.length; i++){
            for(int j = i ; j>0; j--){
                if(array[j]< array[j-1]){
                    temp = array[j];
                    array[j] = array [j-1];
                    array[j-1] = temp ;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    public static void mergeTwoArrays() {
        int[] a = {4, 5, 6, 7, 8};
        int[] b = {4, 6, 8, 9, 10};

        int length = a.length + a.length;
        int[] result = new int[length];

        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);

    }
    public static void main (String args[]){
//        removeDuplicates("Murthy Testing");
//       System.out.println(primeNumber(37));
       mergeTwoArrays();
    }
}
