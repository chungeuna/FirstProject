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
		personList = new ArrayList<Person>(); // ���� ���� ����

	}

	void inputPersonInfo() {
		System.out.println("������ �̸��� �Է��ϼ��� : ");
		String name = scan.nextLine();
		System.out.println("�ڵ��� ��ȣ�� �Է��ϼ��� : ");
		String phoneNumber = scan.nextLine();
		System.out.println("������ ���������� �Է��ϼ��� (1 - 5) : ");
		int closeLevel = Integer.parseInt(scan.nextLine());

		personList.add(new Person(name, closeLevel, phoneNumber)); // ������ �̸�, �ڵ�����ȣ, ģ�е��� �Է¹޾�
																	// �ڵ�����ȣ�� Ű������ .. �̸�, ģ�е��� ����� ����

	}

	@Override
	public void inputInfo() {
		System.out.println("������ �̸��� �Է��ϼ���");
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
	 * ((Person)m.getValue()).eventMap) { // ��°Ÿ�� ���ϱ�~
	 * 
	 * } }
	 */
	@Override
	public void modifyInfo() {
		
		for(int i =0; i < personList.size(); i++) {
			System.out.println("��ȣ : " + i + " / " + personList.get(i));
		}
		System.out.println("ģ�е��� ������ ������ ��ȣ?");
		int inputNumber = scan.nextInt();
		scan.nextLine();
		System.out.println("������ ģ�е��� �Է��ϼ���");
		int closeLevel = scan.nextInt();
		
		personList.get(inputNumber).setCloseLevel(closeLevel);
	}

	@Override
	public void searchInfo() {
		/*
		 * System.out.println("�˻��� ��¥�� �Է��ϼ��� : "); String date = scan.nextLine();
		 * ArrayList<Event> alist = new ArrayList<Event>();
		 * 
		 * for (int i = 0; i < eventMap.size(); i++) { if
		 * ((eventMap.get(i).date.equals(date))) { alist.add(eventMap.get(i)); } }
		 * 
		 * if (alist.size() == 0) { System.out.println("�ش� ��¥�� ������ �����ϴ�"); } else {
		 * System.out.println(alist); }
		 */
	}

	@Override
	public void removeInfo() {
		/*
		 * Set set = eventMap.keySet(); Iterator it = set.iterator();
		 * //while(it.hasNext()) { // System.out.println(eventMap.get(it.next())); //}
		 * for(Map.Entry m : eventMap.entrySet()) { System.out.println("��ȣ : " +
		 * m.getKey() + " / " + (Event)m.getValue()); }
		 * System.out.println("���� �̺�Ʈ ��ȣ�� �Է��ϼ���!"); int inputNumber = scan.nextInt();
		 * eventMap.keySet().remove((inputNumber)); // ���������� ����
		 * System.out.println("���� �Ǿ����ϴ�");
		 */
	}
}