package ManirAppointment.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.security.*;

import ManirAppointment.model.Patient;
import ManirAppointment.model.Staff;
import db.connection.ConnectionManager;

public class StaffDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static int staff_id, staff_phoneNum, manager_id;
	String staff_name, staff_password, staff_email, staff_role;
	
	// UCD CREATE ACCOUNT (STAFF REGISTRATION)
			public void addStaff(Staff bean) throws NoSuchAlgorithmException {
				staff_name = bean.getStaff_name();
		        staff_phoneNum = bean.getStaff_phoneNum();
		        staff_email = bean.getStaff_email();
		        staff_role = bean.getStaff_role();
		        staff_password = bean.getStaff_password();
		        manager_id = bean.getManager_id();

		        // encrypt password using md5
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        md.update(staff_password.getBytes());
		        byte byteData[] = md.digest();
		        // convert the byte to hex format
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < byteData.length; i++) {
		            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		        }
		        String pass = sb.toString();

		        try {
		           con = ConnectionManager.getConnection();
		            ps = con.prepareStatement(
		                    "INSERT INTO staff(staff_name, staff_phonenum, staff_email, staff_role, staff_password, manager_id)values(?,?,?,?,?,?)");
		            ps.setString(1, staff_name);
		            ps.setInt(2, staff_phoneNum);
		            ps.setString(3, staff_email);
		            ps.setString(4, staff_role);
		            ps.setString(5, pass);
		            ps.setInt(6, manager_id);
		            ps.executeUpdate();

		        } catch (SQLException e) {
		            e.printStackTrace();}
			}

//LOGIN STAFF
				
						public Staff LoginStaff(Staff s) throws NoSuchAlgorithmException{
							//get email and password
							staff_id = s.getStaff_id();
							staff_password = s.getStaff_password();
							
							//convert the password to MD5
								MessageDigest md = MessageDigest.getInstance("MD5");
								md.update(staff_password.getBytes());
								byte byteData[] = md.digest();
							//convert the byte to hex format
							StringBuffer sb = new StringBuffer();
							for (int i = 0; i < byteData.length; i++) {
								sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
							}	
							String query = "select * from staff where staff_id='" + staff_id + "'AND staff_password='" + sb.toString() + "'";
							
							try {
								con = ConnectionManager.getConnection();
								stmt = con.createStatement();
								rs = stmt.executeQuery(query);
								boolean more = rs.next();

								// if user exists set the isValid variable to true
								if (more) {
									int staff_id = rs.getInt("staff_id");
									s.setStaff_id(staff_id);
									s.setValid(true);			
									}
								// if user does not exist set the isValid variable to false
								else if (!more) {
									s.setValid(false);
								}

								} catch (SQLException e) {
									e.printStackTrace();
								}
							
							return s;
							
					}
						public static Staff getStaffById(int staff_id) {
							Staff s = new Staff();
							
							try {
								con = ConnectionManager.getConnection();
								ps=con.prepareStatement("select * from staff where staff_id=?");
						        
								ps.setInt(1, staff_id);
								ResultSet rs = ps.executeQuery();
						        
								
								if (rs.next()) {
									s.setStaff_id(rs.getInt("staff_id"));
									s.setStaff_name(rs.getString("staff_name"));
									s.setStaff_phoneNum(rs.getInt("staff_phonenum"));
									s.setStaff_email(rs.getString("staff_email"));
									s.setStaff_role(rs.getString("staff_role"));
									s.setStaff_password(rs.getString("staff_password"));
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
							return s;
						}
				//LIST OF STAFF
						public static List<Staff> getAllStaff() {
							List<Staff> staff = new ArrayList<Staff>();
							try {
								con = ConnectionManager.getConnection();
								stmt = con.createStatement();
								ResultSet rs = stmt.executeQuery("select staff_id, staff_name, staff_phonenum, staff_email, staff_role from staff");

								while (rs.next()) {
									Staff s = new Staff();
									s.setStaff_id(rs.getInt("staff_id"));
									s.setStaff_name(rs.getString("staff_name"));
									s.setStaff_phoneNum(rs.getInt("staff_phonenum"));
									s.setStaff_email(rs.getString("staff_email"));
									s.setStaff_role(rs.getString("staff_role"));
									staff.add(s);

								}
							} catch (SQLException e) {
								e.printStackTrace();
							}

							return staff;
						}

						public static void updateStaff(Staff staff) {
							// TODO Auto-generated method stub
							staff_id=staff.getStaff_id();
							staff_phoneNum=staff.getStaff_phoneNum();
							try {
								con = ConnectionManager.getConnection();
								String query = "UPDATE staff SET staff_phoneNum = '"+staff_phoneNum+"' WHERE staff_id= '"+staff_id+"' ";
							
							stmt = con.createStatement();
							stmt.executeUpdate(query);
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
					}
						
}
