package Bits;

public class BitOperations {

    public static void oddOrEven(int n){
        if((n&1)==0) System.out.println("EVEN");
        else System.out.println("ODD");
    }

    public static void getBit(int n,int i){
        int bitMask = 1<<i;
        if((n&bitMask)==0) System.out.println(0);
        else System.out.println(1);
    }

    public static void setBit(int n,int i){
        int bitMask = 1<<i;
        System.out.println(n|bitMask);
    }

    public static void clearBit(int n,int i){
        int bitMask = ~(1<<i);
        System.out.println(n&bitMask);
    }

    public static void main(String[] args) {
        oddOrEven(11);
        getBit(11,1);
        setBit(11,2);
        clearBit(5,2);

    }
}
