import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PersonManager implements IInfoManager, Serializable {
	
	static transient Scanner scan;
	Person person;
	
	private ArrayList<Person> personList=new ArrayList<Person>();
	private int spendTotalSum;
	int getTotalSum;
	Menu m;

	PersonManager() {
		
	}
	
	void menu() {
		m.showPersonManagerDisplay();
	}

	void inputPersonInfo() {
		scan = new Scanner(System.in);
		System.out.println("지인의 이름을 입력하세요 : ");
		String name = scan.nextLine();
		System.out.println("핸드폰 번호를 입력하세요 : ");
		String phoneNumber = scan.nextLine();
		System.out.println("상대와의 관계정도를 입력하세요 (1 - 5) : ");
		int closeLevel = Integer.parseInt(scan.nextLine());

		personList.add(new Person(name, closeLevel, phoneNumber)); // 지인의 이름, 핸드폰번호, 친밀도를 입력받아
	}

	@Override
	public void inputInfo() {
		scan = new Scanner(System.in);
		System.out.println("지인의 이름을 입력하세요");
		String name = scan.nextLine();

		for (Person p : personList) {
			if (p.name.equals(name)) {
				p.inputInfo();
			}else {
				System.out.println("지인의 정보가 없습니다");
			}
		}
	}
	

	public void eventlist() {
		scan = new Scanner(System.in);
		System.out.println("지인의 이름을 입력하세요");
		String name = scan.nextLine();

		for (Person p : personList) {
			if (p.name.equals(name)) {
				p.showAllEvent();
			}
		}
	}
	
	public void suggestMoney() {
		scan = new Scanner(System.in);
		System.out.println("지인의 이름을 입력하세요");
		String name = scan.nextLine();
		
		for (Person p : personList) {
			if (p.name.equals(name)) {
				p.suggestMoney();
			} else if (p.eventlist.isEmpty()) {
				System.out.println("신사임당 1장!");
			}
		}
	}
	
	public void getTotal() {
		int sumOfexpense =0;
		int sumOfincome =0;
		
		for (Person p : personList) {
			sumOfexpense+=p.spendSumMoney;
			sumOfincome +=p.getSumMoney;
		}
		
		this.getTotalSum = sumOfincome;
		this.spendTotalSum = sumOfexpense;
				
		System.out.println("총 받은금액: " + getTotalSum);
		System.out.println("총 지출한 금액: " + spendTotalSum);
	}
	
	public void showAllInfo() {
		for(int i =0; i < personList.size(); i++) {
			System.out.println("번호 : " + i + " / " + personList.get(i));
		}
	}
	
	@Override
	public void modifyInfo() {
		scan = new Scanner(System.in);
		
		for(int i =0; i < personList.size(); i++) {
			System.out.println("번호 : " + i + " / " + personList.get(i));
		}
		System.out.println("친밀도를 수정할 지인의 번호를 입력하세요 : ");
		int inputNumber = scan.nextInt();
		scan.nextLine();
		System.out.println("수정할 친밀도를 입력하세요 : ");
		int closeLevel = scan.nextInt();
		
		personList.get(inputNumber).setCloseLevel(closeLevel);
	}

	@Override
	public void searchInfo() {
		scan = new Scanner(System.in);
		System.out.println("검색할 핸드폰 번호를 입력하세요 : ");
		String phoneNumber = scan.nextLine();
		ArrayList<Person> plist = new ArrayList<Person>();
		
		for (int i = 0; i < personList.size(); i++) {
			if ((personList.get(i).phoneNumber.equals(phoneNumber))) {
				plist.add(personList.get(i));
			}
		}
		if (plist.size() == 0) {
			System.out.println("해당 핸드폰 번호의 정보가 없습니다");
		} else {
			System.out.println(plist);
		}
	}

	@Override
	public void removeInfo() {
		scan = new Scanner(System.in);
		for(int i=0; i < personList.size(); i++) {
			System.out.println("번호 : " + i + " / " + personList.get(i));
		}
		System.out.println("삭제할 지인의 번호를 입력하세요!");
		int inputNumber = scan.nextInt();
		personList.remove(inputNumber); // 간접적으로 접근
		System.out.println("삭제 되었습니다");
	}
	
	public void removeEventInfo() {
		scan = new Scanner(System.in);
		System.out.println("지인의 이름을 입력하세요");
		String name = scan.nextLine();

		for (Person p : personList) {
			if (p.name.equals(name)) {
				p.removeInfo();
			}
		}
	}
	
	public void modifyEventInfo() {
		scan = new Scanner(System.in);
		System.out.println("지인의 이름을 입력하세요");
		String name = scan.nextLine();

		for (Person p : personList) {
			if (p.name.equals(name)) {
				p.modifyInfo();
			}
		}
	}

	public ArrayList<Person> getPersonList() {
		return personList;
	}
	
	
}