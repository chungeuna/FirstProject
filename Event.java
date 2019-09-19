class Event {
	String kindOfEvent;
	int getMoney;
	int spendMoney;
	String date;
	//int price;
	Event(String date, int money, String kindOfEvent){
		this.kindOfEvent = kindOfEvent;
		if(money < 0) {
			this.spendMoney = money;
		}else {
			this.getMoney = money;
		}
		this.date = date;
	}
	Event(){}
	
	@Override
	public String toString() {
		return "[kindOfEvent : " + kindOfEvent + ", getMoney : " + getMoney + ", spendMoney : " + spendMoney + ", date : "
				+ date + "]";
	}
	
	public void setKindOfEvent(String kindOfEvent) {
		this.kindOfEvent = kindOfEvent;
	}
	public void setGetMoney(int getMoney) {
		this.getMoney = getMoney;
	}
	public void setSpendMoney(int spendMoney) {
		this.spendMoney = spendMoney;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
}