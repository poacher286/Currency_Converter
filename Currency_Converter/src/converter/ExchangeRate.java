package converter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONObject;

public class ExchangeRate
{

	public static double getRate(String from, String to)
	{
		try
		{
			//http://free.currencyconverterapi.com/api/v5/convert?q=USD_INR&compact=y
			String sURL = "http://free.currencyconverterapi.com/api/v5/convert?q="+ from + "_" + to + "&compact=y";
			URL url = new URL(sURL);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine = br.readLine();

			JSONObject myResponse = new JSONObject(inputLine.toString());
			if (myResponse.toString().length() > 0)
			{
				JSONObject rate = new JSONObject(myResponse.getJSONObject(from + "_" + to).toString());
				return rate.getDouble("val");
			}
			br.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

		return 0;
	}
}
/*
 * //HttpURLConnection con = (HttpURLConnection) url.openConnection();
 * //BufferedReader br = new BufferedReader(new
 * InputStreamReader(con.getInputStream()));
 */
