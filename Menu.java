import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	PersonManager personManager = new PersonManager();

	int selectMainDisplay() {
		System.out.println("─────────────────────");
		System.out.println("1:회원가입     2:로그인     3:프로그램 종료");
		System.out.println("─────────────────────");

		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (menu >= 1 && menu <=3) {
					break;
				} else {
					throw new Exception("showMainDisplay() Method 예외 발생");
				}
			} catch (Exception e) {
				System.out.println("선택 문제");
				System.out.println("1~3번까지 선택");
			}
		} while (true);		
		return menu;		
	}
	
	void showMainDisplay() {
		while (true) {
			switch (selectMainDisplay()) {
			case 1:	// 회원가입 함수 호출
				break;
			case 2:	// 로그인 함수 호출
				break;
			case 3:	System.out.println("프로그램 종료합니다");
				System.exit(0);
			default : 
				System.out.println("잘못된 값을 입력하셨습니다.");
			}
		}
	}
	
	int selectPersonManagerDisplay() {
		System.out.println("───────────────────────────────────────────────────────────────");
		System.out.println("1:전체지인목록 출력 2:지인정보 입력 3:지인정보 변경 4.지인정보삭제 5.비밀번호 변경 0.로그아웃");
		System.out.println("───────────────────────────────────────────────────────────────");
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (menu >= 0 && menu <=5) {
					break;
				} else {
					throw new Exception("selectPersonManagerDisplay() Method 예외 발생");
				}
			} catch (Exception e) {
				System.out.println("선택 문제");
				System.out.println("0~5번까지 선택");
			}
		} while (true);		
		return menu;		
	}
	
	void showPersonManagerDisplay() {
		while (true) {
			switch (selectPersonManagerDisplay()) {
			case 1:	// 전체지인목록출력
				break;
			case 2:	// 지인정보입력
				break;
			case 3:	// 지인정보수정
				break;
			case 4:	// 지인정보삭제
				break;
			case 5:	// 비밀번호 변경
				break;
			case 0:	// 로그아웃 + (자동저장)
				break;
			default : 
				System.out.println("잘못된 값을 입력하셨습니다.");
			}
		}
	}
	
	
}
