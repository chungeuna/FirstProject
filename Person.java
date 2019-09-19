import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Person implements IInfoManager {
	Scanner scan = new Scanner(System.in);
	String name;//
	int count;
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
		System.out.println(this.name + "���� ������ �� �� �ݾ� : " + this.getSumMoney);
	}

	void spendSum() {
		System.out.println(this.name + "�Կ��� ���� �� �ݾ� : " + this.spendSumMoney);
	}

	@Override
	public void inputInfo() {
		System.out.println("��¥�� �Է��ϼ��� : ");
		String date = scan.nextLine();
		System.out.println("�ݾ��� �Է��ϼ��� : ");
		int money = Integer.parseInt(scan.nextLine());
		System.out.println("������ ������ �Է��ϼ��� : ");
		String kindOfEvent = scan.nextLine();
		eventMap.put(count++, new Event(date, money, kindOfEvent));
		
		if(money < 0) {
			this.spendSumMoney += money;
		}else {
			this.getSumMoney += money;
		}
	}

	@Override
	public void modifyInfo() {
		
	}

	@Override
	public void searchInfo() {
		System.out.println("�˻��� ��¥�� �Է��ϼ��� : ");
		String date = scan.nextLine();
		ArrayList<Event> alist = new ArrayList<Event>();
		
		for (int i = 0; i < eventMap.size(); i++) {
			if ((eventMap.get(i).date.equals(date))) {
				alist.add(eventMap.get(i));
			}
		}

		if (alist.size() == 0) {
			System.out.println("�ش� ��¥�� ������ �����ϴ�");
		} else {
			System.out.println(alist);
		}
	}

	@Override
	public void removeInfo() {
		Set set = eventMap.keySet();
		Iterator it = set.iterator();
		//while(it.hasNext()) {
		//	System.out.println(eventMap.get(it.next()));
		//}
		for(Map.Entry m : eventMap.entrySet()) {
			System.out.println("��ȣ : " + m.getKey() + " " + (Event)m.getValue());
		}
		System.out.println("���� �̺�Ʈ ��ȣ�� �Է��ϼ���!");
		int inputNumber = scan.nextInt();
		eventMap.keySet().remove((inputNumber)); // ���������� ����
		System.out.println("���� �Ǿ����ϴ�");
	}
}