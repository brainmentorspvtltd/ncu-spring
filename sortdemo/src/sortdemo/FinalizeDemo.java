package sortdemo;

class A{
	static A obj;
	int x ;
	A(){
		 x = 100;
		System.out.println("A Cons Call");
	}
	void show() {
		System.out.println("x is "+x);
	}
	@Override
	protected void finalize() {
		obj = this;
		System.out.println("A Bye "+this);
	}
}

public class FinalizeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A obj = new A();
		obj = null;
		
		System.gc();
		for(int i = 1; i<=10; i++) {
			
			System.out.println("I is "+i);
		}
		obj = A.obj;
		obj.show();
	}

}
