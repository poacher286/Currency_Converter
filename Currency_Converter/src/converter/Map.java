package converter;

import java.util.*;

class Map
{
	public static String getCurrency(int index)
	{
		HashMap<Integer, String> myMap = new HashMap<Integer, String>();

		myMap.put(1 , "USD");
		myMap.put(2 , "INR");
		myMap.put(3 , "AUD");
		myMap.put(4 , "EUR");
		
		return myMap.get(index);
	}
}