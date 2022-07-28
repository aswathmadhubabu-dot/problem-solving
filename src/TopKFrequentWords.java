import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        List<String> result = new ArrayList<>();

        PriorityQueue<Word> priorityQueue = new PriorityQueue<>(
                (Word word1, Word word2) -> {
                    if (word1.frequency > word2.frequency)
                        return -1;

                    if (word1.frequency == word2.frequency) {
                        if(word1.word.compareTo(word2.word) <= 0) {
                            return -1;
                        }
                    }
                    return 1;
                }
        );

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "-");
            System.out.print(entry.getValue());
            System.out.println();

            priorityQueue.add(new Word(entry.getKey(), entry.getValue()));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while (k > 0) {
            System.out.println(priorityQueue.size());
            result.add(priorityQueue.poll().word);
            k--;
        }

        return result;
    }

    class Word {
        String word;
        int frequency;

        public Word(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
        String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        System.out.println(topKFrequentWords.topKFrequent(input, k));
    }

}
