package ManirAppointment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ManirAppointment.model.Appointment_Slot;
import db.connection.ConnectionManager;
import java.util.ArrayList;
import java.util.List;
import java.security.*;
import db.connection.ConnectionManager;

public class AppointmentSlotDAO {

	static Connection con = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	static ResultSet rs = null; 
	static int appSlot_id;
	static int appSlot_quantity;
	static String appSlot_time;
	static Date appSlot_date;
	
	//list all slot
	public static List<Appointment_Slot> getAllSlot() {
		List<Appointment_Slot> appSlot = new ArrayList<Appointment_Slot>();
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select appSlot_id, appSlot_time, appSlot_date, appSlot_quantity from appointment_slot");

			while (rs.next()) {
				Appointment_Slot p = new Appointment_Slot();
				p.setAppSlot_id(rs.getInt("appSlot_id"));
				p.setAppSlot_time(rs.getString("appSlot_time"));
				p.setAppSlot_date(rs.getDate("appSlot_date"));
				p.setAppSlot_quantity(rs.getInt("appSlot_quantity"));
				
				appSlot.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return appSlot;
	}
}
