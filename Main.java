import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	HashMap<String, String> userMap = new HashMap<String, String>();
	Scanner scan = new Scanner(System.in);
	User user;
	HashMap<String, PersonManager> pmMap = new HashMap<String, PersonManager>();
	PersonManager pm;
	String filePath = "C:\\IOTemp";
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

	void logIn() {// ���̵� �ִ� ȸ�� �α��� �Լ� //IO ���� ���� �ؽ��ʷε��ϴ� �Լ� �߰�

		// I/O ���� �۽� �Ŵ��� �ؽ��� �η��;� ��

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
				
				break;
			}
		}
		
	}
/*
	void loadFile(String str) {
		pmMap.get(str).menu();
	}
*/
	void logOut() {
		// �α� �ƿ� �� �� ����, �۽� �Ŵ��� �ؽ��� ���� ����...
	}

	void setPassword() {

		System.out.println("������ ��й�ȣ�� �Է��ϼ���");
		String password = scan.nextLine();
		if (!user.valPassword(password)) {
			System.out.println("���Ŀ� ���� �ʴ� ��й�ȣ�Դϴ�. ��й�ȣ�� �ٽ� �����ϼ���!");
		} else {
			userMap.put(loginId, password);
			System.out.println("����Ǿ����ϴ�");
		}

	}

	public static String getLoginId() {
		return loginId;
	}

	void saveFile() {
		File file = new File("User.txt");

		try {
			FileOutputStream fos = new FileOutputStream(filePath + "\\User.txt", true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(userMap);
			
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("ȸ�� ������ ����Ǿ����ϴ�.");
		}

	}

	void saveFile2() {

		File file2 = new File("PersonManager.txt");
		try {
			FileOutputStream fos2 = new FileOutputStream(file2);
			//BufferedOutputStream bos = new BufferedOutputStream(fos2);
			ObjectOutputStream oos2 = new ObjectOutputStream(fos2);

			oos2.writeObject(pmMap);

			
			oos2.close();
			// bos.close();
			fos2.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("����Ǿ����ϴ�.");
		}
	}

	void loadUserFile() {
		try {
			FileInputStream fis = new FileInputStream(filePath + "\\User.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			userMap = (HashMap) ois.readObject();

			ois.close();
			fis.close();
		} catch (Exception e) {

		}

	}

}