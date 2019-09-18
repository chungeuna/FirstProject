public class User {
	String id;
	String idRegex =  "\\w+@\\w+\\.(com|net|org|)";
	String password;
	String passwordRegex = "\\w{8,}";
	
	public boolean checkIdRegex(String input) {
		if (!input.equals(idRegex)) {
			System.out.println("�Է��� ID�� ���İ� ��ġ���� �ʽ��ϴ�!");
			return false;
		} else {
			System.out.println("ID ���� Ȯ�οϷ�!");
			return true;
		}
	}
	
	public boolean checkPasswordRegex(String input) {
		if (!input.equals(passwordRegex)) {
			System.out.println("�Է��� Password�� ���İ� ��ġ���� �ʽ��ϴ�!");
			return false;
		} else {
			System.out.println("Password ���� Ȯ�οϷ�!");
			return true;
		}
	}
}
