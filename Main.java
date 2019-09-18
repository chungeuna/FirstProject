import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	HashMap<String,String> userMap = new HashMap<String,String>();
	Scanner sc = new Scanner(System.in);
	User user; 
	
	void signIn() { //회원가입시 아이디와 패스워드를 받는다 
		System.out.println("아이디와 패스워드를 입력하세요.");
		while(true) {
		System.out.println("이메일로 가입하세요.");
		System.out.print("아이디 : ");		
		user = new User();
		user.id = sc.nextLine().trim(); 
		System.out.println("8자리 이상 영문자와 숫자로 만드세요.");
		System.out.print("패스워드 : ");
		user.password = sc.nextLine().trim();
		if(!user.valID(user.id)) {
			System.out.println("형식에 맞지 않는 아이디입니다. 다시 입력하세요.");
			 
		}else if(userMap.containsKey(user.id)) {
				System.out.println("이미 존재하는 아이디입니다.");		
			}else if(!user.valPassword(user.password)) {
				System.out.println("형식에 맞지 않는 패스 워드입니다. 다시 입력하세요.");
			}else {
				userMap.put(user.id,user.password);
				System.out.println("회원가입이 완료되었습니다.");
				break;
			}			
		}		
	}
	void logIn() {
		
	}
	
			
		
		
		
		 
	/*	if(user.password.length() < 8) {
			ReSignIn();
			user.password = sc.nextLine().trim();
		}*/
		/*while(user.password.length() < 8) {
			ReSignIn();
			user.password = sc.nextLine().trim();
		}*/
		
		
		
		
		
	//	sc.nextLine();
		
	
	
	
	
	
	void ReSignIn() { //회원가입시 틀렸을 경우를 처리하는 함수 
				
	}
	void ReId() {
		
	}
	
	
}
