/**
 * @Description:        Reader class is used to read current STDIN or file stream
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Reader.java
 * @Date:               2017-11-04T14:37:40+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T16:17:41+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Reader;

import java.io.*;
import src.Reader.AReader;

public class Reader extends AReader {

    /**
    * This constructor would to read standard input STDIN
    *
    * @see Reader#stream
    */
    public                  Reader() {
        BufferedReader  in = new BufferedReader(new InputStreamReader(System.in));

    	this.stream = in;
    }

    /**
    * This constructor would to read a file
    *
    * @param filename
    *                 file path to read
    *
    * @see Reader#stream
    */
    public                  Reader(String filename) {
        try {
    	   BufferedReader	in = new BufferedReader(new FileReader(filename));

        	this.stream = in;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
