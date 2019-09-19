import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Person implements IInfoManager {
	Scanner scan = new Scanner(System.in);
	int count;
	String name;//
	// String phoneNumber;//
	int closeLevel;//
	int spendSumMoney;//
	int getSumMoney;//
	HashMap<Integer, Event> eventMap = new HashMap<Integer, Event>();//
	Event event;

	Person() {

	}

	Person(String name, int closeLevel) {
		this.name = name;
		this.closeLevel = closeLevel;
		count = 0;
		event = new Event();
		// eventMap = new HashMap<Integer, Event>();
	}

	void getSum() {

	}

	void spendSum() {

	}

	@Override
	public void inputInfo() {
		System.out.println("날짜를 입력하세요 : ");
		String date = scan.nextLine();
		System.out.println("금액을 입력하세요 : ");
		int money = Integer.parseInt(scan.nextLine());
		System.out.println("경조사 종류를 입력하세요 : ");
		String kindOfEvent = scan.nextLine();
		eventMap.put(count++, new Event(date, money, kindOfEvent));
	}

	@Override
	public void modifyInfo() {
		
	}

	@Override
	public void searchInfo() {
		System.out.println("검색할 날짜를 입력하세요 : ");
		String date = scan.nextLine();
		ArrayList<Event> alist = new ArrayList<Event>();
		// if(eventMap.containsValue()) {
		// System.out.println("data 잘 나옴");
		// }else {
		// System.out.println("여기는 else");
		// }
		for (int i = 0; i < eventMap.size(); i++) {
			if ((eventMap.get(i).date.equals(date))) {
				alist.add(eventMap.get(i));
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
		Set set = eventMap.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println("번호: " + eventMap.get(it.next()));
		}
		System.out.println("지울 이벤트 번호를 입력하세요!");
		int inputNumber = scan.nextInt();
		eventMap.keySet().remove((inputNumber));	// 간접적으로 접근
		for(int i = 0; i < eventMap.size(); i++) {
			System.out.println(eventMap.get(i));
		}
	}

}