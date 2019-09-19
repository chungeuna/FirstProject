import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	HashMap<String, String> userMap = new HashMap<String, String>();
	Scanner sc = new Scanner(System.in);
	User user;

	void signIn() { // 회원가입시 아이디와 패스워드를 받는다
		System.out.println("아이디와 패스워드를 입력하세요.");
		while (true) {
			System.out.println("이메일로 가입하세요.");
			System.out.print("아이디 : ");
			user = new User();
			user.setId(sc.nextLine().trim());
			System.out.println("8자리 이상 영문자와 숫자로 만드세요.");
			System.out.print("패스워드 : ");
			user.setPassword(sc.nextLine().trim());
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

	void logIn() {// 아이디가 있는 회원 로그인 함수  //IO 파일 유저 해쉬맵로드하는 함수 추가 
		System.out.println("아이디와 패스워드를 입력하세요.");
		while (true) {
			System.out.print("아이디 : ");
			String inputId = sc.nextLine();
			System.out.println("패스워드 : ");
			String inputPassword = sc.nextLine();
			if (!userMap.containsKey(inputId)) {
				System.out.println("존재하지 않는 회원입니다.");
			} else if (!userMap.get(inputId).equals(inputPassword)) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			} else {
				System.out.println("로그인 되었습니다.");
				break;
			}
		}
	}
}
