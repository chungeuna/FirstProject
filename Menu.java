import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	PersonManager personManager;
	Main main;
	

	Menu() {
		boolean sholdExit = false;
		while (true) {
			System.out.println("����������������������������������������������������������");
			System.out.println("1:ȸ������     2:�α���     3:���α׷� ����");
			System.out.println("����������������������������������������������������������");
			int userInput = Integer.parseInt(sc.nextLine());
			while (true) {
				switch (userInput) {
				case 1:	main.signIn(); // ȸ������ �Լ� ȣ��
					break;
				case 2:	main.logIn(); // �α��� �Լ� ȣ��
					break;
				case 3:	System.out.println("���α׷� �����մϴ�");
					System.exit(0);
				default : 
					System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
				}
			}
		}
	}
	
	
	
	int selectMainDisplay() {
		System.out.println("����������������������������������������������������������");
		System.out.println("1:ȸ������     2:�α���     3:���α׷� ����");
		System.out.println("����������������������������������������������������������");

		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (menu >= 1 && menu <=3) {
					break;
				} else {
					throw new Exception("showMainDisplay() Method ���� �߻�");
				}
			} catch (Exception e) {
				System.out.println("���� ����");
				System.out.println("1~3������ ����");
			}
		} while (true);		
		return menu;		
	}
	
	void showMainDisplay() {
		while (true) {
			switch (selectMainDisplay()) {
			case 1:	main.signIn(); // ȸ������ �Լ� ȣ��
				break;
			case 2:	main.logIn(); // �α��� �Լ� ȣ��
				break;
			case 3:	System.out.println("���α׷� �����մϴ�");
				System.exit(0);
			default : 
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	
	int selectPersonManagerDisplay() {
		System.out.println("������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("1:��ü���θ�� ��� 2:�������� �Է� 3:�������� ���� 4.������������ 5.��й�ȣ ���� 0.�α׾ƿ�");
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
				System.out.println("0~5������ ����");
			}
		} while (true);		
		return menu;		
	}
	
	void showPersonManagerDisplay() {
		while (true) {
			switch (selectPersonManagerDisplay()) {
			case 1:	personManager.showAllInfo(); // ��ü���θ�����
				break;
			case 2:	personManager.inputInfo(); // ���������Է�
				break;
			case 3:	personManager.modifyInfo(); // ������������
				break;
			case 4:	personManager.removeInfo(); // ������������
				break;
			case 5:	main.setPassword(); // ��й�ȣ ����
				break;
			case 0:	 // ���� (�ڵ�����) �̰� �˾Ƽ�
			
				break;
			default : 
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	int selectEventManagingDisplay() {
		System.out.println("������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("1:��ü �̺�Ʈ��� ��� 2:�̺�Ʈ �Է� 3:�̺�Ʈ���� ���� 4.�̺�Ʈ ����  0.�ڷΰ���");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������");
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine());
				if (menu >= 0 && menu <=4) {
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
			case 1:	// 1:��ü �̺�Ʈ��� ���
				break;
			case 2:	// 2:�̺�Ʈ �Է�
				break;
			case 3:	// 3:�̺�Ʈ���� ����
				break;
			case 4:	// 4.�̺�Ʈ ���� 
				break;
			case 0:	 //  0.�ڷΰ���
				shouldExit = true;
				break;
			default : 
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
			}
			if (shouldExit){
				break;
			}
		}
	}
}