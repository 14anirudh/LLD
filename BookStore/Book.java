package BookStore;
import java.util.Map;
import java.util.HashMap;

public class Book {
    private final String  id ;
    private final String title ;
    private final String content;
    private final Map<String , Integer> wordCountMap ;

    public Book(String id , String title , String content){
        this.id = id;
        this.title = title;
        this.content = content;
        this.wordCountMap = calculateFrequency(content);
    }
   
    private Map<String , Integer> calculateFrequency(String content){
       Map<String , Integer> freqMap = new HashMap<>();
       String[] words = content.toLowerCase().split("\\W+");
       for(String word : words){
         freqMap.put(word , freqMap.getOrDefault(word , 0)+1);
       }

       return freqMap;
    }

    public int getWordCount(String word){
        return wordCountMap.getOrDefault(word , 0);
    }

    public String getId() {
        return id;
    }

}
