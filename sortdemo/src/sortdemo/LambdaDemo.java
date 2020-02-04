package sortdemo;

@FunctionalInterface
interface Calc{
	int add(int x, int y);
}
class MyCalc implements Calc{
	@Override
	public int add(int x, int y) {
		return x + y;
	}
}
public class LambdaDemo {

	public static void main(String[] args) {
		//Calc c = new MyCalc();
		Calc c = (x,y)->x+y;

	}

}
