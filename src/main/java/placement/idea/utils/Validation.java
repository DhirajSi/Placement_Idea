package placement.idea.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation extends Constants {

	static String errorMessage = Constants.noErrorFound;

	public static String emailValidation(String email) {

		if (email == null || email.isEmpty()) {
			return Constants.emailErrorMessage;
		} else {
			Pattern pattern = Pattern.compile(Constants.emailRegex, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);

			if (matcher.find()) {
				return errorMessage;
			} else {
				return Constants.emailErrorMessage;
			}

		}

	}

	public static String userNameValidation(String userName) {

		if (userName == null || userName.isEmpty()) {
			return Constants.userNameErrorMessage;
		} else {
			Pattern pattern = Pattern.compile(Constants.nameRegex);
			Matcher matcher = pattern.matcher(userName);
			if (matcher.find()) {
				return errorMessage;
			} else {
				return Constants.userNameErrorMessage;
			}
		}

	}

	public static void main(String[] args) {
		String userName = "drjdac2@gmail.com";
		System.out.println(emailValidation(userName));
	}

}
