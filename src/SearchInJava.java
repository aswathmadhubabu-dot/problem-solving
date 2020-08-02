//import javafx.util.Pair;
//
//import java.awt.*;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.*;
//import java.util.List;
//
//public class SearchInJava {
//    public static class Result {
//        private String line;
//        private String file;
//        private long number;
//
//        public Result() {
//
//        }
//
//        public String getLine() { return line; }
//        public void setLine(String value) { this.line = value; }
//        public String getFile() { return file; }
//        public void setFile(String value) { this.file = value; }
//        public long getNumber() { return number; }
//        public void setNumber(long value) { this.number = value; }
//
//        public Result(String line, String file, long number) {
//            this.line = line;
//            this.file = file;
//            this.number = number;
//        }
//    }
//    public static class SearchDTO {
//        private long total;
//        private Result[] results;
//        public long getTotal() { return total; }
//        public void setTotal(long value) { this.total = value; }
//        public Result[] getResults() { return results; }
//        public void setResults(Result[] value) { this.results = value; }
//
//        public SearchDTO(long total, Result[] results) {
//            this.total = total;
//            this.results = results;
//        }
//        public SearchDTO() {
//
//        }
//    }
//
//    private static Map<Integer, String> sources;
//    private static HashMap<String, HashSet<Integer>> index;
//    private static HashMap<String, Map<String, List<Pair<String, Integer>>>> referenceFile;
//    private static List<File> sourceFilesList = new ArrayList<>();
//
//    Map<String, List<Map<String, Integer>>> indexes = new HashMap<>();
//    private SearchInJava() {
//        sources = new HashMap<Integer, String>();
//        index = new HashMap<String, HashSet<Integer>>();
//        referenceFile = new HashMap<>();
//    }
//
//    private static void buildIndex(List<String> files) {
//        int i = 0;
//        SearchInJava sj = new SearchInJava();
//        for (String fileName : files) {
//            try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
//                sources.put(i, fileName);
//                String ln;
//                int j = 1;
//                while ((ln = file.readLine()) != null) {
//                    String[] words = ln.split("\\W+");
//                    for (String word : words) {
//                        word = word.toLowerCase();
//                        if (!referenceFile.containsKey(word)) {
//                            index.put(word, new HashSet<>());
//                            referenceFile.put(word, new HashMap<>());
//                        }
//                        index.get(word).add(i);
//                        List<Pair<String, Integer>> st = new ArrayList<>();
//                        if(referenceFile.get(word).containsKey(fileName)){
//                            st = referenceFile.get(word).get(fileName);
//                            st.add(new Pair<>(ln, j));
//                        }
//                        else {
//                            Pair<String, Integer> pv = new Pair<>(ln,j);
//                            st.add(pv);
//                        }
//                        referenceFile.get(word).put(fileName, st);
//                    }
//                    j++;
//                }
//            } catch (IOException e) {
//                System.out.println("File " + fileName + " not found. Skip it");
//            }
//            i++;
//        }
//
//    }
//
//    private static void find(String phrase) {
//        String[] words = phrase.split("\\W+");
//        HashSet<Integer> res = new HashSet<Integer>(index.get(words[0].toLowerCase()));
//        HashSet<Integer> fileres = new HashSet<Integer>(index.get(words[0].toLowerCase()));
//        SearchDTO searchDTO = new SearchDTO();
//        searchDTO.setTotal(referenceFile.get(phrase).size());
//        Map<String, List<Pair<String, Integer>>> matchedList = referenceFile.get(phrase);
//
//        List<Result> results = new ArrayList<>();
//        for(String file : matchedList.keySet()){
//            searchDTO.setTotal(matchedList.size());
//            List<Pair<String, Integer>> list = matchedList.get(file);
//            for(int i=0;i<list.size();i++){
//                Result r = new Result();
//                r.setLine(list.get(i).getKey());
//                r.setNumber(list.get(i).getValue());
//                r.setFile(file);
//                results.add(r);
//            }
//        }
//        Result[] arr = new Result[results.size()];
//        arr = results.toArray(arr);
//
//
//        searchDTO.setResults(arr);
//
//        for (String word : words) {
//            res.retainAll(index.get(word.toLowerCase()));
//            fileres.retainAll(index.get(word.toLowerCase()));
//        }
//
//        if (res.size() == 0) {
//            System.out.println("Not found");
//            return;
//        }
//        System.out.println("Found in: ");
//        for (int num : res) {
//            System.out.println("\t" + sources.get(num));
//        }
//    }
//
//    private static void getAllFilesinPath(String path) {
//        File folder = new File(path);
//
//        File[] files = folder.listFiles();
//
//        for (File file : files) {
//            if (file.isFile()) {
//                sourceFilesList.add(file);
//            } else if (file.isDirectory()) {
//                getAllFilesinPath(file.getAbsolutePath());
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//
//        String pathToSearch = "C:\\Users\\amadhuba\\Downloads\\redis-unstable";
//        String wordToSearch = "len";
//
//        System.out.println("Start search word " + wordToSearch + " in " + pathToSearch);
//
//        File searchFile = new File(pathToSearch);
//
//        if (!searchFile.exists()) {
//            System.err.println("Cannot find given file or directory to search :" + pathToSearch + ": ");
//        }
//
//        int matchesCount = 0;
//        getAllFilesinPath(pathToSearch);
//        File[] sourceFilesArray = searchFile.listFiles();
//        ArrayList<String> list = new ArrayList<>();
//        for (File nextFileName : sourceFilesList) {
//            list.add(new File(nextFileName.getAbsolutePath()).toString());
//        }
//        buildIndex(list);
//        find(wordToSearch);
//    }
//
//}
