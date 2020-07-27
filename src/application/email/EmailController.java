package application.email;

import java.util.ArrayList;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailController {

	public static void bdaysendingMail(ArrayList<String> listOfEmail) {
		EmailConstant.emailconst();
		if (listOfEmail.size() != 0) {

			try {
				javax.mail.Message message = new MimeMessage(EmailConstant.session);
				message.setFrom(new InternetAddress(EmailConstant.SENDER_EMAIL_Id));
				message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(listOfEmail.get(0)));
				message.setSubject("Birthday Wishes");
				message.setText(EmailWishCustomMessage.MESSAGE);
				Transport.send(message);
				System.out.println(" Bday message send from email");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error in try");
			}
			listOfEmail.remove(0);
			EmailController.bdaysendingMail(listOfEmail);
		}

		// else {
		// System.out.println("No Record Found");
		// }

	}

}
