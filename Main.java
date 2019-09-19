import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	HashMap<String, String> userMap = new HashMap<String, String>();
	Scanner sc = new Scanner(System.in);
	User user;

	void signIn() { // ȸ�����Խ� ���̵�� �н����带 �޴´�
		System.out.println("���̵�� �н����带 �Է��ϼ���.");
		while (true) {
			System.out.println("�̸��Ϸ� �����ϼ���.");
			System.out.print("���̵� : ");
			user = new User();
			user.setId(sc.nextLine().trim());
			System.out.println("8�ڸ� �̻� �����ڿ� ���ڷ� ���弼��.");
			System.out.print("�н����� : ");
			user.setPassword(sc.nextLine().trim());
			if (!user.valID(user.getId())) {
				System.out.println("���Ŀ� ���� �ʴ� ���̵��Դϴ�. �ٽ� �Է��ϼ���.");

			} else if (userMap.containsKey(user.getId())) {
				System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");
			} else if (!user.valPassword(user.getPassword())) {
				System.out.println("���Ŀ� ���� �ʴ� �н� �����Դϴ�. �ٽ� �Է��ϼ���.");
			} else {
				userMap.put(user.getId(), user.getPassword());
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
				break;
			}
		}
	}

	void logIn() {// ���̵� �ִ� ȸ�� �α��� �Լ�  //IO ���� ���� �ؽ��ʷε��ϴ� �Լ� �߰� 
		System.out.println("���̵�� �н����带 �Է��ϼ���.");
		while (true) {
			System.out.print("���̵� : ");
			String inputId = sc.nextLine();
			System.out.println("�н����� : ");
			String inputPassword = sc.nextLine();
			if (!userMap.containsKey(inputId)) {
				System.out.println("�������� �ʴ� ȸ���Դϴ�.");
			} else if (!userMap.get(inputId).equals(inputPassword)) {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			} else {
				System.out.println("�α��� �Ǿ����ϴ�.");
				break;
			}
		}
	}
}
