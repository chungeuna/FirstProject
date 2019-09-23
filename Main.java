import java.io.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class Main implements Serializable {

	static transient Scanner scan = new Scanner(System.in);
	HashMap<String, String> userMap = new HashMap<String, String>();
	HashMap<String, PersonManager> pmMap = new HashMap<String, PersonManager>();

	private String loginId = "";
	User user;
	PersonManager pm;

	String filePath = "C:\\Project";
	String userFilesPath = "C:\\Project\\User";

	Main() {
		user = new User();
		loadUserList();
		loadPersonEventList();
	}

	void signIn() { // ȸ�����Խ� ���̵�� �н����带 �޴´�
		System.out.println("���̵�� �н����带 �Է��ϼ���.");
		while (true) {
			
			String userId = JOptionPane.showInputDialog("���� �̸��Ϸ� �����ϼ��� \n���̵�: ");

			user = new User();
			user.setId(userId);
			
			String passWord = JOptionPane.showInputDialog("8�ڸ� �̻� �����ڿ� ���ڷ� ���弼��. \n�н����� : ");
			user.setPassword(passWord);

			if (!user.valID(user.getId())) {
				System.out.println("���Ŀ� ���� �ʴ� ���̵��Դϴ�. �ٽ� �Է��ϼ���.");

			} else if (userMap.containsKey(user.getId())) {
				System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");
			} else if (!user.valPassword(user.getPassword())) {
				System.out.println("���Ŀ� ���� �ʴ� �н� �����Դϴ�. �ٽ� �Է��ϼ���.");
			} else {
				userMap.put(user.getId(), user.getPassword());
				pmMap.put(userId, new PersonManager());
				loginId = userId;
				saveUserList(); // ����Ʈ ����
				savePersonEventList(); // User Path�� ���� ����
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");

				break;
			}
		}

	}

	String logIn() {
		System.out.println("���̵�� �н����带 �Է��ϼ���.");
		while (true) {
			System.out.print("���̵� : ");
			String inputId = scan.nextLine();
			System.out.print("�н����� : ");
			String inputPassword = scan.nextLine();
			if (!userMap.containsKey(inputId)) {
				System.out.println("�������� �ʴ� ȸ���Դϴ�.");
			} else if (!userMap.get(inputId).equals(inputPassword)) {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			} else {
				System.out.println("�α��� �Ǿ����ϴ�.");
				loginId = inputId;
				loadPersonEventList(); 
				return loginId;
			}
		}
	}

	void logOut() {

		saveUserList(); // ����Ʈ ����
		savePersonEventList();
		// �α� �ƿ� �� �� ����, �۽� �Ŵ��� �ؽ��� ���� ����...
	}

	void setPassword() {

		System.out.println("������ ��й�ȣ�� �Է��ϼ���");
		String password = scan.nextLine();
		if (!user.valPassword(password)) {
			System.out.println("���Ŀ� ���� �ʴ� ��й�ȣ�Դϴ�. ��й�ȣ�� �ٽ� �����ϼ���!");
		} else {
			userMap.put(loginId, password);
			//saveUserList();
			System.out.println("����Ǿ����ϴ�");
		}
	}

	public String getLoginId() {
		return loginId;
	}

	void saveUserList() { // ȸ�� ����Ʈ�� ��� �ϸ鼭~ ����
		File file = new File("User.ser");
		File dir = new File(userFilesPath);
		try {
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			FileOutputStream fos = new FileOutputStream(filePath + "\\" + file, false);
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

	void loadUserList() {
		File file = new File("User.ser");
		try {

			userMap = new HashMap<String, String>();

			FileInputStream fis = new FileInputStream(filePath + "\\" + file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);

			userMap = (HashMap) ois.readObject();

			ois.close();
			fis.close();
		} catch (Exception e) {

		}

		Set set = userMap.entrySet();
		Iterator iterator = set.iterator();
	}

	void savePersonEventList() {
		File file = new File(loginId + ".ser");

		try {
			FileOutputStream fos = new FileOutputStream(userFilesPath + "\\" + file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(pmMap);

			oos.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("����Ǿ����ϴ�.");
		}
	}

	void loadPersonEventList() {
		File file = new File(loginId + ".ser");

		try {
			FileInputStream fis = new FileInputStream(userFilesPath + "\\" + file);
			ObjectInputStream ois = new ObjectInputStream(fis);

			pmMap = (HashMap) ois.readObject();

			ois.close();
			fis.close();

		} catch (Exception e) {

		}
	}
}