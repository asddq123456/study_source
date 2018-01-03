package ex07_19;

import java.util.Arrays;

public class Buyer {
	int money = 1000;
	Product[] cart = new Product[3]; // 구입한 제품을 저장하기 위한 배열
	int i = 0; // Product cart index 배열 에 사용될 index

	void buy(Product p) {
		 // 1.1 . 가진 돈과 물건의 가격을 비교해서 가진 돈이 적으면 메서드를 종료한다.
		if(money < p.price) {return;}
		 // 1.2 . 가진 돈이 충분하면 제품의 가격을 가진 돈에서 빼고
		money = money - p.price;
		 // 1.3 . (add ) 장바구니에 구입한 물건을 담는다
		add(p);
		
	}

	void add(Product p) {
		//1.1 i의 값이 장바구니의 크기보다 같거나 크면
		if(i>=cart.length){
		   //1.1.1 . 기존의 장바구니보다 2배 큰 새로운 배열을 생성한다
			Product[] temp = new Product[cart.length*2];
		   //1.1.2 . 기존의 장바구니의 내용을 새로운 배열에 복사한다
			System.arraycopy(cart, 0, temp, 0, cart.length);
		   //1.1.3 . 새로운 장바구니와 기존의 장바구니를 바꾼다
			cart=temp;
		}
		//1.2 (cart) . 물건을 장바구니 에 저장한다 그리고 i의 1값을 증가시킨다
		cart[i]=p;
		i++;
		 
	} // add(Product p)

	void summary() {
		
		//1.1. 장바구니에 담긴 물건들의 목록을 만들어 출력한다
		System.out.println("구입한 물건 :"+Arrays.toString(cart));
		//1.2. 장바구니에 담긴 물건들의 가격을 모두 더해서 출력한다
		int sum=0;
		for(int i=0;i<this.i;i++){
			sum+=cart[i].price;
		}
		System.out.println("사용한 금액 :"+sum);
		// 1.3 (money) . 물건을 사고 남은 금액 를 출력한다
		System.out.println("남은 금액 :"+money);
	} // summary()
}





