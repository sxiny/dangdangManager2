package src.com.baizhi.manager.util.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestSSS {
	
	public static void main(String[] args) {
		try {
			InetAddress[] name = InetAddress.getAllByName(null);
			System.out.println(name.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
