public class User{

	@SerializedName("password")
	private String password;

	@SerializedName("employee_id")
	private String employeeId;

	@SerializedName("employee_name")
	private String employeeName;

	@SerializedName("username")
	private String username;

	public String getPassword(){
		return password;
	}

	public String getEmployeeId(){
		return employeeId;
	}

	public String getEmployeeName(){
		return employeeName;
	}

	public String getUsername(){
		return username;
	}
}
