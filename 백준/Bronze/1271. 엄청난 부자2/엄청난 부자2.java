import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BigInteger A;
		BigInteger B;
		Scanner sc = new Scanner(System.in);
		A = sc.nextBigInteger();
		B = sc.nextBigInteger();
		
		System.out.println(A.divide(B));
		System.out.println(A.mod(B));

	}

}
