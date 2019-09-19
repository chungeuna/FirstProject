import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Person implements IInfoManager {
	Scanner scan = new Scanner(System.in);
	String name;//
	String phoneNumber;
	int count;
	// String phoneNumber;// ����� �Ǵ°� �ƴ�?
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
			System.out.println("��ȣ : " + i + " / " + eventlist.get(i));
		}
		System.out.println("�ݾ��� �����ϰ� ���� �̺�Ʈ ��ȣ�� �Է��ϼ���");
		int inputNumber = scan.nextInt();
		scan.nextLine();
		System.out.println("������ �ݾ��� �Է��ϼ���");
		System.out.println("������ �ݾ�: ");
		int outmoney = scan.nextInt();
		scan.hasNextLine();
		
		System.out.println("���� �ݾ�: ");
		int inmoney = scan.nextInt();
		
		
		
		eventlist.get(inputNumber).setGetMoney(inmoney);
		eventlist.get(inputNumber).setSpendMoney(outmoney);
		
	}

	@Override
	public void searchInfo() {
		System.out.println("�˻��� ��¥�� �Է��ϼ��� : ");
		String date = scan.nextLine();
		ArrayList<Event> alist = new ArrayList<Event>();
		
		for (int i = 0; i < eventlist.size(); i++) {
			if ((eventlist.get(i).date.equals(date))) {
				alist.add(eventlist.get(i));
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
		for(int i=0; i < eventlist.size(); i++) {
			System.out.println("��ȣ : " + i + " / " + eventlist.get(i));
		}
		System.out.println("���� �̺�Ʈ ��ȣ�� �Է��ϼ���!");
		int inputNumber = scan.nextInt();
		eventlist.remove(inputNumber); // ���������� ����
		System.out.println("���� �Ǿ����ϴ�");
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