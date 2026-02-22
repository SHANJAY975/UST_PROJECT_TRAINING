package lamdaandstreams;

public class Vowels {
    public static int countVowels(String s){
        int count = 0;
        String vowels = "AEIOUaeiou";
        for(char ch:s.toCharArray()){
            if(vowels.indexOf(ch) !=-1){
                count++;
            }
        }
        return  count;
    }
}
