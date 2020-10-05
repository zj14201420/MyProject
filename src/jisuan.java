import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class jisuan {
	static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");   
	public String number(String uncalcu) {
	    try {    
	        Object temp = jse.eval(uncalcu);  
	                String result =temp.toString();  
	                return result;  
	    } catch (Exception t) {    
	                return "º∆À„ Ω”–ŒÛ";  
	    }  
	}
}

