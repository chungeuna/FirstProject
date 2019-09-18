class Event {
	String kindOfEvent;
	int getMoney;
	int spendMoney;
	String date;
	//int price;
	Event(String kindOfEvent, int money, String date){
		this.kindOfEvent = kindOfEvent;
		if(money < 0) {
			this.spendMoney = money;
		}else {
			this.getMoney = money;
		}
		this.date = date;
	}
}