import java.io.Serializable;

class Event implements Serializable{
	
	String kindOfEvent;
	String date;
	int getMoney;
	int spendMoney;

	
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
		return "[행사종류 : " + kindOfEvent + ", 받은 금액 : " + getMoney + "원, "+ "  지출한 금액 : " + spendMoney + "원"+ ", date : "
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