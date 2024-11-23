package Test;

public class Test11 {

	public static void main(String[] args) {
		Test11 a =new Test11();
		a.primeTest(31);
	
}
	public void primeTest(int number) {
		int count=0;
		for(int i=2;i<number;i++) {
			if(number%i==0) {
				count++;
			}
		}
		if(count==0) {
			System.out.println(number+ " :number is prime");
		}
		else {
			System.out.println(number+ " :number is  not prime");
		}
	}
}
