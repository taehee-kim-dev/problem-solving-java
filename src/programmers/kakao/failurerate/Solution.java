package programmers.kakao.failurerate;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    private static class FailureInform {

        private final int stageNumber;
        private double failureRate;

        public FailureInform(int stageNumber, int numberOfChallengingUsers,
            int numberOfClearedUsers) {
            this.stageNumber = stageNumber;
            this.setFailureRate(numberOfChallengingUsers, numberOfClearedUsers);
        }

        private void setFailureRate(int numberOfChallengingUsers, int numberOfClearedUsers) {
            if (numberOfChallengingUsers + numberOfClearedUsers == 0){
                failureRate = 0.0;
            }else{
                this.failureRate =
                    (double) numberOfChallengingUsers / (double) (numberOfChallengingUsers + numberOfClearedUsers);
            }
        }
    }

    public int[] solution(int N, int[] stages) {

        int[] answer = new int[N];
        int[] clearedUsersForEachStage = new int[N];
        int[] challengingUsersForEachStage = new int[N];

        for (int challengingStageNumber : stages) {
            for (int clearedStageIndex = 0; clearedStageIndex < challengingStageNumber - 1; clearedStageIndex++) {
                clearedUsersForEachStage[clearedStageIndex] += 1;
            }
            if (challengingStageNumber < N + 1) {
                challengingUsersForEachStage[challengingStageNumber - 1] += 1;
            }
        }

        ArrayList<FailureInform> failureInforms = new ArrayList<>();
        for (int stageIndex = 0; stageIndex < N; stageIndex++) {
            failureInforms.add(new FailureInform(
                stageIndex + 1,
                challengingUsersForEachStage[stageIndex],
                clearedUsersForEachStage[stageIndex]
            ));
        }

        failureInforms.sort((beforeFailureInform, afterFailureInform) -> {
            if (beforeFailureInform.failureRate == afterFailureInform.failureRate) {
                return Integer
                    .compare(beforeFailureInform.stageNumber, afterFailureInform.stageNumber);
            } else {
                return -1 * Double.compare(beforeFailureInform.failureRate,
                    afterFailureInform.failureRate);
            }
        });

        for (int answerIndex = 0; answerIndex < N; answerIndex++){
            answer[answerIndex] = failureInforms.get(answerIndex).stageNumber;
        }

        return answer;
    }
}


class Test {

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        // result : [3, 4, 2, 1, 5]
        System.out.println(Arrays.toString(new Solution().solution(N, stages)));

    }
}