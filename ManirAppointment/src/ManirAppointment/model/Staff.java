package ManirAppointment.model;

public class Staff {
	private int staff_id;
	private String staff_name;
	private int staff_phoneNum;
	private String staff_email;
	private String staff_role;
	private String staff_password;
	private boolean valid;
	private int manager_id; 
	Staff staff;
	
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public int getStaff_phoneNum() {
		return staff_phoneNum;
	}
	public void setStaff_phoneNum(int staff_phoneNum) {
		this.staff_phoneNum = staff_phoneNum;
	}
	public String getStaff_email() {
		return staff_email;
	}
	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}
	public String getStaff_role() {
		return staff_role;
	}
	public void setStaff_role(String staff_role) {
		this.staff_role = staff_role;
	}
	public String getStaff_password() {
		return staff_password;
	}
	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public void setManager_Id(int staff_id) {
		setManager_id(staff_id);
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	
}