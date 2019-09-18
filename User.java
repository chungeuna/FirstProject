public class User {
	String id;
	String idRegex =  "\\w+@\\w+\\.(com|net|org|)";
	String password;
	String passwordRegex = "\\w{8,}";
	
	public boolean checkIdRegex(String input) {
		if (!input.equals(idRegex)) {
			System.out.println("입력한 ID가 형식과 일치하지 않습니다!");
			return false;
		} else {
			System.out.println("ID 형식 확인완료!");
			return true;
		}
	}
	
	public boolean checkPasswordRegex(String input) {
		if (!input.equals(passwordRegex)) {
			System.out.println("입력한 Password가 형식과 일치하지 않습니다!");
			return false;
		} else {
			System.out.println("Password 형식 확인완료!");
			return true;
		}
	}
}
