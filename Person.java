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
		System.out.println(this.name + "���� ������ �� �� �ݾ� : " + this.getSumMoney);
	}

	void spendSum() {
		System.out.println(this.name + "�Կ��� �� �� �ݾ� : " + this.spendSumMoney);
	}

	@Override
	public void inputInfo() {
		scan = new Scanner(System.in);
		System.out.println("��¥�� �Է��ϼ��� : ");
		String date = scan.nextLine();
		System.out.println("�ݾ��� �Է��ϼ��� : ");
		int money = Integer.parseInt(scan.nextLine());
		System.out.println("������ ������ �Է��ϼ��� : ");
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
		scan = new Scanner(System.in);
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
		scan = new Scanner(System.in);
		for(int i=0; i < eventlist.size(); i++) {
			System.out.println("��ȣ : " + i + " / " + eventlist.get(i));
		}
		System.out.println("���� �̺�Ʈ ��ȣ�� �Է��ϼ���!");
		int inputNumber = scan.nextInt();
		eventlist.remove(inputNumber);
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

	@Override
	public String toString() {
		return "�̸�: " + name + ", �ڵ�����ȣ" + phoneNumber + 
				 ", ģ�е�: " + closeLevel + ", �� ������ �ݾ�: " + spendSumMoney + ", �� ���� �ݾ�: " + getSumMoney;
				
	}
	
	
	public void suggestMoney () {
		String str = "";
		
		System.out.println("���� Ƚ�� " +countPlus);
		System.out.println("���� Ƚ�� " +countMinus);
		System.out.println("�� ���� �ݾ� "+getSumMoney);
		System.out.println("�� ���� �ݾ� "+spendSumMoney);

		if (this.getSumMoney == 0 && this.spendSumMoney==0) {
			if(this.closeLevel >= 4) {
				str ="�Ż��Ӵ� 2��";
			} else {
				str ="�Ż��Ӵ� 1��!";
			}
		} else if ( this.getSumMoney==0 && this.spendSumMoney!=0) {		// ������ 0	 ���� ����
			System.out.println("WARNING! �����翡 ������ �ΰ踦 ��ʽÿ�!");
			str = " ���� ���� �޴� Case";
		} else if ( this.getSumMoney!=0 && this.spendSumMoney==0 ) {	// ������ ����	 ���� 0
			int result = (int)getSumMoney / countPlus;
			str = ""+result+"��";
		} else if (this.getSumMoney!=0 && this.spendSumMoney!=0) {
			if (countPlus == countMinus) {
				int result = (int) (spendSumMoney+getSumMoney) / 1;
				str = ""+result+"��";
			} else {int result = (int) (spendSumMoney+getSumMoney) / (countPlus-countMinus);
				str = ""+result+"��";
			}
			
		}
		System.out.println("���� �ݾ��� "+str+" �Դϴ�.");
		
	}
	
}