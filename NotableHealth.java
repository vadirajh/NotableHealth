public class NotableHealth{
	public static int numericValue(String num_str) {
	    switch (num_str) {
	        case "ONE": return 1;
	        case "TWO": return 2;
	        case "THREE": return 3;
	        case "FOUR": return 4;
	        case "FIVE": return 5;
	        case "SIX": return 6;
	        case "SEVEN": return 7;
	        case "EIGHT": return 8;
	        case "NINE": return 9;
	    }
	    return 0;
	}
	public static String Manipulate (String docstr) {
		String t_str = new String();
		docstr = docstr.trim();
		String [] array_t_str = docstr.split("(?i)Number ", 2);
		//Pick the part before Number <one-nine>
		if (array_t_str.length==0)
			return "";
		if (array_t_str[0] == "") {
			//Handle case when there are no Number next
			String [] s_str = array_t_str[1].split("\\s+", 2);
			int counter2 = numericValue(s_str[0].toUpperCase());
			t_str += String.valueOf(counter2) + ".";
			t_str +=Character.toUpperCase(s_str[1].charAt(0)) + (s_str[1].length() > 1 ? s_str[1].substring(1) : "");
			return t_str;
		} else {
			t_str = array_t_str[0]+"\n";
		}
		String [] start_num_str = array_t_str[1].split("\\s+", 2);
		int counter = numericValue(start_num_str[0].toUpperCase());
		//Starting number append on new line.
		
		String [] p_str = array_t_str[1].split(" (?i)Number next ");
		for (String line:p_str) {
			t_str += String.valueOf(counter)+ ".";
			t_str += Character.toUpperCase(line.charAt(0)) + (line.length() > 1 ? line.substring(1) : "");
			t_str +="\n";
			counter++;
		}
		return t_str;
	}
	public static void main(String[] args) {
    	String myString = new String("Patient presents today with several issues. Number three BMI has increased by 10% "
    			+ "since their last visit number next patient reports experiencing dizziness several times "
    			+ "in the last two weeks. Number next patient has a persistent cough that hasn’t "
    			+ "improved for last 4 weeks Number next patient is taking drug number five several "
    			+ "times a week");
    	String myString2 = new String(" Number one hello world, how are you?");
    	String myString3 = new String("Patient presents today with several issues. Number five BMI has increased by 10% "
    			+ "since their last visit number next patient reports experiencing dizziness several times "
    			+ "in the last two weeks. Number Next patient has a persistent cough that hasn’t "
    			+ "improved for last 4 weeks Number next patient is taking drug number five several "
    			+ "times a week");
    	System.out.println( Manipulate(myString3));
    }
}
