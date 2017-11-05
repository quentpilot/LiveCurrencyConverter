/**
 * @Description:        This class whould to load each project parts
 * 											is used to Convert Currencies from file
 *                      Using is own values or from live currencies values
 *                      Thanks to CurrencyLayer API, Class can get more than 160
 *                      different curriencies
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           CurrencyConverter.java
 * @Date:               2017-11-04T12:59:19+01:00
 * @Last modified by:   quentin
 * @Last modified time: 2017-11-05T01:40:09+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Core;

import src.Settings.Install.Installer;
import src.Reader.Reader;
import src.Parser.Parser;
import src.Computer.Computer;
import src.Converter.Converter;
import src.Converter.LiveConverter;

public class CurrencyConverter {

	/**
	* Main method which should run CurrencyConverter command-line program
	*
	* @param args
	* 						set some configurations when run program
	*
	* @see Reader
	* @see Parser
	* @see Converter
	*/
	public static void main(String[] args) {

			/**
			** CURRENT UNIT TESTS
			*/
			Installer 					i = new Installer(); // To check and set some data
			Reader              r = new Reader(); // To read STDIN
			Parser              p = new Parser(); // To Parse JSON files
			Computer            Albert = new Computer(); // To compute like a computer
			Converter           c = new Converter(); // To converter currencies data
			LiveConverter       l = new LiveConverter(false); // To converter currencies data from online API (or not)

			while (r.getRunning()) {
					System.out.print("[ Enter a value to compute currencies ]\n> ");
					r.read(); // read to STDIN
					if (!r.isNumeric() || r.getInput().equals("exit")) { // note: exit is useless
							r.setRunning(false); // to get out of loop
					}
					else {
							r.setInput(Albert.tesla(r.getInput())); // computes input value if needed
							c.convert(p.getData(), r.getInput(), false); // refresh our data from API (true/false)
							c.printek(); // print computed & formated currency values
					}
			}
	}
}
