package ex07_19;

import java.util.Arrays;

public class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // ������ ��ǰ�� �����ϱ� ���� �迭
	int i = 0; // Product cart index �迭 �� ���� index

	void buy(Product p) {
		 // 1.1 . ���� ���� ������ ������ ���ؼ� ���� ���� ������ �޼��带 �����Ѵ�.
		if(money < p.price) {return;}
		 // 1.2 . ���� ���� ����ϸ� ��ǰ�� ������ ���� ������ ����
		money = money - p.price;
		 // 1.3 . (add ) ��ٱ��Ͽ� ������ ������ ��´�
		add(p);
		
	}

	void add(Product p) {
		//1.1 i�� ���� ��ٱ����� ũ�⺸�� ���ų� ũ��
		if(i>=cart.length){
		   //1.1.1 . ������ ��ٱ��Ϻ��� 2�� ū ���ο� �迭�� �����Ѵ�
			Product[] temp = new Product[cart.length*2];
		   //1.1.2 . ������ ��ٱ����� ������ ���ο� �迭�� �����Ѵ�
			System.arraycopy(cart, 0, temp, 0, cart.length);
		   //1.1.3 . ���ο� ��ٱ��Ͽ� ������ ��ٱ��ϸ� �ٲ۴�
			cart=temp;
		}
		//1.2 (cart) . ������ ��ٱ��� �� �����Ѵ� �׸��� i�� 1���� ������Ų��
		cart[i]=p;
		i++;
		 
	} // add(Product p)

	void summary() {
		
		//1.1. ��ٱ��Ͽ� ��� ���ǵ��� ����� ����� ����Ѵ�
		System.out.println("������ ���� :"+Arrays.toString(cart));
		//1.2. ��ٱ��Ͽ� ��� ���ǵ��� ������ ��� ���ؼ� ����Ѵ�
		int sum=0;
		for(int i=0;i<this.i;i++){
			sum+=cart[i].price;
		}
		System.out.println("����� �ݾ� :"+sum);
		// 1.3 (money) . ������ ��� ���� �ݾ� �� ����Ѵ�
		System.out.println("���� �ݾ� :"+money);
	} // summary()
}





