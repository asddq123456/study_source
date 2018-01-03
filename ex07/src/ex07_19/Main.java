package ex07_19;

public class Main {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new TV());
		b.buy(new Computer());
		b.buy(new TV());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.summary();

	}

}
