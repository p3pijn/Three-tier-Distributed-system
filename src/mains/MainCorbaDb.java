package mains;

import tier3.db.ItemDBA;
import tier3.db.ServerCORBA;

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
