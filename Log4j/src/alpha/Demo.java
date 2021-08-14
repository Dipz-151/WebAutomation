package alpha;
import org.apache.logging.log4j.*;
public class Demo {

	//Define logmanager first
	private static Logger log = LogManager.getLogger(Demo.class.getName());
	
	public static void main(String[] args) 
	{
		log.debug("I am debugging");
		if(2>1)
			log.info("Object is present");
			log.error("Object is not available");
		log.fatal("This is fatal");
	}

}
