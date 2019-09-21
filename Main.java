import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main implements Serializable {
	
	static transient Scanner scan = new Scanner(System.in);
	HashMap<String, String> userMap = new HashMap<String, String>();
	HashMap<String, PersonManager> pmMap = new HashMap<String, PersonManager>();
	
	private String loginId = "";
	User user;
	PersonManager pm;
	
	String filePath = "C:\\zProject";
	String userfilesPath = "C:\\zProject\\User";

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
				loginId = userId;
				saveUserList();		// ����Ʈ ����
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
			System.out.println("�н����� : ");
			String inputPassword = scan.nextLine();
			if (!userMap.containsKey(inputId)) {
				System.out.println("�������� �ʴ� ȸ���Դϴ�.");
			} else if (!userMap.get(inputId).equals(inputPassword)) {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			} else {
				System.out.println("�α��� �Ǿ����ϴ�.");
				loginId = inputId;
				loadPersonEventList(); 		// �̰� �ߵ˴ϴ�!
				return loginId;
			}
		}
	}

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
			saveUserList();
			System.out.println("����Ǿ����ϴ�");
		}
	}

	public String getLoginId() {
		return loginId;
	}

	void saveUserList() {		// ȸ�� ����Ʈ�� ��� �ϸ鼭~ ����
		File file = new File("User.txt");

		try {
			FileOutputStream fos = new FileOutputStream(filePath + "\\User.txt", false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(userMap);
			
			oos.close();
			fos.close();
			
			System.out.printf("Serialized HashMap data is saved in hashmap.ser");
	         
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("ȸ�� ������ ����Ǿ����ϴ�.");
		}

	}

	void loadUserList() {		// ȸ�� ����Ʈ �ε� �޴°� �ߵ� �ٵ� �������� ���� nullpointexception ��ϴ�!
		
		try {

			userMap = new HashMap<String, String>();
			
			FileInputStream fis = new FileInputStream(filePath +"\\User.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			userMap = (HashMap)ois.readObject();

			ois.close();
			fis.close();
		} catch (Exception e) {

		}
		
		System.out.println("Deserialized HashMap");
	    Set set = userMap.entrySet();
	    Iterator iterator = set.iterator();
	    while(iterator.hasNext()) {
	    	Map.Entry userMap = (Map.Entry)iterator.next();
	    	System.out.println("key: "+ userMap.getKey() + " & Value: "+userMap.getValue());
	    }
	}

	void savePersonEventList() {

		File file = new File("\\"+loginId+".txt");
		
		try {
			FileOutputStream fos = new FileOutputStream(userfilesPath+file);
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
		File file = new File("C:\\zProject\\User\\"+loginId+".txt");
		
		try {
			FileInputStream fis = new FileInputStream("C:\\zProject\\User\\"+loginId+".txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			pmMap = (HashMap)ois.readObject();

			ois.close();
			fis.close();
			
		} catch (Exception e) {

		}

	}


}