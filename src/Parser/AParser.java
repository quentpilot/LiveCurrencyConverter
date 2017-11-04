/**
 * @Description:        AParser class is used to manage each data currency in object from file
 *                      Parser and Writer classes would to inherit from this abstract class
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           AParser.java
 * @Date:               2017-11-04T14:35:18+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T14:35:26+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Parser;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import com.google.gson.Gson;

import src.Parser.Sorter;
import src.Parser.ParserException;

public abstract class AParser {

	/**
    * Iterates for each data object built
    *
    * @see Parser#getObjId()
    * @see Parser#parse()
    * @see Parser#build()
    */
    protected   int         objId = 0;

    /**
    * define standard file format
    *
    * @see Parser#getFormat()
    * @see Parser#isFormated()
    */
    protected   String      format = "json";

    /**
    * Main data parser would to get
    * Each valid json file is instanced
    * into new Sorter Class and stored as array
    *
    * @see Parser#getData()
    * @see Parser#parse()
    * @see Parser#build()
    */
    protected   Sorter[]    data = null;

    /**
    * Filename is used to know which is the
    * current file parsed and stored into Sorter object
    *
    * @see Parser#getFilename()
    * @see Parser#parse()
    * @see Parser#build()
    * @see Parser#isFormated()
    */
    protected   String      filename = null;

    /**
    * Resource is used by default as
    * repository reference to access
    * to the needed json files
    *
    * @see Parser#getResource()
    * @see Parser#Parser(String[] argv)
    * @see Parser#parse()
    */
    protected   String      resource = "resources/currency/";

    /**
    * Builds Sorter object following json file
    *
    * @throws IOException if any json file is badly formated
    *
    * @return bool type following success or failure of each
    *         Sorter objects built
    *
    * @see Parser#filename
    * @see Parser#data
    * @see Parser#objId
    * @see Parser#parse()
    * @see Parser#Parser()
    * @see Parser#Parser(String[] argv)
    * @see Sorter#Sorter()
    */
	protected boolean 	build() {return (false);}

    /**
    * Count Sorter array size
    *
    * @return number of object
    *
    * @see AParser#data
    */
    public int          size() {
        int         it = 0;
        Sorter[]    c = this.getData();

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
    * @see AParser#data
    */
    public int          list() {
        Sorter[]    c = this.getData();

        for (Sorter s : c) {
            System.out.println(s.getCountry());
        }
        return this.size();
    }

	/**
    * Get id of current object
    *
    * @return objId attribute
    *
    * @see Parser#objId
    */
	public int 			getObjId() {return (this.objId);}

	/**
    * Get current filename to parse
    *
    * @return filename attribute
    *
    * @see Parser#filename
    */
	public String		getFilename() {return (this.filename);}

	/**
    * Get file format autorized
    *
    * @return format attribute
    *
    * @see Parser#auto
    */
	public String 		getFormat() {return (this.format);}

	/**
    * Get Sorter array data from files parsed
    *
    * @return data attribute
    *
    * @see Parser#data
    */
	public Sorter[] 	getData() {return (this.data);}

	/**
    * Get repository source to parse files
    *
    * @return resource attribute
    *
    * @see Parser#resource
    */
	public String 		getResource() {return (this.resource);}

	/**
    * Computes how many files are stored
    *
    * @return number of files from array
    *
    * @see Parser#files
    * @see Parser#parse()
    */
	public int 			getSize() {return (0);}

	/**
    * Check if current file is well formated
    * first following by his own format
    *
    * @return true or false following file format
    *
    * @see Parser#filename
    * @see Parser#parse()
    */
	protected boolean	isFormated() {return (false);}
}
