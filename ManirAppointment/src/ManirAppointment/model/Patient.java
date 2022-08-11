package ManirAppointment.model;

import java.util.Date;

public class Patient {
	
	private String pat_icNum;
	private String pat_name;
	private String pat_gender;
	private Date pat_DOB;
	private String pat_address;
	private int pat_phoneNum;
	private String pat_password;
	private boolean valid;
	
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getPat_icNum() {
		return pat_icNum;
	}
	public void setPat_icNum(String pat_icNum) {
		this.pat_icNum = pat_icNum;
	}
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	public String getPat_gender() {
		return pat_gender;
	}
	public void setPat_gender(String pat_gender) {
		this.pat_gender = pat_gender;
	}
	public Date getPat_DOB() {
		return pat_DOB;
	}
	public void setPat_DOB(Date pat_DOB) {
		this.pat_DOB = pat_DOB;
	}
	public String getPat_address() {
		return pat_address;
	}
	public void setPat_address(String pat_address) {
		this.pat_address = pat_address;
	}
	public int getPat_phoneNum() {
		return pat_phoneNum;
	}
	public void setPat_phoneNum(int pat_phoneNum) {
		this.pat_phoneNum = pat_phoneNum;
	}
	public String getPat_password() {
		return pat_password;
	}
	public void setPat_password(String pat_password) {
		this.pat_password = pat_password;
	}
}
