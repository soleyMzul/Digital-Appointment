package ManirAppointment.model;

import java.sql.Date;

public class Appointment_Slot {
	private int appSlot_id;
	private int appSlot_quantity;
	private String appSlot_time;
	private Date appSlot_date;
	private int app_id;
	private int staff_id;
	
	Staff staff;
	
	public int getAppSlot_id() {
		return appSlot_id;
	}
	public void setAppSlot_id(int appSlot_id) {
		this.appSlot_id = appSlot_id;
	}
	public int getAppSlot_quantity() {
		return appSlot_quantity;
	}
	public void setAppSlot_quantity(int appSlot_quantity) {
		this.appSlot_quantity = appSlot_quantity;
	}
	
	public int getApp_id() {
		return app_id;
	}
	public void setApp_id(int app_id) {
		this.app_id = app_id;
	}
		
	public Date getAppSlot_date() {
		return appSlot_date;
	}
	public void setAppSlot_date(Date appSlot_date) {
		this.appSlot_date = appSlot_date;
	}
	public String getAppSlot_time() {
		return appSlot_time;
	}
	public void setAppSlot_time(String appSlot_time) {
		this.appSlot_time = appSlot_time;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
}
