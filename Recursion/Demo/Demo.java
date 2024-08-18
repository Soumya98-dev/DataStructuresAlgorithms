//stackoverflow error: memory of the computer will exceed the limit

public class Demo{
	public static void main(String[] args){
		// print(1);
		System.out.println(fib(4));
	}

	public static void print(int n){
		//base condition(stops the program from being a infinite loop)
		if(n == 5){
			return;
		}
		//recursive condition
		System.out.println(n);
		print(n + 1);
	}
	//fibonanacci nth number
	//0,1,(0+1 = 1), (1 + 1 = 2),(2+1=3),(3+2=5)
	public static int fib(int n){
		if(n < 2){
			return n;
		}
		// System.out.println(n);
		//last statement in the function call(tail recursion)
		return fib(n - 1) + fib(n - 2);
	}
}

