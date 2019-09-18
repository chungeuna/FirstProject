import java.util.HashMap;

class Person {
	String name;// 
	//String phoneNumber;//
	int closeLevel;//
	int spendSumMoney;//
	int getSumMoney;//
	HashMap<String,Event> eventMap;//
	
	Person(){
		
	}
	Person(String name, int closeLevel) {
		this.name = name;
		//this.phoneNumber = phoneNumber;
		this.closeLevel = closeLevel;
		eventMap = new HashMap<String, Event>();
	}
	
}