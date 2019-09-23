import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Person implements IInfoManager, Serializable{
	
	static transient Scanner scan;
	
	Event event;
	
	String name;
	String phoneNumber;
	int count;
	int closeLevel;
	int spendSumMoney;
	int getSumMoney;
	int countPlus;
	int countMinus;
	
	ArrayList<Event> eventlist = new ArrayList<Event>();//

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
		System.out.println(this.name + "님에게 준 총 금액 : " + this.spendSumMoney);
	}

	@Override
	public void inputInfo() {
		scan = new Scanner(System.in);
		System.out.println("날짜를 입력하세요 : ");
		String date = scan.nextLine();
		System.out.println("금액을 입력하세요 : ");
		int money = Integer.parseInt(scan.nextLine());
		System.out.println("경조사 종류를 입력하세요 : ");
		String kindOfEvent = scan.nextLine();
		
		eventlist.add(new Event(date, money, kindOfEvent));
		
		if(money < 0) {
			this.spendSumMoney += money;
			this.countMinus++;
		}else {
			this.getSumMoney += money;
			this.countPlus++;
		}
	}

	@Override
	public void modifyInfo() {
		scan = new Scanner(System.in);
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
		scan = new Scanner(System.in);
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
		scan = new Scanner(System.in);
		for(int i=0; i < eventlist.size(); i++) {
			System.out.println("번호 : " + i + " / " + eventlist.get(i));
		}
		System.out.println("지울 이벤트 번호를 입력하세요!");
		int inputNumber = scan.nextInt();
		eventlist.remove(inputNumber);
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

	@Override
	public String toString() {
		return "이름: " + name + ", 핸드폰번호" + phoneNumber + 
				 ", 친밀도: " + closeLevel + ", 총 지출한 금액: " + spendSumMoney + ", 총 받은 금액: " + getSumMoney;
				
	}
	
	
	public void suggestMoney () {
		String str = "";
		
		System.out.println("받은 횟수 " +countPlus);
		System.out.println("돈낸 횟수 " +countMinus);
		System.out.println("총 받은 금액 "+getSumMoney);
		System.out.println("총 지출 금액 "+spendSumMoney);

		if (this.getSumMoney == 0 && this.spendSumMoney==0) {
			if(this.closeLevel >= 4) {
				str ="신사임당 2장";
			} else {
				str ="신사임당 1장!";
			}
		} else if ( this.getSumMoney==0 && this.spendSumMoney!=0) {		// 받은것 0	 쓴것 있음
			System.out.println("WARNING! 경조사에 불참할 핑계를 대십시오!");
			str = " 내가 돈을 받는 Case";
		} else if ( this.getSumMoney!=0 && this.spendSumMoney==0 ) {	// 받은것 있음	 쓴것 0
			int result = (int)getSumMoney / countPlus;
			str = ""+result+"원";
		} else if (this.getSumMoney!=0 && this.spendSumMoney!=0) {
			if (countPlus == countMinus) {
				int result = (int) (spendSumMoney+getSumMoney) / 1;
				str = ""+result+"원";
			} else {int result = (int) (spendSumMoney+getSumMoney) / (countPlus-countMinus);
				str = ""+result+"원";
			}
			
		}
		System.out.println("적정 금액은 "+str+" 입니다.");
		
	}
	
}