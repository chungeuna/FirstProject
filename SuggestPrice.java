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
		// 내가 돈을 내는 경우에만 쓰는 기능.
		
		// 사람이름을 입력받고?? 일단 폰넘버로 할게요....
		System.out.print("Input friend's PhoneNumber : ");
		String scanPhoneNumber = scan.nextLine();
		if (!personManager.personMap.containsKey(scanPhoneNumber)) {
			System.out.println("해당 폰 번호를 가진 사람이 없습니다!");
		} else {
			// 해당 폰번호의 금액 출입 내역을 새로운 어레이 리스트에 케이스별로 나눔
			ArrayList<Integer> getMoneyList = new ArrayList<Integer>();
			for (int i=0; i<personManager.personMap.get(scanPhoneNumber).alEvent.size(); i++) {
				getMoneyList.add(personManager.personMap.get(scanPhoneNumber).alEvent.get(i).getMoney);
			}
			ArrayList<Integer> spendMoneyList  = new ArrayList<Integer>();
			for (int i=0; i<personManager.personMap.get(scanPhoneNumber).alEvent.size(); i++) {
				spendMoneyList.add(personManager.personMap.get(scanPhoneNumber).alEvent.get(i).spendMoney);
			}
			
			for (int i=0; i<getMoneyList.size(); i++) {
				plusSum += getMoneyList.get(i);		// + 값
			}
			for (int i=0; i<spendMoneyList.size(); i++) {
				minusSum += spendMoneyList.get(i);	// - 값
			}
			
			int diffMoney = plusSum + minusSum;		// 받고 쓴 금액의 차액
			
			int diffSize = Math.abs(getMoneyList.size()-spendMoneyList.size());		// 돈을 낸 건수의 합과 돈을 받은 건수의 합의 차를 구해서 절대값으로 변환
			
			int payMoney = (int)(diffMoney/diffSize*personManager.person.closeLevel);
			// 친밀도에 따라 가중치를 더하여 친밀도 1:*0.8, 2:*0.9, 3:*1.0, 4:*1.1, 5:*1.2
			System.out.println("suggest Money : " +payMoney + "won 인데 지저분하게 출력되니 반올림 할꺼임.");
			
			int length = (int)(Math.log10(payMoney)+1); 		// 숫자의 자릿수 십의 자리에서  만원이면 천원단위에서 끊고 십만 단위면 만원단위에서 끊으면?
			int roundSize = (int) Math.pow(10, length-2);		// 10^자릿수-2 만큼의 값을 구하고
			double rePayMoney = payMoney / roundSize;			// 위에 구한 값을 기존의 돈에서 나눠서 소수점 표시 ㄱㄱ
			int roundPayMoney = (int) Math.round(rePayMoney);	// 소수점 첫째자리에서 반올림해서 소수 제거
			int finalPayMoney = roundPayMoney * roundSize;		// 다시 10^자릿수-2 만큼 값을 곱하여서 단위를 맞춤
			System.out.println("suggest Money : " +finalPayMoney + "won 인데 지저분하게 출력되니 반올림 할꺼임.");
			
			
		}

	}
}