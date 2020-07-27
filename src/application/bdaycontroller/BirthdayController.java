package application.bdaycontroller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import application.dbconnection.DBConnect;
import application.email.EmailController;
import application.sms.SmsController;

public class BirthdayController {
	public static String name = "";

	public static void email_sms_message_Sender() {
		ArrayList<String> listOfEmailid = new ArrayList<>();
		ArrayList<String> listOfPhoneNumber = new ArrayList<>();
		try {
			Connection connection = DBConnect.getConnection();
			Statement statement = connection.createStatement();
			String sql = BirthdayConstant.SQL;
			ResultSet resultset = statement.executeQuery(sql);

			while (resultset.next()) {
				if (resultset.getInt("month") == resultset.getInt("currentmont")
						&& resultset.getInt("day") == resultset.getInt("currentday")) {

					System.out.println(resultset.getString(5) + " " + resultset.getString(6));
					name = resultset.getString(1);

					listOfEmailid.add(resultset.getString(5));
					listOfPhoneNumber.add(resultset.getString(6));
				}
			}
			EmailController.bdaysendingMail(listOfEmailid);
			SmsController.bdaysendingSms(listOfPhoneNumber);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnect.getConnection().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}