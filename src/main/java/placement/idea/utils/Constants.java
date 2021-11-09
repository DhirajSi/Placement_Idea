package placement.idea.utils;

public class Constants {
	//form Regex
	public static final String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	public static final String nameRegex= "^[\\p{L} .'-]+$";
	//Error message
	public static final String emailErrorMessage = "Please enter valid emailId";
	public static final String userNameErrorMessage = "Please enter valid UserName";
	public static final String noErrorFound="NoErrorFound";
	public static final String UserEmailIdAlreadyExist="User emailId already exist";
	public static final String NewUserSaved="New User Successfully Saved!";

}
