package programmers.kakao.stringcompression;


import java.util.Arrays;

// 압축했을 때, 가장 짧은 것의 길이는?
class Solution {
    public int solution(String s) {

        int[] compLengths = new int[s.length()];

        for (int compSize = 1; compSize <= s.length(); compSize++){

            String initialStr = s;
            String totalCompStr = "";
            String curCompStr = "";

            int curCompCount = 1;

            int startIndex = 0;
            int endIndex = compSize;

            while (endIndex <= s.length()){

                String subS = s.substring(startIndex, endIndex);
                initialStr = s.substring(endIndex);

                if (!curCompStr.equals(subS)){

                    if (curCompCount > 1){
                        totalCompStr += curCompCount;
                    }
                    totalCompStr += curCompStr;

                    curCompStr = subS;
                    curCompCount = 1;
                }else{
                    curCompCount += 1;
                }

                startIndex = endIndex;
                endIndex += compSize;
            }
            if (curCompCount > 1){
                totalCompStr += curCompCount;
            }
            totalCompStr += curCompStr;
            totalCompStr += initialStr;
            compLengths[compSize - 1] = totalCompStr.length();
        }

        Arrays.sort(compLengths);
        return compLengths[0];
    }
}

class Test{

    public static void main(String[] args) {
        String s = "abcabcdede";
        System.out.println(new Solution().solution(s));
        // 7
    }
}