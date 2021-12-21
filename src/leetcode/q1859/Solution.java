package leetcode.q1859;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Word {

    private final int order;
    private final String value;

    public Word(int order, String value) {
        this.order = order;
        this.value = value;
    }

    public int getOrder() {
        return order;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Word{" +
            "order=" + order +
            ", word='" + value + '\'' +
            '}';
    }
}

class Solution {

    public String sortSentence(String inputSentence) {
        List<Word> words = convertAsWords(inputSentence);
        words.sort(Comparator.comparingInt(Word::getOrder));
        List<String> rawWords = getRawWords(words);
        return String.join(" ", rawWords);
    }

    private List<Word> convertAsWords(String inputSentence) {
        List<Word> words = new ArrayList<>();

        String[] splitWordsWithOrder = inputSentence.split("\\s+");
        for (String splitWordWithOrder : splitWordsWithOrder) {
            int lastIndex = splitWordWithOrder.length() - 1;

            String rawWord = splitWordWithOrder.substring(0, lastIndex);
            int order = getOrder(splitWordWithOrder, lastIndex);

            Word word = new Word(order, rawWord);
            words.add(word);
        }

        return words;
    }

    private List<String> getRawWords(List<Word> words) {
        return words.stream()
            .map(Word::getValue)
            .collect(Collectors.toList());
    }

    private int getOrder(String splitWordWithOrder, int lastIndex) {
        String lastCharAsStr = splitWordWithOrder.substring(lastIndex);
        return Integer.parseInt(lastCharAsStr);
    }
}

class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sortSentence("is2 sentence4 This1 a3"));
    }
}
