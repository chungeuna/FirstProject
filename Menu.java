import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner(System.in);
	PersonManager personManager = new PersonManager();

	int selectMainDisplay() {
		System.out.println("������������������������������������������");
		System.out.println("1:ȸ������     2:�α���     3:���α׷� ����");
		System.out.println("������������������������������������������");

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
			case 1:	// ȸ������ �Լ� ȣ��
				break;
			case 2:	// �α��� �Լ� ȣ��
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
			case 1:	// ��ü���θ�����
				break;
			case 2:	// ���������Է�
				break;
			case 3:	// ������������
				break;
			case 4:	// ������������
				break;
			case 5:	// ��й�ȣ ����
				break;
			case 0:	// �α׾ƿ� + (�ڵ�����)
				break;
			default : 
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	
	
}
