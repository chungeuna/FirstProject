import java.io.Serializable;
import java.util.Scanner;

public class Menu implements Serializable{
	
	static transient Scanner sc = new Scanner(System.in);
	
	Main main = new Main();

	int selectMainDisplay() {
		main.loadUserList();
		System.out.println("메뉴에서 첫번째 확인 : " +main.userMap.toString());
		System.out.println("────────────────────────────────────");
		System.out.println("1:회원가입     2:로그인    0:프로그램 종료");
		System.out.println("────────────────────────────────────");
		
		int menuUserInput = 0;
		do {
			try {
				menuUserInput = Integer.parseInt(sc.nextLine());
				if (menuUserInput >= 0 && menuUserInput <=2) {
					break;
				} else {
					throw new Exception("showMainDisplay() Method 예외 발생");
				}
			} catch (Exception e) {
				System.out.println("선택 문제");
				System.out.println("0~2번까지 선택");
			}
		} while (true);		
		return menuUserInput;		
	}
	
	void showMainDisplay() {
		while (true) {
			switch (selectMainDisplay()) {
			case 1:	 this.main.signIn();	 // 회원가입 함수 호출
				break;
			case 2:	 this.main.logIn();		// 로그인 함수 호출
				main.loadPersonEventList();		// 로그인한 회원의 이벤트나 지인 리스트 로드. 여기서 뻑납니다
				showPersonManagerDisplay();
				break;
			case 0:	System.out.println("프로그램 종료합니다");
			if(this.main.pmMap.isEmpty()) {
				System.out.println("저장된 정보 없음");
			}else {
				// this.main.saveFile2();
			}
				
				System.exit(0);
			default : 
				System.out.println("잘못된 값을 입력하셨습니다. 다시입력하세요.");
			}
		}
	}
	

	int selectPersonManagerDisplay() {
		System.out.println("──────────────────────────────────────────────────────────────────────────────");
		System.out.println("1:지인목록 출력 2:지인정보 입력 3:지인정보 변경 4.지인정보삭제 5.이벤트 관리 6.비밀번호변경 	0.로그아웃");
		System.out.println("──────────────────────────────────────────────────────────────────────────────");
		int menuUserInput = 0;
		do {
			try {
				menuUserInput = Integer.parseInt(sc.nextLine());
				if (menuUserInput >= 0 && menuUserInput <=6) {
					break;
				} else {
					throw new Exception("selectPersonManagerDisplay() Method 예외 발생");
				}
			} catch (Exception e) {
				System.out.println("선택 문제");
				System.out.println("0~5번까지 선택");
			}
		} while (true);		
		return menuUserInput;		
	}
	
	void showPersonManagerDisplay() {
		boolean shouldExit  = false;
		while (true) {
			int userInput = selectPersonManagerDisplay();
			switch (userInput) {
			case 1: this.main.pmMap.get(this.main.getLoginId()).showAllInfo();	// 전체지인목록출력
				break;
			case 2: this.main.pmMap.get(this.main.getLoginId()).inputPersonInfo();	// 지인정보입력
				break;
			case 3:	this.main.pmMap.get(this.main.getLoginId()).modifyInfo(); 	// 지인정보수정
				break;
			case 4:	this.main.pmMap.get(this.main.getLoginId()).removeInfo();	 // 지인정보삭제
				break;
			case 5:	this.showEventManagingDisplay();	 // 이벤트 관리
				break;
			case 6:	this.main.setPassword(); 	// 비밀번호 변경
				break;
			case 0:	 System.out.println("사용해주셔서 감사합니다."); 	// 로그아웃 + 자동저장
				this.main.savePersonEventList();
				shouldExit = true;
				break;
			default : 
				System.out.println("잘못된 값을 입력하셨습니다. 다시입력하세요.");
			}
			if (shouldExit) {				
				break;
			}
		}
	}

	int selectEventManagingDisplay() {
		System.out.println("───────────────────────────────────────────────────────────────");
		System.out.println("1:전체 이벤트목록 출력 2:이벤트 입력 3:이벤트정보 변경 4.이벤트 삭제  5.적정경조사비 출력 0.뒤로가기");
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
				System.out.println("0~4번까지 선택");
			}
		} while (true);	
		return menu;		
	}
	
	void showEventManagingDisplay() {
		boolean shouldExit = false;
		while (true) {
			switch (selectEventManagingDisplay()) {
			case 1:	this.main.pmMap.get(this.main.getLoginId()).eventlist();	// 1:전체 이벤트목록 출력
				break;
			case 2: this.main.pmMap.get(this.main.getLoginId()).inputInfo();	// 2:이벤트 입력
				break;
			case 3:	this.main.pmMap.get(this.main.getLoginId()).modifyInfo();	// 3:이벤트정보 변경
				break;
			case 4:	this.main.pmMap.get(this.main.getLoginId()).removeInfo();	// 4.이벤트 삭제 
				break;
			case 5:	this.main.pmMap.get(this.main.getLoginId()).suggestMoney();	// 5.적정 경보사비 출력 
				break;
			case 0:		// 0. 뒤로가기
				shouldExit = true;
				break;
			default : 
				System.out.println("잘못된 값을 입력하셨습니다. 다시입력하세요.");
			}
			if (shouldExit){
				break;
			}
		}
	}
	
}