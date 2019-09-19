import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Person implements IInfoManager {
	Scanner scan = new Scanner(System.in);
	String name;//
	String phoneNumber;
	int count;
	// String phoneNumber;// 살려야 되는거 아님?
	int closeLevel;//
	int spendSumMoney;//
	int getSumMoney;//
	ArrayList<Event> eventlist = new ArrayList<Event>();//
	Event event;

	Person() {

	}

	Person(String name, int closeLevel, String phoneNumber) {
		this.name = name;
		this.closeLevel = closeLevel;
		this.phoneNumber = phoneNumber;
		count = 0;
	}

	void getSum() {
		System.out.println(this.name + "님이 나에게 준 총 금액 : " + this.getSumMoney);
	}

	void spendSum() {
		System.out.println(this.name + "님에게 받은 총 금액 : " + this.spendSumMoney);
	}

	@Override
	public void inputInfo() {
		System.out.println("날짜를 입력하세요 : ");
		String date = scan.nextLine();
		System.out.println("금액을 입력하세요 : ");
		int money = Integer.parseInt(scan.nextLine());
		System.out.println("경조사 종류를 입력하세요 : ");
		String kindOfEvent = scan.nextLine();
		
		
		
		eventlist.add(new Event(date, money, kindOfEvent));
		
		if(money < 0) {
			this.spendSumMoney += money;
		}else {
			this.getSumMoney += money;
		}
	}

	@Override
	public void modifyInfo() {
		for(int i =0; i < eventlist.size(); i++) {
			System.out.println("번호 : " + i + " / " + eventlist.get(i));
		}
		System.out.println("금액을 수정하고 싶은 이벤트 번호를 입력하세요");
		int inputNumber = scan.nextInt();
		scan.nextLine();
		System.out.println("수정할 금액을 입력하세요");
		System.out.println("지출한 금액: ");
		int outmoney = scan.nextInt();
		scan.hasNextLine();
		
		System.out.println("들어온 금액: ");
		int inmoney = scan.nextInt();
		
		
		
		eventlist.get(inputNumber).setGetMoney(inmoney);
		eventlist.get(inputNumber).setSpendMoney(outmoney);
		
	}

	@Override
	public void searchInfo() {
		System.out.println("검색할 날짜를 입력하세요 : ");
		String date = scan.nextLine();
		ArrayList<Event> alist = new ArrayList<Event>();
		
		for (int i = 0; i < eventlist.size(); i++) {
			if ((eventlist.get(i).date.equals(date))) {
				alist.add(eventlist.get(i));
			}
		}
		
		if (alist.size() == 0) {
			System.out.println("해당 날짜의 정보가 없습니다");
		} else {
			System.out.println(alist);
		}
	}

	@Override
	public void removeInfo() {
		for(int i=0; i < eventlist.size(); i++) {
			System.out.println("번호 : " + i + " / " + eventlist.get(i));
		}
		System.out.println("지울 이벤트 번호를 입력하세요!");
		int inputNumber = scan.nextInt();
		eventlist.remove(inputNumber); // 간접적으로 접근
		System.out.println("삭제 되었습니다");
	}
	
	public void showAllEvent() {
		for(Event e : eventlist) {
			System.out.println(e);
		}
	}

	public void setCloseLevel(int closeLevel) {
		this.closeLevel = closeLevel;
	}
}