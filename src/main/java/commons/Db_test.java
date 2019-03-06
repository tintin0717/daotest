package commons;

import java.util.ArrayList;
import java.util.HashMap;

public class Db_test {
	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> rs = Db.selectListMap("SELECT * FROM T_MOVIE");
		
		System.out.println(rs);
	}
}
