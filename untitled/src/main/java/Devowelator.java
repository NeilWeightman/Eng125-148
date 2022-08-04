public class Devowelator {
    public static void main(String[] args) {
        System.out.println(removeVowels("the quick brown fox"));
    }

    public static String removeVowels(String theString){
        return theString
                .chars()
                .map(c -> c=='a'||c=='e'||c=='i'||c=='o'||c=='u'?'?':c)
                .collect(StringBuilder::new,
                        (x,y) -> x.append((char)y),
                        (a,b) -> a.append(b))
                .toString();
    }
}
