import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SuggestPrice {
	Scanner scan = new Scanner(System.in);
	
	PersonManager personManager;
	Event event = new Event();
	HashMap<Person, Event> eventMap = new HashMap<Person,Event>();
	
	
	public void suggestMoney () {
		int plusSum = 0;
		int MinusSum = 0;
		// ���� ���� ���� ��쿡�� ���� ���.
		
		// ����̸��� �Է¹ް�
		System.out.print("Input friend's Name : ");
		String scanName = scan.nextLine();
		if (!scanName.equals("person �� �ִ� ���Ŷ� �����ؼ� �ϳ��� ���� ������")) {
			System.out.println("�ش� �̸��� ���� ����� �����ϴ�!");
		} else {
			// �̺�Ʈ���� ���� ���� ��� ����Ʈ1 ������ price �߰�, ���� �� ��� ����Ʈ2 ������ price �߰�
			ArrayList<Event> getMoneyList = new ArrayList<Event>();
			ArrayList<Event> spendMoneyList  = new ArrayList<Event>();
			// �Ϸ��� Ű ����Ʈ�� �� ���;� �ϳ�?
			for (int i=0; i<eventMap.size(); i++) {
				if (eventMap.value() > 0) {
					plusSum += eventMap.values(). // ����??? �̷��� �ϴ���.. �� ��¼���� �ؼ�
				} else {
					MinusSum += eventMap.values(). // ����??? �̷��� �ϴ���.. �� ��¼���� �ؼ�		&&&&&&&&&&&&& �����ϳ���...�̤�
				}
			}
			
			// ��� ����Ʈ1�� price ���� ���� ��� ����Ʈ2 price �� �� +
			int moneyDiff = plusSum - MinusSum;

			// ��� ����Ʈ1�� size ��  ��� ����Ʈ2�� size �� �� +
			int sizeDiff = getMoneyList.size()-spendMoneyList.size();
			// price ���� / size ũ�� �� �� suggestMoney ���
			System.out.println("suggest Money : "  +(int)moneyDiff/sizeDiff + "won??? �Ƹ���?");
		}
		
	}
}
