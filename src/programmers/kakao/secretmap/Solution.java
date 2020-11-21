package programmers.kakao.secretmap;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        return answer;
    }


}

class Test{
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] result = new Solution().solution(n, arr1, arr2);
        for (String s : result) {
            System.out.println(s);
        }
        // ["#####","# # #", "### #", "# ##", "#####"]
    }
}