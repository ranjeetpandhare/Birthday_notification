package application.bdaycontroller;

public class BirthdayConstant {
	public final static String SQL = "select fname,lname,day(dob) as day,month(dob) as month, email,pho,day(curdate())as currentday,month(curdate()) as currentmont from student_info;";
}
