import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
// import java.util.Map;
// import java.util.Arrays;

public class problem1 {

    public static void main(String[] args) {

        String filePath = "input.txt"; 
        StringBuilder content = new StringBuilder();

        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;

            while ((line = br.readLine()) != null) {
                content.append(line).append(" ");
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        
        String text = content.toString().trim();

       
        text = text.replaceAll("\\s+", " ");

        
        int charCount = text.replace(" ", "").length();

        
        String[] words = text.split(" ");
        int wordCount = words.length;

        
        String[] sentences = text.split("[.!?]");
        int sentenceCount = sentences.length;

        
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-z]", "");
            if (!word.isEmpty()) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Top 5 Frequent Words:");
        wordMap.entrySet()
               .stream()
               .sorted((a, b) -> b.getValue() - a.getValue())
               .limit(5)
               .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        
        System.out.println("\nReversed Sentences:");

        for (String s : sentences) {
            s = s.trim();
            StringBuilder sb = new StringBuilder(s);
            System.out.println(sb.reverse().toString());
        }

        String a = new String("Java");
        String b = new String("Java");

        System.out.println("\nString Comparison:");
        System.out.println("Using == : " + (a == b));
        System.out.println("Using equals() : " + a.equals(b));

        System.out.println("\nExplanation:");
        System.out.println("== compares memory reference.");
        System.out.println("equals() compares actual content.");

        
        System.out.println("\nFinal Counts:");
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentenceCount);
        System.out.println("Characters (excluding spaces): " + charCount);
    }
}
