import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PersonManager implements IInfoManager {
	Scanner scan;
	Person person;
	private ArrayList<Person> personList;
	//private String password;
	private int spendTotalSum;
	int getTotalSum;

	PersonManager() {
		scan = new Scanner(System.in);
		personList = new ArrayList<Person>(); // 지인 정보 저장

	}

	void inputPersonInfo() {
		System.out.println("지인의 이름을 입력하세요 : ");
		String name = scan.nextLine();
		System.out.println("핸드폰 번호를 입력하세요 : ");
		String phoneNumber = scan.nextLine();
		System.out.println("상대와의 관계정도를 입력하세요 (1 - 5) : ");
		int closeLevel = Integer.parseInt(scan.nextLine());

		personList.add(new Person(name, closeLevel, phoneNumber)); // 지인의 이름, 핸드폰번호, 친밀도를 입력받아
																	// 핸드폰번호를 키값으로 .. 이름, 친밀도를 밸류값 설정

	}

	@Override
	public void inputInfo() {
		System.out.println("지인의 이름을 입력하세요");
		String name = scan.nextLine();

		for (Person p : personList) {
			if (p.name.equals(name)) {
				p.inputInfo();
			}
		}
	}
	
	public void getTotal() {
		System.out.println((p.getTotalSum - p.spendTotalSum));
	}
	
	public void showAllInfo() {
		for (int i = 0; i < personList.size(); i++) {
			personList.get(i).showAllEvent();
		}
	}
	
	/*
	 * for(Map.Entry m : personMap.entrySet()) { for(Event event :
	 * ((Person)m.getValue()).eventMap) { // 어째타고 들어갑니까~
	 * 
	 * } }
	 */
	@Override
	public void modifyInfo() {
		
		for(int i =0; i < personList.size(); i++) {
			System.out.println("번호 : " + i + " / " + personList.get(i));
		}
		System.out.println("친밀도를 수정할 지인의 번호?");
		int inputNumber = scan.nextInt();
		scan.nextLine();
		System.out.println("수정할 친밀도를 입력하세요");
		int closeLevel = scan.nextInt();
		
		personList.get(inputNumber).setCloseLevel(closeLevel);
	}

	@Override
	public void searchInfo() {
		/*
		 * System.out.println("검색할 날짜를 입력하세요 : "); String date = scan.nextLine();
		 * ArrayList<Event> alist = new ArrayList<Event>();
		 * 
		 * for (int i = 0; i < eventMap.size(); i++) { if
		 * ((eventMap.get(i).date.equals(date))) { alist.add(eventMap.get(i)); } }
		 * 
		 * if (alist.size() == 0) { System.out.println("해당 날짜의 정보가 없습니다"); } else {
		 * System.out.println(alist); }
		 */
	}

	@Override
	public void removeInfo() {
		/*
		 * Set set = eventMap.keySet(); Iterator it = set.iterator();
		 * //while(it.hasNext()) { // System.out.println(eventMap.get(it.next())); //}
		 * for(Map.Entry m : eventMap.entrySet()) { System.out.println("번호 : " +
		 * m.getKey() + " / " + (Event)m.getValue()); }
		 * System.out.println("지울 이벤트 번호를 입력하세요!"); int inputNumber = scan.nextInt();
		 * eventMap.keySet().remove((inputNumber)); // 간접적으로 접근
		 * System.out.println("삭제 되었습니다");
		 */
	}
}