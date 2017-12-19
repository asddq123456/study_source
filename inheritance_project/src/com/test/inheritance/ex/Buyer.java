package com.test.inheritance.ex;

public class Buyer {

	private int money;
	private int bonusPoint;

	public Buyer() {
		this(10000000, 0);
	}

	public Buyer(int money, int bonusPoint) {
		super();
		this.money = money;
		this.bonusPoint = bonusPoint;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	@Override
	public String toString() {
		return "Buyer [money=" + money + ", bonusPoint=" + bonusPoint + "]";
	}

	public void buy(Product pro) {

		if (money < pro.getPrice()) {
			System.out.println("잔액부족");
			return;
		}
		if (pro instanceof Printable) {
			System.out.println(pro.getPrice() + "짜리를 구매합니다.");
			this.money = this.money - pro.getPrice();
			this.bonusPoint = this.bonusPoint + pro.getBonusPoint();
		}
	}

}



