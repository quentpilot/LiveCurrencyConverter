/**
 * @Description:        AComputer class is used to compute a lot of data
 * 											Using values get from away
 * @Author:             Quentin Le Bian <quentpilot>
 * @Email:              quentin.lebian@pilotaweb.fr
 * @Project:            LiveCurrencyConverter
 * @About:              You're welcome to hack and code as your are each of theses sources files <3:p|--<;
 * @Filename:           AComputer.java
 * @Date:               2017-11-04T14:45:28+01:00
 * @Last modified by:   quentpilot
 * @Last modified time: 2017-11-04T16:14:13+01:00
 * @License:            MIT
 * @See:                projects.quentinlebian.fr/LiveCurrencyConverter
 */


package src.Computer;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

//public class AComputer<NA> {
public abstract class AComputer {

	/**
    * Current value to compute
    *
    * @see AComputer#tesla(String question)
    */
	protected String 		value;

	/**
    * Current value operator
    *
    * @see AComputer#tesla(String question)
    */
	protected String 		operator;

	/**
    * Result of computing
    *
    * @see AComputer#tesla(String question)
    */
	protected String 		result;

	/**
    * Type to return
    *
    * @see AComputer#tesla(String question)
    */
	protected String 		type;

	/**
    * This method would to compute math expression
    *
    * @param question
    * 					value to compute
    *
    * @return result after compute
    *
    * @see AComputer#value
    * @see AComputer#operator
    * @see AComputer#result
    * @see AComputer#type
    */
	public String 			tesla(String question) {
		try {
			ScriptEngineManager 	mgr = new ScriptEngineManager();
    		ScriptEngine 			engine = mgr.getEngineByName("JavaScript");
    		String 					res = String.valueOf(engine.eval(question));

			this.value = question;
			return (question);
		} catch (ScriptException e) {
			e.printStackTrace();
			return (question);
		}
	}


	/**
    * This method would to compute math expression
    *
    * @param answer
    * 					value to compute
    *
    * @return result after compute
    *
    * @see AComputer#value
    * @see AComputer#operator
    * @see AComputer#result
    * @see AComputer#type
    */
	public String 			einstein(String answer) {
		try {
			ScriptEngineManager mgr = new ScriptEngineManager();
    		ScriptEngine engine = mgr.getEngineByName("JavaScript");
    		String 					res = String.valueOf(engine.eval(answer));

			this.value = answer;
			return (answer);
		} catch (ScriptException e) {
			e.printStackTrace();
			return (answer);
		}
	}

	/**
    * Get value to compute
    *
    * @return value attribute
    *
    * @see AComputer#value
    */
	public String 			getValue() { return (this.operator); }

	/**
    * Get operator type
    *
    * @return operator attribute
    *
    * @see AComputer#operator
    */
	public String 			getOperator() { return (this.operator); }

	/**
    * Get value computed
    *
    * @return result attribute
    *
    * @see AComputer#result
    */
	public String 			getResult() { return (this.operator); }

}
