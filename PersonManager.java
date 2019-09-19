import java.util.HashMap;
import java.util.Scanner;

public class PersonManager {
	Scanner scan;
	private HashMap<String,Person> personMap;
	Person person;
	private int password;
	private int spendTotalSum;
	int getTotalSum;
	
	
	PersonManager(){
		scan = new Scanner(System.in);
		personMap = new HashMap<String,Person>(); // 지인 정보 저장
		person = new Person();
	}
	void inputPersonInfo() {
		System.out.println("이름을 입력하세요 : ");
		String name = scan.nextLine();
		System.out.println("핸드폰 번호를 입력하세요 : ");
		String phoneNumber = scan.nextLine();
		System.out.println("상대와의 관계정도를 입력하세요 (1 - 5) : ");
		int closeLevel = Integer.parseInt(scan.nextLine());
		personMap.put(phoneNumber, new Person(name, closeLevel)); // 지인의 이름, 핸드폰번호, 친밀도를 입력받아
																  // 핸드폰번호를 키값으로 .. 이름, 친밀도를 밸류값 설정
		
	}
	void reviseMoneyInfo() {
		
	}
	void setPassword() {
		
	}
	void getTotal() {
		
	}
	void removeInfo() {
		
	}
}
