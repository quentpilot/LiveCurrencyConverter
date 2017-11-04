/**
 * @Description:        Converter class is used to manage Sorter array values
 * 											This class would be instanced and used from GUI classes
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Converter.java
 * @Date:               2017-11-04T14:31:29+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T14:31:41+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Converter;

import src.Parser.Sorter;

public class Converter extends AConverter {

	/**
	* Current value to compute with currencies
	*
	* @see Converter#Converter(Sorter[] _currencies, float _value)
	*/
	public float 					value = 0f;

	/**
	* Sorter Array parsed by Parse
	*
	* @see Converter#Converter(Sorter[] _currencies)
	* @see Converter#Converter(Sorter[] _currencies, float _value)
	*/
	public Sorter[] 				currencies = null;

	/**
	* This constructor would set instance
	*
	* @see Converter#Converter()
	*/
	public Converter() {}

	/**
	* This constructor would set Sorter Array currencies
	* then compute value for each object following
	* his own currency and value to use
	*
	* @param _currencies
	*					are objects parsed from json files
	*
	* @see Converter#value
	* @see Converter#currencies
	* @see Converter#set()
	*/
	public Converter(Sorter[] _currencies) {
		this.currencies = _currencies;
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
	*
	* @see Converter#value
	* @see Converter#currencies
	* @see Converter#set()
	*/
	public Converter(Sorter[] _currencies, float _value) {
		this.currencies = _currencies;
		this.value = _value;
		this.set();
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
		this.set();
		return true;
	}

	/**
	* Get current value to compute
	*
	* @return value attribute
	*
	* @see Converter#value
	*/
	public float 		getValue() {return (this.value);}

	/**
	* Set current value to compute
	*
	* @param _value
	*				value to set
	*
	* @see Converter#value
	*/
	public void 		setValue(float _value) {this.value = _value;}

	/**
	* Get current currencies objects
	*
	* @return currencies attribute
	*
	* @see Converter#currencies
	*/
	public Sorter[]		getCurrencies() {return (this.currencies);}
}
