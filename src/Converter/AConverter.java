/**
 * @Description:        AConverter class is used to compute Sorter array values
 * 											This class would be instanced and used from GUI classes
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           AConverter.java
 * @Date:               2017-11-04T14:31:00+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T14:32:06+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Converter;

import java.lang.reflect.Method;

import src.Parser.Sorter;

public class AConverter {

	/**
	* Current value to compute with currencies
	*
	* @see AConverter#getValue()
	* @see AConverter#setValue(float _value)
	*/
	public float 					value = 0f;

	/**
	* Sorter Array parsed by Parse
	*
	* @see AConverter#getCurrencies()
	*/
	public Sorter[] 				currencies = null;

	/**
	* Sorter Array parsed by Parse
	*
	* @see AConverter#toString()
	*/
	public String 					toString = null;

	/**
	* This method would to set each value from currency
	* country value in Sorter object
	*
	* @see AConverter#value
	* @see AConverter#currencies
	* @see AConverter#convert(String _currency)
	*/
	protected void 		set() {
		int 		it = 0;
		Sorter[] 	news = this.getCurrencies();

		for (Sorter val : news) {
			val.setValue(this.convert(val.getCurrency()));
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
	* @see AConverter#currencies
	* @see AConverter#value
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
	* @see AConverter#currencies
	* @see AConverter#value
	*/
	public String 		convert(Sorter data, String _value) {
		float val = Float.valueOf(data.getCurrency());
		return String.valueOf((val) * (Float.valueOf(_value)));
	}

	/**
	* Count Sorter array size
	*
	* @return number of object
	*
	* @see AConverter#currencies
	*/
	public int 			size() {
		int 		it = 0;
		Sorter[]	c = this.getCurrencies();
		for (Sorter s : c) {
			it++;
		}
		return it;
	}

	/**
	* List Sorter array object
	*
	* @return number of object
	*
	* @see AConverter#currencies
	*/
	public int 			list() {
		Sorter[]	c = this.getCurrencies();
		for (Sorter s : c) {
			System.out.println(s.getCountry() + " = " + s.getValue());
		}
		return this.size();
	}

	/**
	* Print string following value
	*
	* @param value
	* 				data to display
	*
	* @see AConverter#value
	* @see AConverter#currencies
	*/
	public static void 	print(String value) {
		System.out.print(value);
	}

	/**
	* Print string following value
	* with end return line
	* @param value
	* 				data to display
	*
	* @see AConverter#value
	* @see AConverter#currencies
	*/
	public static void 	println(String value) {
		System.out.println(value);
	}

	/**
	* Print formated string from Aconverter#list() format
	*
	* @see AConverter#value
	* @see AConverter#currencies
	*/
	public void 		printek() {
		this.list();
		this.println("");
	}

	/**
	* Get current value to compute
	*
	* @return value attribute
	*
	* @see AConverter#value
	*/
	public float 		getValue() {return (this.value);}

	/**
	* Set current value to compute
	*
	* @param _value
	*				value to set
	*
	* @see AConverter#value
	*/
	public void 		setValue(float _value) {this.value = _value;}

	/**
	* Get current currencies objects
	*
	* @return currencies attribute
	*
	* @see AConverter#currencies
	*/
	public Sorter[]		getCurrencies() {return (this.currencies);}

	/**
	* Build string following attributes values
	*
	* @return formated string result
	*
	* @see AConverter#value
	* @see AConverter#currencies
	*/
	public String		toString() {
		String 			str = "\t[******** AConverter Object Content ********]\n\n";
		String 			sstr = null;

        str += "\t\t\tVALUE = " + this.getValue() + "\n";
        str += "\t\t******* CURRENCIES *******\n";

        for (Sorter data : this.getCurrencies()) {
        	/**
        	* str += "\t" + data.toString();
        	*/
        	str += "\n\t******** Sorter Object Content ********\n\n";

	        str += "\tID = " + String.valueOf(data.getId()) + "\n";
	        str += "\tCOUNTRY = " + data.getCountry() + "\t\t";
	        str += "SLUG = " + data.getSlug() + "\n";
	        str += "\tCURRENCY = " + data.getCurrency() + "\t\t";
	        str += "VALUE = " + data.getValue() + "\n";
	        str += "\tICON = " + data.getIcon() + "\n";
        }

        toString = str;
        return str;
	}
}
