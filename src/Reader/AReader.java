/**
 * @Description:        AReader abstrace class is used to read current STDIN or file stream
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           AReader.java
 * @Date:               2017-11-04T14:37:27+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T16:18:15+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Reader;

import java.io.*;

public abstract class AReader {
    /**
    * current input to read
    *
    * @see AReader#read()
    */
    protected   String         	input = null;

    /**
    * If it read into a loop
    *
    * @see AReader#read()
    */
    protected   boolean        	running = true;

    /**
    * current stream to read
    *
    * @see AReader#getStream()
    */
    protected   BufferedReader	stream = null;

    /**
    * Read the current stream, then return value
    *
    * @return value read
    *
    * @see AReader#input
    * @see AReader#stream
    */
    public String           read() {
    	try {
            String      value = null;
    		this.input = this.stream.readLine();
            this.isValid();
    		return this.getInput();
    	} catch(IOException e) {
    		e.printStackTrace();
    		System.out.println("Value is not an integer");
    		return null;
    	}
    }

    /**
    * Check if value is not null
    *
    * @return success or not
    *
    * @see AReader#getInput()
    */
    public boolean          isValid() {
        if (this.getInput() == null || this.getInput().length() == 0)
            return false;
        return true;
    }

    /**
    * Check if value is an integer
    *
    * @return success or not
    *
    * @see AReader#getInput()
    */
    public boolean          isNumeric()
    {
        return this.getInput().matches("-?\\d+(\\.\\d+)?");
    }

    /**
    * Check if value is an integer
    *
    * @param value
    *               current value to check
    *
    * @return success or not
    *
    * @see AReader#isNumeric()
    */
    public boolean          isNumeric(String value)
    {
        return value.matches("-?\\d+(\\.\\d+)?");
    }

    /**
    * Get value read by current stream
    *
    * @return value read
    *
    * @see AReader#input
    * @see AReader#read()
    */
    public String 			getInput() {return (this.input);}

    /**
    * Set input value
    *
    * @param value
    *               would to set current input value
    *
    * @see AReader#input
    */
    public void             setInput(String value) { this.input = value; }

    /**
    * Get running value
    *
    * @return value of running attribute
    *
    * @see AReader#running
    */
    public boolean 			getRunning() {return (this.running);}

    /**
    * Set running attribute
    *
    * @param run
    *             Set conditional while loop as run or not
    *
    * @see AReader#running
    */
    public void 			setRunning(boolean run) { this.running = run; }

    /**
    * Get value read by current stream
    *
    * @return value of stream attribute
    *
    * @see AReader#stream
    * @see AReader#read()
    */
    public BufferedReader	getStream() {return (this.stream);}

    /**
    * Set stream to read
    *
    * @param fd
    *           current stream opened
    *
    * @see AReader#stream
    */
    public void             getStream(BufferedReader fd) { this.stream = fd; }
}
