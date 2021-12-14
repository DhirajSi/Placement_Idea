package placement.idea.model;

public class AuthenticationResponse {

	
	private  String webToken;

	public AuthenticationResponse(String webToken) {
		super();
		this.webToken = webToken;
	}

	public String getWebToken() {
		return webToken;
	}

	public void setWebToken(String webToken) {
		this.webToken = webToken;
	}

	



}
