/**
 * @Description:        Writer class is used to get each data currency in object
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Writer.java
 * @Date:               2017-11-04T14:36:53+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T14:44:53+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Writer;

import java.io.IOException;
import java.io.FileWriter;
import java.lang.reflect.Array;
import com.google.gson.Gson;

import src.Parser.AParser;
import src.Parser.Sorter;
import src.Parser.ParserException;

public class Writer extends AParser {
    /**
    * Iterates for each data object built
    *
    * @see Writer#getObjId()
    */
    protected   int         objId = 0;

    /**
    * define standard file format
    *
    * @see Writer#getFormat()
    * @see Writer#isFormated()
    */
    protected   String      format = ".json";

    /**
    * Main data Writer would to get
    * Each valid json file is instanced
    * into new Sorter Class and stored as array
    *
    * @see Writer#getData()
    * @see Writer#write()
    * @see Writer#build(Sorter _data)
    */
    protected   Sorter[]    data = null;

    /**
    * Filename is used to know which is the
    * current object to write in file
    *
    * @see Writer#getFilename()
    * @see Writer#write()
    * @see Writer#build(Sorter _data)
    */
    protected   String      filename = null;

    /**
    * Resource is used by default as
    * repository reference to access
    * to the needed json files
    *
    * @see Writer#getResource()
    * @see Writer#write()
    */
    protected   String      resource = "resources/currency/";

    /**
    * Main Writer constructor which set data
    *
    * @see Writer#data
    */
    public                  Writer() {
        this.data = new Sorter[100];
    }

    /**
    * Second Writer constructor which set Sorter array
    *
    * @param _data
    *               Sorter array to genere file
    *
    * @see Writer#data
    */
    public                  Writer(Sorter[] _data) {
        this.data = new Sorter[100];
        this.data = _data;
        this.write();
    }

    /**
    * Third Writer constructor which set unique object
    *
    * @param _data
    *               Sorter object to store and get-in-file
    *
    * @see Writer#data
    */
    public                  Writer(Sorter _data) {
        this.data = new Sorter[1];
        this.data[0] = _data;
        this.write();
    }

    /**
    * Add new Sorter instance to current data Array
    *
    * @param _data
    *               store current Sorter object to list
    *
    * @see Writer#data
    */
    public void       add(Sorter _data) {
        this.data[_data.getId()] = new Sorter();
        this.data[_data.getId()] = _data;
    }

    /**
    * Parse related json files and store
    * them as Objects Array to work with
    *
    * @return Success or not
    *
    * @see Writer#data
    * @see Writer#filename
    * @see Writer#resource
    * @see Writer#isFormated()
    */
    public boolean          write() {

        if (this.getSize() <= 0)
            return false;
        for (Sorter d : this.getData()) {
            if (d != null) {
                String  country = d.getCountry();
                this.filename = this.getResource() + country.substring(0, 1).toUpperCase() + country.substring(1) + this.getFormat();
                this.build(d);
            }
        }
        return true;
    }

    /**
    * Build writer while loop
    *
    * @param _data
    *                current data to genere file
    *
    * @return bool type following success or failure of each
    *         Sorter objects
    *
    * @see Writer#data
    */
    protected boolean       build(Sorter _data) {
        try {
            Gson            gson = new Gson();
            String          json = gson.toJson(_data);
            FileWriter      file = new FileWriter(this.getFilename());

            file.write(json);
            file.close();
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
    * Computes how many Sorter are stored
    *
    * @return number of object from array
    *
    * @see Writer#data
    */
    public int              getSize() {
        if (this.data == null)
            return 0;
        return 1;
    }

    /**
    * Check if current object is well formated
    *
    * @return true or false following data set
    *
    * @see Sorter#Sorter()
    */
    protected boolean       isFormated() {
        return false;
    }

    /**
    * Get id of current object
    *
    * @return objId attribute
    *
    * @see Writer#objId
    */
    public int              getObjId() {return (this.objId);}

    /**
    * Get file format autorized
    *
    * @return format attribute
    *
    * @see Writer#write()
    */
    public String           getFormat() {return (this.format);}

    /**
    * Get Sorter array data from files parsed
    *
    * @return data attribute
    *
    * @see Writer#data
    */
    public Sorter[]         getData() {return (this.data);}

    /**
    * Get current filename to parse
    *
    * @return filename attribute
    *
    * @see Writer#filename
    */
    public String           getFilename() {return (this.filename);}

    /**
    * Get repository source to parse files
    *
    * @return resource attribute
    *
    * @see Writer#resource
    */
    public String           getResource() {return (this.resource);}
}
