import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuggestPrice {
	Scanner scan = new Scanner(System.in);
	PersonManager personManager = new PersonManager();

	public void suggestMoney () {
		int plusSum = 0;
		int minusSum = 0;
		// ���� ���� ���� ��쿡�� ���� ���.
		
		// ����̸��� �Է¹ް�?? �ϴ� ���ѹ��� �ҰԿ�....
		System.out.print("Input friend's PhoneNumber : ");
		String scanPhoneNumber = scan.nextLine();
		if (!personManager.personMap.containsKey(scanPhoneNumber)) {
			System.out.println("�ش� �� ��ȣ�� ���� ����� �����ϴ�!");
		} else {
			// �ش� ����ȣ�� �ݾ� ���� ������ ���ο� ��� ����Ʈ�� ���̽����� ����
			ArrayList<Integer> getMoneyList = new ArrayList<Integer>();
			for (int i=0; i<personManager.personMap.get(scanPhoneNumber).alEvent.size(); i++) {
				getMoneyList.add(personManager.personMap.get(scanPhoneNumber).alEvent.get(i).getMoney);
			}
			ArrayList<Integer> spendMoneyList  = new ArrayList<Integer>();
			for (int i=0; i<personManager.personMap.get(scanPhoneNumber).alEvent.size(); i++) {
				spendMoneyList.add(personManager.personMap.get(scanPhoneNumber).alEvent.get(i).spendMoney);
			}
			
			for (int i=0; i<getMoneyList.size(); i++) {
				plusSum += getMoneyList.get(i);		// + ��
			}
			for (int i=0; i<spendMoneyList.size(); i++) {
				minusSum += spendMoneyList.get(i);	// - ��
			}
			
			int diffMoney = plusSum + minusSum;		// �ް� �� �ݾ��� ����
			
			int diffSize = Math.abs(getMoneyList.size()-spendMoneyList.size());		// ���� �� �Ǽ��� �հ� ���� ���� �Ǽ��� ���� ���� ���ؼ� ���밪���� ��ȯ
			
			int payMoney = (int)(diffMoney/diffSize*personManager.person.closeLevel);
			// ģ�е��� ���� ����ġ�� ���Ͽ� ģ�е� 1:*0.8, 2:*0.9, 3:*1.0, 4:*1.1, 5:*1.2
			System.out.println("suggest Money : " +payMoney + "won �ε� �������ϰ� ��µǴ� �ݿø� �Ҳ���.");
			
			int length = (int)(Math.log10(payMoney)+1); 		// ������ �ڸ��� ���� �ڸ�����  �����̸� õ���������� ���� �ʸ� ������ ������������ ������?
			int roundSize = (int) Math.pow(10, length-2);		// 10^�ڸ���-2 ��ŭ�� ���� ���ϰ�
			double rePayMoney = payMoney / roundSize;			// ���� ���� ���� ������ ������ ������ �Ҽ��� ǥ�� ����
			int roundPayMoney = (int) Math.round(rePayMoney);	// �Ҽ��� ù°�ڸ����� �ݿø��ؼ� �Ҽ� ����
			int finalPayMoney = roundPayMoney * roundSize;		// �ٽ� 10^�ڸ���-2 ��ŭ ���� ���Ͽ��� ������ ����
			System.out.println("suggest Money : " +finalPayMoney + "won �ε� �������ϰ� ��µǴ� �ݿø� �Ҳ���.");
			
			
		}

	}
}