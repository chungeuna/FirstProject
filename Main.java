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

	void signIn() { // 회원가입시 아이디와 패스워드를 받는다
		System.out.println("아이디와 패스워드를 입력하세요.");
		while (true) {
			
			String userId = JOptionPane.showInputDialog("본인 이메일로 가입하세요 \n아이디: ");

			user = new User();
			user.setId(userId);
			
			String passWord = JOptionPane.showInputDialog("8자리 이상 영문자와 숫자로 만드세요. \n패스워드 : ");
			user.setPassword(passWord);

			if (!user.valID(user.getId())) {
				System.out.println("형식에 맞지 않는 아이디입니다. 다시 입력하세요.");

			} else if (userMap.containsKey(user.getId())) {
				System.out.println("이미 존재하는 아이디입니다.");
			} else if (!user.valPassword(user.getPassword())) {
				System.out.println("형식에 맞지 않는 패스 워드입니다. 다시 입력하세요.");
			} else {
				userMap.put(user.getId(), user.getPassword());
				pmMap.put(userId, new PersonManager());
				loginId = userId;
				saveUserList(); // 리스트 저장
				savePersonEventList(); // User Path에 파일 생성
				System.out.println("회원가입이 완료되었습니다.");

				break;
			}
		}

	}

	String logIn() {
		System.out.println("아이디와 패스워드를 입력하세요.");
		while (true) {
			System.out.print("아이디 : ");
			String inputId = scan.nextLine();
			System.out.print("패스워드 : ");
			String inputPassword = scan.nextLine();
			if (!userMap.containsKey(inputId)) {
				System.out.println("존재하지 않는 회원입니다.");
			} else if (!userMap.get(inputId).equals(inputPassword)) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			} else {
				System.out.println("로그인 되었습니다.");
				loginId = inputId;
				loadPersonEventList(); 
				return loginId;
			}
		}
	}

	void logOut() {

		saveUserList(); // 리스트 저장
		savePersonEventList();
		// 로그 아웃 할 시 유저, 퍼슨 매니져 해쉬맵 파일 저장...
	}

	void setPassword() {

		System.out.println("변경할 비밀번호를 입력하세요");
		String password = scan.nextLine();
		if (!user.valPassword(password)) {
			System.out.println("형식에 맞지 않는 비밀번호입니다. 비밀번호를 다시 설정하세요!");
		} else {
			userMap.put(loginId, password);
			//saveUserList();
			System.out.println("변경되었습니다");
		}
	}

	public String getLoginId() {
		return loginId;
	}

	void saveUserList() { // 회원 리스트만 출력 하면서~ 저장
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
			System.out.println("회원 정보가 저장되었습니다.");
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
			System.out.println("저장되었습니다.");
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