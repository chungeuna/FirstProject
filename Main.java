import java.util.HashMap;
import java.util.Scanner;

public class Main {
	HashMap<String, String> userMap = new HashMap<String, String>();
	Scanner scan = new Scanner(System.in);
	User user;
	HashMap<String, PersonManager> pmMap = new HashMap<String, PersonManager>();
	PersonManager pm;
	private static String loginId = "";

	void signIn() { // ȸ�����Խ� ���̵�� �н����带 �޴´�
		System.out.println("���̵�� �н����带 �Է��ϼ���.");
		while (true) {
			System.out.println("�̸��Ϸ� �����ϼ���.");
			System.out.print("���̵� : ");
			String userId = scan.nextLine();
			pm = new PersonManager();
			pmMap.put(userId, pm);
			
			user = new User();
			user.setId(userId);
			System.out.println("8�ڸ� �̻� �����ڿ� ���ڷ� ���弼��.");
			System.out.print("�н����� : ");
			user.setPassword(scan.nextLine().trim());
			
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
		
		//I/O    ����  �۽� �Ŵ��� �ؽ��� �η��;� �� 
		
		
		System.out.println("���̵�� �н����带 �Է��ϼ���.");
		while (true) {
			System.out.print("���̵� : ");
			String inputId = scan.nextLine();
			System.out.println("�н����� : ");
			String inputPassword = scan.nextLine();
			if (!userMap.containsKey(inputId)) {
				System.out.println("�������� �ʴ� ȸ���Դϴ�.");
			} else if (!userMap.get(inputId).equals(inputPassword)) {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			} else {
				System.out.println("�α��� �Ǿ����ϴ�.");
				loginId = inputId;
				//loadFile(inputId);
	
				
				// �ڵ� �ε� .. 
				break;
			}
		}
	}
	
	void loadFile (String str) {
		pmMap.get(str).menu();
	}
	
	
	
	void logOut() {
		// �α� �ƿ� �� ��   ����, �۽� �Ŵ��� �ؽ���  ���� ����...
	}
	
	
	void setPassword() {
		
		
		
		System.out.println("������ ��й�ȣ�� �Է��ϼ���");
		String password = scan.nextLine();
		if(!user.valPassword(password)) {
			System.out.println("���Ŀ� ���� �ʴ� ��й�ȣ�Դϴ�. ��й�ȣ�� �ٽ� �����ϼ���!");
		} else {
			userMap.put(loginId, password);
			System.out.println("����Ǿ����ϴ�");
		}
		
	}

	public static String getLoginId() {
		return loginId;
	}
	
	
}