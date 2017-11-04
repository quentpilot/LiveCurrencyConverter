/**
 * @Description:        Parser class is used to get each data currency in object
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Parser.java
 * @Date:               2017-11-04T14:35:56+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T14:36:00+01:00
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
import src.Parser.AParser;

public class Parser extends AParser {
    /**
    * Iterates for each data object built
    *
    * @see Parser#getObjId()
    * @see Parser#parse()
    * @see Parser#build()
    */
    protected   int         objId = 0;

    /**
    * used to know if Parser uses basic resource folder
    * or from standard input
    *
    * @see Parser#getAuto()
    * @see Parser#Parser(String[] argvs)
    */
    protected   boolean     auto = true;

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
    * Used to store each file entered as args
    * then Parse would use these files
    * instead of basic resource repository
    *
    * @see Parser#getArgFiles()
    * @see Parser#Parser(String[] args)
    */
    protected   String[]    argFiles = null;

    /**
    * Store files reading by folder reader
    *
    * @see Parser#getFiles()
    * @see Parser#parse()
    * @see Parser#build()
    */
    protected   File[]      files = null;

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
    * Main Parser constructor which launch parser
    *
    * @see Parser#Parser()
    * @see Parser#Parser(String[] args)
    */
    public                  Parser() {
        this.parse();
    }

    /**
    * Second Parser constructor which launch parser
    * after setting related attributes
    *
    * @param args
    *               Files arguments passed as paramareter
    *
    * @see Parser#argFiles
    * @see Parser#auto
    * @see Parser#resource
    * @see Parser#Parser()
    * @see Parser#Parser(String[] args)
    */
    public                  Parser(String[] args) {
        this.argFiles = args;
        this.auto = false;
        this.resource = "/";
        this.parse();
    }

    /**
    * Parse related json files and store
    * them as Objects Array to work with
    *
    * @see Parser#data
    * @see Parser#files
    * @see Parser#filename
    * @see Parser#resource
    * @see Parser#Parser()
    * @see Parser#Parser(String[] argv)
    * @see Parser#build()
    * @see Parser#isFormated()
    * @see Sorter#Sorter()
    */
    protected void          parse() {
        String  path = this.resource;
        File    repo = new File(path);
        File[]  files = repo.listFiles();

        this.files = files;
        this.data = new Sorter[this.getSize()];
        for (File f : files) {
            path = "";
            if (f.isFile()) {
                path = this.getResource() + f.getName();
                this.filename = path;
                if (this.isFormated()) {
                    if (this.build()) {
                        //System.out.println(this.getData()[this.getObjId()].toString());
                        this.objId++;
                    }
                }
            }
        }
    }

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
    protected boolean       build () {
        try {
            Gson            gson = new Gson();
            BufferedReader  br = new BufferedReader(new FileReader(this.getFilename()));
            Sorter          currency = gson.fromJson(br, Sorter.class);

            this.data[this.getObjId()] = currency;
            return true;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    /**
    * Computes how many files are stored
    *
    * @return number of files from array
    *
    * @see Parser#files
    * @see Parser#parse()
    */
    public int              getSize() {
        int     it = 0;
        for (File f : this.getFiles()) {
            it++;
        }
        return it;
    }

    /**
    * Check if current file is well formated
    * first following by his own format
    *
    * @return true or false following file format
    *
    * @see Parser#filename
    * @see Parser#parse()
    */
    protected boolean       isFormated() {
        String[]   file = this.filename.split("\\.");

        for (String str : file) {
            if (str.equals(this.getFormat()))
                return true;
        }
        return false;
    }

    /**
    * Get id of current object
    *
    * @return objId attribute
    *
    * @see Parser#objId
    */
    public int              getObjId() {return (this.objId);}

    /**
    * Get boolean auto value
    *
    * @return auto attribute
    *
    * @see Parser#auto
    */
    public boolean          getAuto() {return (this.auto);}

    /**
    * Get file format autorized
    *
    * @return format attribute
    *
    * @see Parser#auto
    */
    public String           getFormat() {return (this.format);}

    /**
    * Get Sorter array data from files parsed
    *
    * @return data attribute
    *
    * @see Parser#data
    */
    public Sorter[]         getData() {return (this.data);}

    /**
    * Get array of files given as arguments
    *
    * @return argFiles attribute
    *
    * @see Parser#argFiles
    */
    public String[]         getArgFiles() {return (this.argFiles);}

    /**
    * Get files read
    *
    * @return files attribute
    *
    * @see Parser#files
    */
    public File[]           getFiles() {return (this.files);}

    /**
    * Get current filename to parse
    *
    * @return filename attribute
    *
    * @see Parser#filename
    */
    public String           getFilename() {return (this.filename);}

    /**
    * Get repository source to parse files
    *
    * @return resource attribute
    *
    * @see Parser#resource
    */
    public String           getResource() {return (this.resource);}
}
