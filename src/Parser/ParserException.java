/**
 * @Description:        ParserException class inherits from IOException
 * 											used to catch errors when parse json file
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           ParserException.java
 * @Date:               2017-11-04T14:36:11+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T14:36:19+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Parser;

import java.io.IOException;

public class ParserException extends IOException {

	public ParserException() {super();}

	public ParserException(String message) {
		super(message);
	}

}
