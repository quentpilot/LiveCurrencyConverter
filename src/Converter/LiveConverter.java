/**
 * @Description:        LiveConverter class is used to manage Sorter array values
 * 											Thanks to CurrencyLayer API, Class can get more than 160
 * 											different curriencies
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           LiveConverter.java
 * @Date:               2017-11-04T14:00:29+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T16:11:10+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import src.Parser.Sorter;
import src.Writer.Writer;

public class LiveConverter extends AConverter implements ILiveConverterConfig {

	/**
	* Current value to compute with currencies
	*
	* @see LiveConverter#LiveConverter(Sorter[] _currencies, float _value)
	*/
	public float 					value = 1f;

	/**
	* Sorter Array parsed by Parse
	*
	* @see LiveConverter#LiveConverter(Sorter[] _currencies)
	* @see LiveConverter#LiveConverter(Sorter[] _currencies, float _value)
	*/
	public Sorter[]			 		currencies = null;

	/**
	* Private currencylayer API access key
	*
	* @see LiveConverter#connect()
	*/
	protected String				TOKEN = "dcb58b9b5616ec547b25f205561cea6f";

	/**
	* Base URL used to get online currencies
	*
	* @see LiveConverter#connect()
	*/
	protected static String 		URL = "http://apilayer.net/api/";

	/**
	* API repository type
	*
	* @see LiveConverter#connect()
	*/
	protected static String 		TYPE = "live";

	/**
	* Private currencylayer API access key
	*
	* @see LiveConverter#connect()
	*/
	static CloseableHttpClient 		httpClient = HttpClients.createDefault();

	/**
	* API json string result
	*
	* @see LiveConverter#connect()
	*/
	protected JSONObject			data = null;

	/**
	* Date of the last connection
	*
	* @see LiveConverter#connect()
	*/
	protected String				date = null;

	/**
	* To check if API connection has been established
	*
	* @see LiveConverter#connect()
	*/
	protected boolean				loged = false;

	/**
	* Update or not currencies json files
	*
	* @see LiveConverter#get(String slug)
	*/
	protected boolean				overight = false;

	/**
	* This constructor would set Sorter Array currencies
	* then compute value for each object following
	* his own currency and value to use
	*
	* @param _currencies
	*					are objects parsed from json files
	*
	* @see LiveConverter#value
	* @see LiveConverter#currencies
	* @see LiveConverter#set()
	*/
	public LiveConverter(Sorter[] _currencies) {
		this.currencies = _currencies;
		this.set();
	}

	/**
	* This constructor would set instance
	*
	* @see LiveConverter#LiveConverter()
	*/
	public LiveConverter() {}

	/**
	* This constructor would set instance
	*
	* @param _refresh
	* 								set refresh API data
	*
	* @see LiveConverter#connect()
	*/
	public LiveConverter(boolean _refresh) {
		if (_refresh)
			this.connect();
	}

	/**
	* This constructor would set Sorter Array currencies
	* then compute value for each object following
	* his own currency and value to use
	*
	* @param _currencies
	*					are objects parsed from json files
	* @param _value
	*					able you to set default value to compute
	*
	* @see LiveConverter#value
	* @see LiveConverter#currencies
	* @see LiveConverter#set()
	*/
	public LiveConverter(Sorter[] _currencies, float _value) {
		this.currencies = _currencies;
		this.value = _value;
		this.set();
	}

	/**
	* This constructor would set Sorter Array currencies
	* then compute value for each object following
	* his own currency and value to use
	*
	* @param _currencies
	*					are objects parsed from json files
	* @param _value
	*					able you to set default value to compute
	* @param _token
	*					able you to set your own API access key
	*
	* @see LiveConverter#value
	* @see LiveConverter#currencies
	* @see LiveConverter#TOKEN
	* @see LiveConverter#set()
	*/
	public LiveConverter(Sorter[] _currencies, float _value, String _token) {
		this.currencies = _currencies;
		this.value = _value;
		this.TOKEN = _token;
		this.set();
	}

	/**
	* This constructor would set Sorter Array currencies
	* then compute value for each object following
	* his own currency and value to use
	*
	* @param _currencies
	*					are objects parsed from json files
	* @param _value
	*					able you to set default value to compute
	* @param _overight
	*					able you to update current related file to Sorter
	*
	* @see LiveConverter#value
	* @see LiveConverter#currencies
	* @see LiveConverter#overight
	* @see LiveConverter#set()
	*/
	public LiveConverter(Sorter[] _currencies, float _value, boolean _overight) {
		this.currencies = _currencies;
		this.value = _value;
		this.overight = _overight;
		this.set();
	}

	/**
	* This method would to connect class
	* to currencylayer API
	*
	* @throws ClientProtocolException if connection fails
	* @throws IOException if any json file is badly formated
	* @throws ParseException if any json file is badly formated
	* @throws JSONException if any json file is badly formated
	*
	* @return TRUE or FALSE following success API connection
	*
	* @see LiveConverter#TOKEN
	* @see LiveConverter#URL
	* @see LiveConverter#TYPE
	* @see LiveConverter#httpClient
	* @see LiveConverter#data
	* @see LiveConverter#date
	* @see LiveConverter#loged
	*/
	protected boolean	connect() {
		HttpGet get = new HttpGet(URL + TYPE + "?access_key=" + TOKEN);

		try {
            CloseableHttpResponse 	response =  httpClient.execute(get);
            HttpEntity 				entity = response.getEntity();
            JSONObject 				exchangeRates = new JSONObject(EntityUtils.toString(entity));
            Date 					timeStampDate = new Date((long)(exchangeRates.getLong("timestamp")*1000));
            DateFormat 				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
            String 					formattedDate = dateFormat.format(timeStampDate);

            this.setData(exchangeRates);
            this.setDate(formattedDate);
            response.close();
            this.setLoged(true);
            return true;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
	}

	/**
	* This method would to parse API data results
	*
	* @param data
	*				current currency data to get
	*
	* @return value of current currency type
	*
	* @see LiveConverter#connect()
	* @see LiveConverter#convert(Sorter data, String _value)
	*/
	protected String	get(Sorter data) {
		if (!this.connect())
			return this.convert(data, String.valueOf(this.value));
		String value = "USD" + data.getSlug();
		String result = String.valueOf(this.data.getJSONObject("quotes").get(value));
		if (this.getOveright()) {
			Writer write = new Writer(data);
		}
		return result;
	}

	/**
	* This method would to parse API data results
	* currencylayer API
	*
	* @param slug
	*				currency type
	*
	* @return value of current currency type
	*
	* @see LiveConverter#connect()
	*/
	protected String	get(String slug) {
		String value = "USD" + slug;
		String result = String.valueOf(this.data.getJSONObject("quotes").get(value));
		return result;
	}

	/**
	* This method would to set each value from currency
	* country value in Sorter object
	*
	* @see LiveConverter#value
	* @see LiveConverter#currencies
	* @see LiveConverter#overight
	* @see LiveConverter#convert(String _currency)
	* @see LiveConverter#connect()
	* @see LiveConverter#get(String slug)
	*/
	protected void 		set() {
		int 		it = 0;
		Sorter[] 	news = this.getCurrencies();

		this.connect();
		for (Sorter val : news) {
			//if (this.getLoged())
				val.setCurrency(this.get(val.getSlug()));
			val.setValue(this.convert(val.getCurrency()));
			if (this.getOveright()) {
				Writer write = new Writer(val);
			}
		}
	}

	/**
	* This method would to set each value from currency
	* country value in Sorter object.
	* Check if it need to be connected or not
	*
	* @param refresh
	*									used to reload or not API data even if it's already loged
	*
	* @see LiveConverter#value
	* @see LiveConverter#currencies
	* @see LiveConverter#overight
	* @see LiveConverter#convert(String _currency)
	* @see LiveConverter#connect()
	* @see LiveConverter#get(String slug)
	*/
	protected void 		set(boolean refresh) {
		if (refresh)
			this.connect();
		Sorter[] 	news = this.getCurrencies();
		for (Sorter val : news) {
			//if (this.getLoged() && !refresh)
			if (this.getLoged())
				val.setCurrency(this.get(val.getSlug()));
			val.setValue(this.convert(val.getCurrency()));
			if (this.getOveright()) {
				Writer write = new Writer(val);
			}
		}
	}

	/**
	* This method would to compute related result
	* from value and country currency
	*
	* @param _currency
	*					current country currency value
	*
	* @return result of multiplication
	*
	* @see LiveConverter#currencies
	* @see LiveConverter#value
	*/
	protected String 	convert(String _currency) {
		return String.valueOf(Float.valueOf(_currency) * this.getValue());
	}

	/**
	* This method would to compute related result
	* from value and country currency
	*
	* @param data
	*					Sorter object to use for currency
	* @param _value
	*					current country currency value
	*
	* @return result of multiplication
	*
	* @see LiveConverter#currencies
	* @see LiveConverter#value
	* @see LiveConverter#get(Sorter data)
	*/
	public String 		convert(Sorter data, String _value) {
		String 			currency = this.get(data);

		if (currency == null)
			currency = data.getCurrency();
		float val = Float.valueOf(currency);
		return String.valueOf((val) * (Float.valueOf(_value)));
	}

	/**
	* This method would to compute related result
	* from value and country currency
	*
	* @param data
	*					Sorter object to use for currency
	* @param _value
	*					current country currency value
	* @param refresh
	*					refresh currencies value or not
	*
	* @return result of multiplication
	*
	* @see LiveConverter#currencies
	* @see LiveConverter#value
	* @see LiveConverter#get(Sorter data)
	*/
	public String 		convert(Sorter data, String _value, boolean refresh) {
		String 		currency = null;

		if (refresh) {
			currency = this.get(data);
			if (currency == null)
				currency = data.getCurrency();
		}
		else
			currency = data.getCurrency();
		float val = Float.valueOf(currency);
		return String.valueOf((val) * (Float.valueOf(_value)));
	}

	/**
	* This method would to compute related result
	* from value and country currency
	*
	* @param data
	*					Sorter object array to use for currency
	* @param _value
	*					current country currency value
	* @param refresh
	*					refresh currencies value from API or not
	*
	* @return result of multiplication
	*
	* @see LiveConverter#currencies
	* @see LiveConverter#value
	* @see LiveConverter#get(Sorter data)
	*/
	public boolean 	convert(Sorter[] data, String _value, boolean refresh) {
		this.currencies = data;
		this.value = Float.valueOf(_value);
		this.set(refresh);
		return true;
	}

	/**
	* This method would to compute related result
	* from value and country currency
	*
	* @param data
	*					Sorter object to use for currency
	* @param _value
	*					current country currency value
	* @param _overight
	*					able to update currencies file
	*
	* @return result of multiplication
	*
	* @see LiveConverter#currencies
	* @see LiveConverter#value
	* @see LiveConverter#overight
	* @see LiveConverter#get(Sorter data)
	*/
	public String 		wconvert(Sorter data, String _value, boolean _overight) {
		String 		currency = null;
		this.setOveright(_overight);
		currency = this.get(data);
		if (currency == null) {
			currency = data.getCurrency();
		}
		else
			currency = data.getCurrency();
		float val = Float.valueOf(currency);
		data.setValue(String.valueOf(val));
		return String.valueOf((val) * (Float.valueOf(_value)));
	}

	/**
	* Get current value to compute
	*
	* @return value attribute
	*
	* @see LiveConverter#value
	*/
	public float 		getValue() {return (this.value);}

	/**
	* Set current value to compute
	*
	* @param _value
	*				value to set
	*
	* @see LiveConverter#value
	*/
	public void 		setValue(float _value) {this.value = _value;}

	/**
	* Get current currencies objects
	*
	* @return currencies attribute
	*
	* @see LiveConverter#currencies
	*/
	public Sorter[]		getCurrencies() {return (this.currencies);}

	/**
	* Get current client token API
	*
	* @return TOKEN attribute
	*
	* @see LiveConverter#TOKEN
	*/
	public String		getToken() {return (this.TOKEN);}

	/**
	* Set current client token API
	*
	* @param token
	*				token to set
	*
	* @see LiveConverter#TOKEN
	*/
	public void 		setToken(String token) {this.TOKEN = token;}

	/**
	* Get current currencies API data
	*
	* @return data attribute
	*
	* @see LiveConverter#data
	*/
	public JSONObject	getData() {return (this.data);}

	/**
	* Set currencies API result
	*
	* @param _data
	*				values to set
	*
	* @see LiveConverter#data
	*/
	public void 		setData(JSONObject _data) {this.data = _data;}

	/**
	* Get last connexion date
	*
	* @return date attribute
	*
	* @see LiveConverter#date
	*/
	public String		getDate() {return (this.date);}

	/**
	* Set connexion date
	*
	* @param _date
	*				value to set
	*
	* @see LiveConverter#date
	*/
	public void 		setDate(String _date) {this.date = _date;}

	/**
	* Get status connection
	*
	* @return loged attribute
	*
	* @see LiveConverter#loged
	*/
	public boolean		getLoged() {return (this.loged);}

	/**
	* Set current client token API
	*
	* @param status
	*				value to set
	*
	* @see LiveConverter#loged
	*/
	public void 		setLoged(boolean status) {this.loged = status;}

	/**
	* Get overight connection
	*
	* @return overight attribute
	*
	* @see LiveConverter#overight
	*/
	public boolean		getOveright() {return (this.overight);}

	/**
	* Set available to update currencies files
	*
	* @param update
	*				value to set
	*
	* @see LiveConverter#overight
	*/
	public void 		setOveright(boolean update) {this.overight = update;}

	/**
	* Build string following attributes values
	*
	* @return formated string result
	*
	* @see LiveConverter#value
	* @see LiveConverter#currencies
	* @see LiveConverter#URL
	* @see LiveConverter#TYPE
	* @see LiveConverter#TOKEN
	*/
	public String		toString() {
		String 			str = "\t\t[******** LiveConverter Object Content ********]\n\n";
		String 			sstr = null;

        str += "\t\t\t\tVALUE = " + this.getValue() + "\n\n";
        str += "\t\t\t     ] API URL ACCESS [ \n\n";
        str += "[ " + URL + TYPE + "?access_key=" + TOKEN + " ]\n\n";
        str += "\t\t\tDATE = " + this.getDate() + "\n\n";
        str += "\t\t\t  ******* CURRENCIES *******\n";

        for (Sorter data : this.getCurrencies()) {
        	/**
        	* str += "\t" + data.toString();
        	*/
        	str += "\n\t\t   ******** Sorter Object Content ********\n\n";

	        str += "\t\t\t\t   ID = " + String.valueOf(data.getId()) + "\n";
	        str += "\t\tCOUNTRY = " + data.getCountry() + "\t\t";
	        str += "SLUG = " + data.getSlug() + "\n";
	        str += "\t\tCURRENCY = " + data.getCurrency() + "\t\t";
	        str += "VALUE = " + data.getValue() + "\n";
	        str += "\t\tICON = " + data.getIcon() + "\n";
        }

        toString = str;
        return str;
	}
}
