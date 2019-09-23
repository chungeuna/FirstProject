import java.io.Serializable;
import java.util.regex.Pattern;

public class User implements Serializable{
	
	private String id;
	private String password;

	String idregex = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	String pwRegex = "^[a-zA-Z0-9]{8,}$";

	public boolean valID(String str) {
		boolean bl = str.matches(idregex);
		return bl;
	}

	public boolean valPassword(String str) {
		boolean bl = str.matches(pwRegex);
		return bl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}