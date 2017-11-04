/**
 * @Description:        Sorter class is used to get each data currency in object
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           Sorter.java
 * @Date:               2017-11-04T14:36:39+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T14:36:43+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Parser;

public class Sorter {

    /**
    * Iterate for each data object built
    *
    * @see Sorter#getId()
    * @see Sorter#Sorter(String _country, String _slug, String _currency, String _value, String _icon)
    */
    protected static int    counter = 1;

    /**
    * Id represents the number of Object instanciated
    *
    * @see Sorter#getId()
    * @see Sorter#Sorter(String _country, String _slug, String _currency, String _value, String _icon)
    */
    protected static int           id = 1;

    /**
    * Name of current counrty
    *
    * @see Sorter#getCountry()
    * @see Sorter#Sorter(String _country, String _slug, String _currency, String _value, String _icon)
    */
    protected String        country = null;

    /**
    * Short name which represents country currency
    *
    * @see Sorter#getSlug()
    * @see Sorter#Sorter(String _country, String _slug, String _currency, String _value, String _icon)
    */
    protected String        slug = null;

    /**
    * Reprensents value of related country
    *
    * @see Sorter#getCurrency()
    * @see Sorter#Sorter(String _country, String _slug, String _currency, String _value, String _icon)
    */
    protected String        currency = null;

    /**
    * Represents value computed between currencies
    *
    * @see Sorter#getValue()
    * @see Sorter#Sorter(String _country, String _slug, String _currency, String _value, String _icon)
    */
    protected String        value = null;

    /**
    * Represents icon of country currency window bloc
    *
    * @see Sorter#getIcon()
    * @see Sorter#Sorter(String _country, String _slug, String _currency, String _value, String _icon)
    */
    protected String        icon = null;

    /**
    * text built from attributes values
    *
    * @see Sorter#toString()
    */
    public String          toString = null;

    /**
    * Main Sorter constructor which iterator
    * for each new class instance
    *
    * @see Sorter#id
    * @see Sorter#counter
    */
    public Sorter() {
        id = counter;
        counter++;
    }

    /**
    * Main Sorter constructor which iterator
    * for each new class instance
    *
    * @param country
    *           current country
    * @param slug
    *           current slug
    * @param currency
    *           current currency
    * @param value
    *           current value
    * @param icon
    *           current icon
    *
    * @see Sorter#id
    * @see Sorter#counter
    * @see Sorter#country
    * @see Sorter#slug
    * @see Sorter#currency
    * @see Sorter#value
    * @see Sorter#icon
    */
    public Sorter(String country, String slug, String currency, String value, String icon) {
        id = counter;
        counter++;
        this.country = country;
        this.slug = slug;
        this.currency = currency;
        this.value = value;
        this.icon = icon;
    }

    /**
    * Get Object id
    *
    * @return id attribute
    *
    * @see Sorter#id
    */
    public int          getId() {return (id);}

    /**
    * Set Object id
    *
    * @param _id
    *               set current object id
    *
    * @see Sorter#id
    */
    public void         setId(int _id) { this.id = _id; }

    /**
    * Get name of country
    *
    * @return country attribute
    *
    * @see Sorter#country
    */
    public String       getCountry() {return (country);}

    /**
    * Get slug related to country
    *
    * @return slug attribute
    *
    * @see Sorter#slug
    */
    public String       getSlug() {return (slug);}

    /**
    * Get currency value
    *
    * @return currency attribute
    *
    * @see Sorter#currency
    */
    public String       getCurrency() {return (currency);}

    /**
    * Set Object currency
    *
    * @param _currency
    *               set current object currency
    *
    * @see Sorter#currency
    */
    public void         setCurrency(String _currency) { this.currency = _currency; }

    /**
    * Get value from currencies computes
    *
    * @return value attribute
    *
    * @see Sorter#value
    */
    public String       getValue() {return (value);}

    /**
    * Set Object value
    *
    * @param _value
    *               set current object value
    *
    * @see Sorter#value
    */
    public void         setValue(String _value) { this.value = _value; }

    /**
    * Get icon file path
    *
    * @return icon attribute
    *
    * @see Sorter#icon
    */
    public String       getIcon() {return (icon);}

    /**
    * Build string following each attribute value
    *
    * @return a string representing object data content
    *
    * @see Sorter#toString
    */
    public String       toString() {
        String str = "******** Sorter Object Content ********\n\n";

        str += "\t\tID = " + String.valueOf(this.getId()) + "\n";
        str += "COUNTRY = " + this.getCountry() + "\t\t";
        str += "SLUG = " + this.getSlug() + "\n";
        str += "CURRENCY = " + this.getCurrency() + "\t\t";
        str += "VALUE = " + this.getValue() + "\n";
        str += "ICON = " + this.getIcon() + "\n";
        toString = str;
        return str;
    }
}
