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
		personMap = new HashMap<String,Person>(); // ���� ���� ����
		person = new Person();
	}
	void inputPersonInfo() {
		System.out.println("�̸��� �Է��ϼ��� : ");
		String name = scan.nextLine();
		System.out.println("�ڵ��� ��ȣ�� �Է��ϼ��� : ");
		String phoneNumber = scan.nextLine();
		System.out.println("������ ���������� �Է��ϼ��� (1 - 5) : ");
		int closeLevel = Integer.parseInt(scan.nextLine());
		personMap.put(phoneNumber, new Person(name, closeLevel)); // ������ �̸�, �ڵ�����ȣ, ģ�е��� �Է¹޾�
																  // �ڵ�����ȣ�� Ű������ .. �̸�, ģ�е��� ����� ����
		
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
