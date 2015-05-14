package tier3.crane.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class FileIO {
	
	public static void createDir(String path)
	{
		File f = new File(path);
		if(!f.exists())
			f.mkdir();
	}

	public static String nextFileName(int length, String path)
	{
		String fileName;
		File f;
		do
		{
			fileName = RandomString.nextString(length);
			f = new File(path + fileName);
		}
		while(f.exists());
		return fileName;
	}

	public static Object readDelete(String fileName)
	{
		Object o = null;
		try
		{	
			File f = new File(fileName);
			ObjectInputStream readO=new ObjectInputStream(new FileInputStream(f));
			o=readO.readObject();
			readO.close();
			f = new File(fileName);
			f.delete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	public static void write(String fileName,Object ob)
	{
		try
		(ObjectOutputStream writeO=new ObjectOutputStream(new FileOutputStream(fileName));)
		{
			writeO.writeObject(ob);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static class RandomString {

		private static final char[] symbols;

		static {
			StringBuilder tmp = new StringBuilder();
		    for (char ch = '0'; ch <= '9'; ++ch)
		    	tmp.append(ch);
		    for (char ch = 'a'; ch <= 'z'; ++ch)
		        tmp.append(ch);
		    symbols = tmp.toString().toCharArray();
		}   

		private static final Random random = new Random();

		public static String nextString(int length)
		{
			char[] buf = new char[length];
			for (int idx = 0; idx < buf.length; ++idx) 
				buf[idx] = symbols[random.nextInt(symbols.length)];
			return new String(buf);
		}
	}

	public static int countFiles(String path) {
		return new File(path).list().length;
	}
}
