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

	void signIn() { // 회원가입시 아이디와 패스워드를 받는다
		System.out.println("아이디와 패스워드를 입력하세요.");
		while (true) {
			System.out.println("이메일로 가입하세요.");
			System.out.print("아이디 : ");
			String userId = scan.nextLine();
			pm = new PersonManager();
			pmMap.put(userId, pm);

			user = new User();
			user.setId(userId);
			System.out.println("8자리 이상 영문자와 숫자로 만드세요.");
			System.out.print("패스워드 : ");
			user.setPassword(scan.nextLine().trim());

			if (!user.valID(user.getId())) {
				System.out.println("형식에 맞지 않는 아이디입니다. 다시 입력하세요.");

			} else if (userMap.containsKey(user.getId())) {
				System.out.println("이미 존재하는 아이디입니다.");
			} else if (!user.valPassword(user.getPassword())) {
				System.out.println("형식에 맞지 않는 패스 워드입니다. 다시 입력하세요.");
			} else {
				userMap.put(user.getId(), user.getPassword());
				System.out.println("회원가입이 완료되었습니다.");

				break;
			}
		}
		
	}

	void logIn() {// 아이디가 있는 회원 로그인 함수 //IO 파일 유저 해쉬맵로드하는 함수 추가

		// I/O 유저 퍼슨 매니져 해쉬맵 부러와야 함

		System.out.println("아이디와 패스워드를 입력하세요.");
		while (true) {
			System.out.print("아이디 : ");
			String inputId = scan.nextLine();
			System.out.println("패스워드 : ");
			String inputPassword = scan.nextLine();
			if (!userMap.containsKey(inputId)) {
				System.out.println("존재하지 않는 회원입니다.");
			} else if (!userMap.get(inputId).equals(inputPassword)) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			} else {
				System.out.println("로그인 되었습니다.");
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
		// 로그 아웃 할 시 유저, 퍼슨 매니져 해쉬맵 파일 저장...
	}

	void setPassword() {

		System.out.println("변경할 비밀번호를 입력하세요");
		String password = scan.nextLine();
		if (!user.valPassword(password)) {
			System.out.println("형식에 맞지 않는 비밀번호입니다. 비밀번호를 다시 설정하세요!");
		} else {
			userMap.put(loginId, password);
			System.out.println("변경되었습니다");
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
			System.out.println("회원 정보가 저장되었습니다.");
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
			System.out.println("저장되었습니다.");
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