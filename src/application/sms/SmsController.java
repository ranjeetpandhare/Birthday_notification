package application.sms;

import java.util.ArrayList;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsController {

	public static void bdaysendingSms(ArrayList<String> listOfPhoneNumber) {

		if (listOfPhoneNumber.size() != 0) {
			Twilio.init(SmsConstant.ACCOUNT_SID, SmsConstant.AUTH_TOKEN);
			Message message = Message.creator(new PhoneNumber(listOfPhoneNumber.get(0)), // sender
					new PhoneNumber(SmsConstant.RECEIVER_PHONE_NUMBER), // receiver
					SmsWishCustomMessage.MESSAGE).create();

			System.out.println(message.getSid());
			System.out.println("Bday message send from sms");

			listOfPhoneNumber.remove(0);
			SmsController.bdaysendingSms(listOfPhoneNumber);
		} else {
			System.out.println();
		}

	}
}
