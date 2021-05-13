package auth.api.model;

public class User {

	String id;
	String username;
    String jwt;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public User(String id, String username, String jwt) {
		super();
		this.id = id;
		this.username = username;
		this.jwt = jwt;
	}
    
    
	
	

}
