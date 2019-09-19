class Event {
	String kindOfEvent;
	int getMoney;
	int spendMoney;
	String date;
	int index;
	
	
	//int price;
	Event(String date, int money, String kindOfEvent){
		this.kindOfEvent = kindOfEvent;
		if(money < 0) {
			this.spendMoney = money;
		}else {
			this.getMoney = money;
		}
		this.date = date;
		index++;
	}
	Event(){}
	
	@Override
	public String toString() {
		return "Event [kindOfEvent=" + kindOfEvent + ", getMoney=" + getMoney + ", spendMoney=" + spendMoney + ", date="
				+ date + "]";
	}
	
	
}