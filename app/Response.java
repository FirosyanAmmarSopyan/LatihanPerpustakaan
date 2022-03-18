public class Response{

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private User user;

	@SerializedName("status")
	private String status;

	public String getMessage(){
		return message;
	}

	public User getUser(){
		return user;
	}

	public String getStatus(){
		return status;
	}
}
