package tier3.db;

/**
 * The main class for starting the CORBA server. 
 */
public class MainCorbaDb {

	public static void main(String[] args) 
	{
		ServerCORBA s = new ServerCORBA(args);
		s.attach(new ItemDBA("sdj_3_assigment", " items"),
				"Legacy database reference");
		s.run();
	}

}
