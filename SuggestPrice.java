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
		// 내가 돈을 내는 경우에만 쓰는 기능.
		
		// 사람이름을 입력받고
		System.out.print("Input friend's Name : ");
		String scanName = scan.nextLine();
		if (!scanName.equals("person 에 있는 모든거랑 대조해서 하나라도 갚이 같으면")) {
			System.out.println("해당 이름을 가진 사람이 없습니다!");
		} else {
			// 이벤트에서 돈을 받은 어레이 리스트1 값으로 price 추가, 돈을 쓴 어레이 리스트2 값으로 price 추가
			ArrayList<Event> getMoneyList = new ArrayList<Event>();
			ArrayList<Event> spendMoneyList  = new ArrayList<Event>();
			// 하려면 키 리스트를 다 들고와야 하네?
			for (int i=0; i<eventMap.size(); i++) {
				if (eventMap.value() > 0) {
					plusSum += eventMap.values(). // 뭐지??? 이렇게 하던가.. 뭐 어쩌던가 해서
				} else {
					MinusSum += eventMap.values(). // 뭐지??? 이렇게 하던가.. 뭐 어쩌던가 해서		&&&&&&&&&&&&& 어찌하나요...ㅜㅜ
				}
			}
			
			// 어레이 리스트1의 price 누적 값과 어레이 리스트2 price 를 비교 +
			int moneyDiff = plusSum - MinusSum;

			// 어레이 리스트1의 size 와  어레이 리스트2의 size 를 비교 +
			int sizeDiff = getMoneyList.size()-spendMoneyList.size();
			// price 차액 / size 크기 차 로 suggestMoney 출력
			System.out.println("suggest Money : "  +(int)moneyDiff/sizeDiff + "won??? 아마도?");
		}
		
	}
}
