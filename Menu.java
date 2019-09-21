import java.io.Serializable;
import java.util.Scanner;

public class Menu implements Serializable{
	
	static transient Scanner sc = new Scanner(System.in);
	
	Main main = new Main();

	int selectMainDisplay() {
		main.loadUserList();
		System.out.println("�޴����� ù��° Ȯ�� : " +main.userMap.toString());
		System.out.println("������������������������������������������������������������������������");
		System.out.println("1:ȸ������     2:�α���    0:���α׷� ����");
		System.out.println("������������������������������������������������������������������������");
		
		int menuUserInput = 0;
		do {
			try {
				menuUserInput = Integer.parseInt(sc.nextLine());
				if (menuUserInput >= 0 && menuUserInput <=2) {
					break;
				} else {
					throw new Exception("showMainDisplay() Method ���� �߻�");
				}
			} catch (Exception e) {
				System.out.println("���� ����");
				System.out.println("0~2������ ����");
			}
		} while (true);		
		return menuUserInput;		
	}
	
	void showMainDisplay() {
		while (true) {
			switch (selectMainDisplay()) {
			case 1:	 this.main.signIn();	 // ȸ������ �Լ� ȣ��
				break;
			case 2:	 this.main.logIn();		// �α��� �Լ� ȣ��
				main.loadPersonEventList();		// �α����� ȸ���� �̺�Ʈ�� ���� ����Ʈ �ε�. ���⼭ �����ϴ�
				showPersonManagerDisplay();
				break;
			case 0:	System.out.println("���α׷� �����մϴ�");
			if(this.main.pmMap.isEmpty()) {
				System.out.println("����� ���� ����");
			}else {
				// this.main.saveFile2();
			}
				
				System.exit(0);
			default : 
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. �ٽ��Է��ϼ���.");
			}
		}
	}
	

	int selectPersonManagerDisplay() {
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("1:���θ�� ��� 2:�������� �Է� 3:�������� ���� 4.������������ 5.�̺�Ʈ ���� 6.��й�ȣ���� 	0.�α׾ƿ�");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		int menuUserInput = 0;
		do {
			try {
				menuUserInput = Integer.parseInt(sc.nextLine());
				if (menuUserInput >= 0 && menuUserInput <=6) {
					break;
				} else {
					throw new Exception("selectPersonManagerDisplay() Method ���� �߻�");
				}
			} catch (Exception e) {
				System.out.println("���� ����");
				System.out.println("0~5������ ����");
			}
		} while (true);		
		return menuUserInput;		
	}
	
	void showPersonManagerDisplay() {
		boolean shouldExit  = false;
		while (true) {
			int userInput = selectPersonManagerDisplay();
			switch (userInput) {
			case 1: this.main.pmMap.get(this.main.getLoginId()).showAllInfo();	// ��ü���θ�����
				break;
			case 2: this.main.pmMap.get(this.main.getLoginId()).inputPersonInfo();	// ���������Է�
				break;
			case 3:	this.main.pmMap.get(this.main.getLoginId()).modifyInfo(); 	// ������������
				break;
			case 4:	this.main.pmMap.get(this.main.getLoginId()).removeInfo();	 // ������������
				break;
			case 5:	this.showEventManagingDisplay();	 // �̺�Ʈ ����
				break;
			case 6:	this.main.setPassword(); 	// ��й�ȣ ����
				break;
			case 0:	 System.out.println("������ּż� �����մϴ�."); 	// �α׾ƿ� + �ڵ�����
				this.main.savePersonEventList();
				shouldExit = true;
				break;
			default : 
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. �ٽ��Է��ϼ���.");
			}
			if (shouldExit) {				
				break;
			}
		}
	}

	int selectEventManagingDisplay() {
		System.out.println("������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("1:��ü �̺�Ʈ��� ��� 2:�̺�Ʈ �Է� 3:�̺�Ʈ���� ���� 4.�̺�Ʈ ����  5.����������� ��� 0.�ڷΰ���");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������");
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (menu >= 0 && menu <=5) {
					break;
				} else {
					throw new Exception("selectPersonManagerDisplay() Method ���� �߻�");
				}
			} catch (Exception e) {
				System.out.println("���� ����");
				System.out.println("0~4������ ����");
			}
		} while (true);	
		return menu;		
	}
	
	void showEventManagingDisplay() {
		boolean shouldExit = false;
		while (true) {
			switch (selectEventManagingDisplay()) {
			case 1:	this.main.pmMap.get(this.main.getLoginId()).eventlist();	// 1:��ü �̺�Ʈ��� ���
				break;
			case 2: this.main.pmMap.get(this.main.getLoginId()).inputInfo();	// 2:�̺�Ʈ �Է�
				break;
			case 3:	this.main.pmMap.get(this.main.getLoginId()).modifyInfo();	// 3:�̺�Ʈ���� ����
				break;
			case 4:	this.main.pmMap.get(this.main.getLoginId()).removeInfo();	// 4.�̺�Ʈ ���� 
				break;
			case 5:	this.main.pmMap.get(this.main.getLoginId()).suggestMoney();	// 5.���� �溸��� ��� 
				break;
			case 0:		// 0. �ڷΰ���
				shouldExit = true;
				break;
			default : 
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�. �ٽ��Է��ϼ���.");
			}
			if (shouldExit){
				break;
			}
		}
	}
	
}