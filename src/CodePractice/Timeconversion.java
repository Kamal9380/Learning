package CodePractice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Timeconversion {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
        String time = in.nextLine();
        //String input="";
       in.close();
        
              /*  name+=in.nextLine();
                scan.close();System.out.println("Your name is :"+name);
*/





        //String input = "01:22:12 PM";
	      //Format of the date defined in the input String
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss aa"); // Existing Pattern

        Date currentdate=simpleDateFormat.parse(time); // Returns Date Format,
        
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("HH:mm:ss"); // New Pattern

        System.out.println(simpleDateFormat1.format(currentdate));
	}

}
