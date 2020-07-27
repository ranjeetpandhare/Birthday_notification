package application.email;

import java.util.Properties;

public class EmailConstant {
	public final static String SENDER_EMAIL_Id = "abc@gmail.com";
	public final static String SENDER_PASS = "gmailpassword";
	public final static String EMAIL_SMTP_SERVER = "smtp.gmail.com";
	public final static String EMAIL_SERVER_PORT = "465";
	public final static String USER = "mail.smtp.user";
	public final static String HOST = "mail.smtp.host";
	public final static String PORT = "mail.smtp.port";
	public final static String ENABLE = "mail.smtp.starttls.enable";
	public final static String AUTH = "mail.smtp.auth";
	public final static String SOCKETPORT = "mail.smtp.socketFactory.port";
	public final static String SOCKETCLASS = "mail.smtp.socketFactory.class";
	public final static String SOCKETFALLBACK = "mail.smtp.socketFactory.fallback";
	public final static String SOCKETFACTORY = "javax.net.ssl.SSLSocketFactory";
	static Properties properties = new Properties();
	static javax.mail.Session session;

	static void emailconst() {

		properties.put(USER, SENDER_EMAIL_Id);
		properties.put(HOST, EMAIL_SMTP_SERVER);
		properties.put(PORT, EMAIL_SERVER_PORT);
		properties.put(ENABLE, "true");
		properties.put(AUTH, "true");
		properties.put(SOCKETPORT, EMAIL_SERVER_PORT);
		properties.put(SOCKETCLASS, SOCKETFACTORY);
		properties.put(SOCKETFALLBACK, "false");

		session = javax.mail.Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(SENDER_EMAIL_Id, SENDER_PASS);
			}
		});

	}
}
