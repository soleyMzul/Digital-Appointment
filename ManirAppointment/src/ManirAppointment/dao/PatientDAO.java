package ManirAppointment.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.security.*;
import db.connection.ConnectionManager;
import ManirAppointment.model.Patient;


public class PatientDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null; 
	static int pat_phonenum;
	 String pat_name;
	static String pat_icNum;
	static String pat_address;
	String pat_password;
	String pat_gender;
	 Date pat_DOB;
	
	
	// UCD CREATE ACCOUNT (PATIENT REGISTRATION)
		public void addPatient(Patient bean) throws NoSuchAlgorithmException {
			// get email,name and password
			pat_icNum = bean.getPat_icNum();
			pat_name = bean.getPat_name();
			pat_gender = bean.getPat_gender();
			pat_DOB = (Date) bean.getPat_DOB();
			pat_address = bean.getPat_address();
			pat_phonenum = bean.getPat_phoneNum();
			pat_password = bean.getPat_password();

			// encrypt password using md5
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(pat_password.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			String pass = sb.toString();

			try {
				con = ConnectionManager.getConnection();
				ps = con.prepareStatement("INSERT INTO patient(pat_icNum, pat_name, pat_gender, pat_DOB, pat_address, pat_phonenum, pat_password)values(?,?,?,?,?,?,?)");
				ps.setString(1, pat_icNum);
				ps.setString(2, pat_name);
				ps.setString(3, pat_gender);
				ps.setDate(4, pat_DOB);
				ps.setString(5, pat_address);
				ps.setInt(6, pat_phonenum);
				ps.setString(7, pass);
				ps.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	//UCD LOGIN (PATIENT)
		public Patient LoginPatient(Patient pat) throws NoSuchAlgorithmException{
			//get email and password
			pat_icNum = pat.getPat_icNum();
			pat_password = pat.getPat_password();
			
			//convert the password to MD5
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(pat_password.getBytes());
				byte byteData[] = md.digest();
			//convert the byte to hex format
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}	
			String query = "select * from patient where pat_icNum='" + pat_icNum + "'AND pat_password='" + sb.toString() + "'";
			
			try {
				con = ConnectionManager.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				boolean more = rs.next();

				// if user exists set the isValid variable to true
				if (more) {
					String pat_icNum = rs.getString("pat_icNum");
					pat.setPat_icNum(pat_icNum);
					pat.setValid(true);			
					}
				// if user does not exist set the isValid variable to false
				else if (!more) {
					pat.setValid(false);
				}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			return pat;
			
	}
		
		public static Patient getPatientByIcNum(String pat_icNum) {
			Patient pat = new Patient();
			
			try {
				con = ConnectionManager.getConnection();
				ps=con.prepareStatement("select * from patient where pat_icnum=?");
		        
				ps.setString(1, pat_icNum);
				ResultSet rs = ps.executeQuery();
		        
				
				if (rs.next()) {
					pat.setPat_icNum(rs.getString("pat_icNum"));
					pat.setPat_name(rs.getString("pat_name"));
					pat.setPat_gender(rs.getString("pat_gender"));
					pat.setPat_DOB(rs.getDate("pat_DOB"));
					pat.setPat_address(rs.getString("pat_address"));
					pat.setPat_phoneNum(rs.getInt("pat_phonenum"));
					pat.setPat_password(rs.getString("pat_password"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return pat;
		}
				
		
	//UCD UPDATE ACCOUNT - PATIENT	
	public static void updatePatient (Patient updatePatient) {
		
		
		pat_address = updatePatient.getPat_address();
		pat_phonenum = updatePatient.getPat_phoneNum();
		
		try {
			con = ConnectionManager.getConnection();
			ps = con.prepareStatement("UPDATE patient SET pat_address = ?, pat_phonenum = ? WHERE pat_icNum = ?");
			ps.setString(1, pat_address);
			ps.setInt(2, pat_phonenum);
			ps.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//list all data patient
			public static List<Patient> getAllPatient() {
				List<Patient> pat = new ArrayList<Patient>();
				try {
					con = ConnectionManager.getConnection();
					stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("select pat_icNum, pat_name, pat_DOB, pat_gender, pat_phonenum, pat_address from patient");

					while (rs.next()) {
						Patient p = new Patient();
						p.setPat_icNum(rs.getString("pat_icNum"));
						p.setPat_name(rs.getString("pat_name"));
						p.setPat_DOB(rs.getDate("pat_DOB"));
						p.setPat_gender(rs.getString("pat_gender"));
						p.setPat_phoneNum(rs.getInt("pat_phonenum"));
						p.setPat_address(rs.getString("pat_address"));
						pat.add(p);

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return pat;
			}
	//update patient account
	public static void UpdatePatientAcc(Patient pat) {
				
				pat_icNum= pat.getPat_icNum();
				pat_phonenum = pat.getPat_phoneNum();
				pat_address = pat.getPat_address();
				
				try {
					con = ConnectionManager.getConnection();
					
					String query = "UPDATE patient SET pat_phonenum = '"+pat_phonenum+"', pat_address = '"+pat_icNum+"' WHERE pat_icNum= '"+pat_icNum+"' ";
					
					stmt = con.createStatement();
					stmt.executeUpdate(query);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}

	
}

