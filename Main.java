import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	HashMap<String,String> userMap = new HashMap<String,String>();
	Scanner sc = new Scanner(System.in);
	User user; 
	
	void signIn() { //ȸ�����Խ� ���̵�� �н����带 �޴´� 
		System.out.println("���̵�� �н����带 �Է��ϼ���.");
		while(true) {
		System.out.println("�̸��Ϸ� �����ϼ���.");
		System.out.print("���̵� : ");		
		user = new User();
		user.id = sc.nextLine().trim(); 
		System.out.println("8�ڸ� �̻� �����ڿ� ���ڷ� ���弼��.");
		System.out.print("�н����� : ");
		user.password = sc.nextLine().trim();
		if(!user.valID(user.id)) {
			System.out.println("���Ŀ� ���� �ʴ� ���̵��Դϴ�. �ٽ� �Է��ϼ���.");
			 
		}else if(userMap.containsKey(user.id)) {
				System.out.println("�̹� �����ϴ� ���̵��Դϴ�.");		
			}else if(!user.valPassword(user.password)) {
				System.out.println("���Ŀ� ���� �ʴ� �н� �����Դϴ�. �ٽ� �Է��ϼ���.");
			}else {
				userMap.put(user.id,user.password);
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
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
		
	
	
	
	
	
	void ReSignIn() { //ȸ�����Խ� Ʋ���� ��츦 ó���ϴ� �Լ� 
				
	}
	void ReId() {
		
	}
	
	
}
