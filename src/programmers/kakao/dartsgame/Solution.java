package programmers.kakao.dartsgame;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(String dartResult) {

        double[] scores = new double[3];

        Pattern stagePattern = Pattern.compile("\\d+[SDT][*#]?");
        Matcher stageMatcher = stagePattern.matcher(dartResult);
        int scoreIndex = 0;
        while (stageMatcher.find()){
            String currentStage = stageMatcher.group();
            String score = null;
            String bonus = null;
            String option = null;

            Pattern scorePattern = Pattern.compile("\\d+");
            Matcher scoreMatcher = scorePattern.matcher(currentStage);
            if (scoreMatcher.find()){
                score = scoreMatcher.group();
            }

            Pattern bonusPattern = Pattern.compile("[SDT]");
            Matcher bonusMatcher = bonusPattern.matcher(currentStage);
            if (bonusMatcher.find()){
                bonus = bonusMatcher.group();
            }

            Pattern optionPattern = Pattern.compile("[*#]");
            Matcher optionMatcher = optionPattern.matcher(currentStage);
            if (optionMatcher.find()){
                option = optionMatcher.group();
            }

            switch (bonus){
                case "S":
                    scores[scoreIndex] = Math.pow(Double.parseDouble(score), 1.0);
                    break;
                case "D":
                    scores[scoreIndex] = Math.pow(Double.parseDouble(score), 2.0);
                    break;
                case "T":
                    scores[scoreIndex] = Math.pow(Double.parseDouble(score), 3.0);
                    break;
            }

            if (option != null){
                switch (option){
                    case "*":
                        if (0 < scoreIndex){
                            scores[scoreIndex - 1] *= 2.0;
                        }
                        scores[scoreIndex] *= 2.0;
                        break;
                    case "#":
                        scores[scoreIndex] *= -1.0;
                }

            }

            scoreIndex++;
        }

        return (int) Arrays.stream(scores).sum();
    }
}

class Test{

    public static void main(String[] args) {
        String dartResult = "1S*2T*3S";
        System.out.println(new Solution().solution(dartResult));
    }
}