import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	PersonManager personManager;
	Main main;
	

	Menu() {
		boolean sholdExit = false;
		while (true) {
			System.out.println("─────────────────────────────");
			System.out.println("1:회원가입     2:로그인     3:프로그램 종료");
			System.out.println("─────────────────────────────");
			int userInput = Integer.parseInt(sc.nextLine());
			while (true) {
				switch (userInput) {
				case 1:	main.signIn(); // 회원가입 함수 호출
					break;
				case 2:	main.logIn(); // 로그인 함수 호출
					break;
				case 3:	System.out.println("프로그램 종료합니다");
					System.exit(0);
				default : 
					System.out.println("잘못된 값을 입력하셨습니다.");
				}
			}
		}
	}
	
	
	
	int selectMainDisplay() {
		System.out.println("─────────────────────────────");
		System.out.println("1:회원가입     2:로그인     3:프로그램 종료");
		System.out.println("─────────────────────────────");

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
			case 1:	main.signIn(); // 회원가입 함수 호출
				break;
			case 2:	main.logIn(); // 로그인 함수 호출
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
			case 1:	personManager.showAllInfo(); // 전체지인목록출력
				break;
			case 2:	personManager.inputInfo(); // 지인정보입력
				break;
			case 3:	personManager.modifyInfo(); // 지인정보수정
				break;
			case 4:	personManager.removeInfo(); // 지인정보삭제
				break;
			case 5:	main.setPassword(); // 비밀번호 변경
				break;
			case 0:	 // 종료 (자동저장) 이건 알아서
			
				break;
			default : 
				System.out.println("잘못된 값을 입력하셨습니다.");
			}
		}
	}
	int selectEventManagingDisplay() {
		System.out.println("───────────────────────────────────────────────────────────────");
		System.out.println("1:전체 이벤트목록 출력 2:이벤트 입력 3:이벤트정보 변경 4.이벤트 삭제  0.뒤로가기");
		System.out.println("───────────────────────────────────────────────────────────────");
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (menu >= 0 && menu <=4) {
					break;
				} else {
					throw new Exception("selectPersonManagerDisplay() Method 예외 발생");
				}
			} catch (Exception e) {
				System.out.println("선택 문제");
				System.out.println("0~4번까지 선택");
			}
		} while (true);		
		return menu;		
	}
	
	void showEventManagingDisplay() {
		boolean shouldExit = false;
		while (true) {
			switch (selectEventManagingDisplay()) {
			case 1:	// 1:전체 이벤트목록 출력
				break;
			case 2:	// 2:이벤트 입력
				break;
			case 3:	// 3:이벤트정보 변경
				break;
			case 4:	// 4.이벤트 삭제 
				break;
			case 0:	 //  0.뒤로가기
				shouldExit = true;
				break;
			default : 
				System.out.println("잘못된 값을 입력하셨습니다.");
			}
			if (shouldExit){
				break;
			}
		}
	}
}