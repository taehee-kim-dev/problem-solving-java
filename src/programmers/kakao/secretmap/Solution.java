package programmers.kakao.secretmap;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        char[][] arr1Binaries = new char[n][n];
        char[][] arr2Binaries = new char[n][n];

        decryptMap(n, arr1, arr1Binaries);
        decryptMap(n, arr2, arr2Binaries);

        char[][] decryptedMap = new char[n][n];
        for (int row_i = 0; row_i < n; row_i++){
            for (int col_i = 0; col_i < n; col_i++){
                if (arr1Binaries[row_i][col_i] == '1' || arr2Binaries[row_i][col_i] == '1'){
                    decryptedMap[row_i][col_i] = '#';
                }else{
                    decryptedMap[row_i][col_i] = ' ';
                }
            }
        }

        for (int i = 0; i < n; i++){
            answer[i] = String.valueOf(decryptedMap[i]);
        }

        return answer;
    }

    private void decryptMap(int n, int[] arr, char[][] arrBinaries) {
        for (int row_i = 0; row_i < n; row_i++) {
            int secretRowNum = arr[row_i];
            String decryptedRow = String.format("%0" + n + 'd', Long.parseLong(Integer.toBinaryString(secretRowNum)));
            for (int char_i = 0; char_i < n; char_i++) {
                arrBinaries[row_i][char_i] = decryptedRow.charAt(char_i);
            }
        }
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