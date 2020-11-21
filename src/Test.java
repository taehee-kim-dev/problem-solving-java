public class Test {


    public static void main(String[] args) {

        int test = 9;
        String filledWithZeros = String.format("%05d", Integer.parseInt(Integer.toBinaryString(test)));
        System.out.println(filledWithZeros);
    }
}
