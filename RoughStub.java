/* ********************
 The rough code for a stub database
 Needs to act like the SQL database will
 
 Needs to be very similar to the SQL database:
	- the methods need to have the same signature and perform the same functions
	- data will be stored in memory (non-persistent)
******************** */
public class Database {
	/* static ArrayList, stored in memory to act as a database 
	for now, it only needs to handle one list */
	private static ArrayList<Object> list;

	public static void init() {
		list = new ArrayList<Object>();
	}

	public static void insert(item, listName) {
		list.add(item);
	}
	
	public static void update(ID, item, listName) {
		list.remove(ID);
		list.add(ID, item);
	}

	public static Object remove(ID, listName) {
		list.remove(ID);
	}

	private static Object query(item, listName) {
		
	}
}