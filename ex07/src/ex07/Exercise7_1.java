package ex07;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {

		for (int index = 0; index < cards.length; index++) {

			int num = index % 10 + 1;
			boolean isKwang = (index < 10 && (num == 1 || num == 3 || num == 8)) ? true : false;

			cards[index] = new SutdaCard(num, isKwang);

		}

	}
}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	// info() Object toString() . 대신 클래스의 을 오버라이딩했다
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

public class Exercise7_1 {
	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");
	}
}
