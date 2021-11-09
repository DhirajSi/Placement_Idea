package placement.idea.model;
import javax.persistence.Id;
import javax.persistence.Entity;



@Entity
public class SignUpUsers {
	private String userName;
	@Id
	private String emailId;
	private String mobileNo;
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public String toString() {
		return "SignUpUsers [userName=" + userName + ", emailId=" + emailId + ", mobileNo=" + mobileNo + ", password="
				+ password + "]";
	}
}
