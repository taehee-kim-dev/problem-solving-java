package programmers.kakao.tuple;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<HashSet<Integer>> sets = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\{[\\d,]+\\}");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            String found = matcher.group();
            found = found.replaceAll("[\\{\\}]", "");
            String[] numsStr = found.split(",");
            HashSet<Integer> set
                = (HashSet<Integer>) Arrays.stream(numsStr).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toSet());
            sets.add(set);
        }

        sets.sort(new Comparator<HashSet<Integer>>() {
            @Override
            public int compare(HashSet<Integer> o1, HashSet<Integer> o2) {
                return Integer.compare(o1.size(), o2.size());
            }
        });

        answer.addAll(sets.get(0));

        for (int i = 1; i < sets.size(); i++){
            sets.get(i).removeAll(sets.get(i - 1));
            answer.addAll(sets.get(i));
            sets.get(i).addAll(answer);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Test{

    public static void main(String[] args) {
        String[] s = {
            "{{2},{2,1},{2,1,3},{2,1,3,4}}",
            "{{1,2,3},{2,1},{1,2,4,3},{2}}",
            "{{20,111},{111}}",
            "{{123}}",
            "{{4,2,3},{3},{2,3,4,1},{2,3}}"
        };
        for (String input : s) {
            System.out.println(Arrays.toString(new Solution().solution(input)));
        }
    }
}