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
		System.out.println("��¥�� �Է��ϼ��� : ");
		String date = scan.nextLine();
		System.out.println("�ݾ��� �Է��ϼ��� : ");
		int money = Integer.parseInt(scan.nextLine());
		System.out.println("������ ������ �Է��ϼ��� : ");
		String kindOfEvent = scan.nextLine();
		eventMap.put(count++, new Event(date, money, kindOfEvent));
	}

	@Override
	public void modifyInfo() {

	}

	@Override
	public void searchInfo() {
		System.out.println("�˻��� ��¥�� �Է��ϼ��� : ");
		String date = scan.nextLine();
		ArrayList<Event> alist = new ArrayList<Event>();
		// if(eventMap.containsValue()) {
		// System.out.println("data �� ����");
		// }else {
		// System.out.println("����� else");
		// }
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
		for (int i=0; i<eventMap.size(); i++) {
			System.out.println("for" + eventMap.get(i));
			
			//System.out.print(i+"��: ������ �� : " + eventMap.get(i).kindOfEvent+"\t"+ eventMap.get(i).date+"\t"+ eventMap.get(i).getMoney+"|"+eventMap.get(i).spendMoney+"\n");
		}
		Set set = eventMap.keySet();
		Iterator it = set.iterator();
		int c1=0;
		while(it.hasNext()) {
			System.out.println("��ȣ: " + c1 + " " +eventMap.get(it.next()));
			c1++;
			
		}
		System.out.println("���� �̺�Ʈ ��ȣ�� �Է��ϼ���!");
		int inputNumber = scan.nextInt();
		eventMap.remove(inputNumber);	// ���������� ����
		
		
		//for (int i=0; i<eventMap.size(); i++) {
			//System.out.print(i+"��: ������ �� : " + eventMap.get(i).kindOfEvent+"\t"+ eventMap.get(i).date+"\t"+ eventMap.get(i).getMoney+"|"+eventMap.get(i).spendMoney+"\n");
		//}
		
		// ���� ����Ʈ(�̸�, �޴�����ȣ �� �� ����) ����ϴ� �Լ� ȣ��
		
		
		

	}

}