package logger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import controls.Button;
import controls.Input;
import controls.Label;

public aspect TestLogger {
	
	//A
	before (String url) :
	call (void WebDriver.get (String)) && args (url) {
		System.out.println ("Se accede a la pagina: " + url);
	}
	
	//B
	after (Button button) :
	call (void Button.click ()) && target (button) {
		System.out.println ("Se presiono el button: " + button.getBy ());
	}
	
	//C, nunca se obtiene el texto de un boton en los tests
	after (Button button) returning (String exitText) :
	call (String Button.text ()) && target (button) {
		System.out.println ("Se obtuvo el texto del button: " + button.getBy () + ", Texto: " + exitText);
	}
	after (Input input) returning (String exitText) :
	call (String Input.text ()) && target (input) {
		System.out.println ("Se obtuvo el texto del input: " + input.getBy () + ", Texto: " + exitText);
	}
	after (Label label) returning (String exitText)  :
	call (String Label.text ()) && target (label) {
		System.out.println ("Se obtuvo el texto del label: " + label.getBy () + ", Texto: " + exitText);
	}
	
	//D, no se realizan sleeps o waits en los tests
	before (long time) :
	call (void Thread.sleep (long)) && args (time) {
		System.out.println ("Se llamo a un sleep durante: " + time);
	}
	before (long time, TimeUnit timeUnit) :
	call (* *.implicitlyWait (long, TimeUnit)) && args (time, timeUnit) {
		System.out.println ("Se llamo a un wait durante: " + time + " " + timeUnit);
	}
	
	//E
	before (Input input, String text) :
	call (void Input.write (String)) && args (text) && target (input) {
		System.out.println ("Se escribio en un input: " + input.getBy () + ", Texto: " + text);
	}
	
	//G
	//Cada vez que se llama al close
	after () :
	call (void WebDriver.close ()) {
		System.out.println ("Se cerro una pestana.");
	}
	
	//Metodos visible de baseControl
	after (Button button) :
	call (boolean Button.visible ()) && target (button) {
		System.out.println ("Se verifico la visibilidad del button: " + button.getBy ());
	}
	after (Input input) :
	call (boolean Input.visible ()) && target (input) {
		System.out.println ("Se verifico la visibilidad del input: " + input.getBy ());
	}
	after (Label label) :
	call (boolean Label.visible ()) && target (label) {
		System.out.println ("Se verifico la visibilidad del label: " + label.getBy ());
	}
	
	//Metodos enabled de baseControl
	after (Button button) :
	call (boolean Button.enabled ()) && target (button) {
		System.out.println ("Se verifico estaba habilitado el button: " + button.getBy ());
	}
	after (Input input) :
	call (boolean Input.enabled ()) && target (input) {
		System.out.println ("Se verifico estaba habilitado el input: " + input.getBy ());
	}
	after (Label label) :
	call (boolean Label.enabled ()) && target (label) {
		System.out.println ("Se verifico estaba habilitado el label: " + label.getBy ());
	}
	
	//Metodos clickable de baseControl
	after (Button button) :
	call (boolean Button.clickable ()) && target (button) {
		System.out.println ("Se verifico si es clickeable el button: " + button.getBy ());
	}
	after (Input input) :
	call (boolean Input.clickable ()) && target (input) {
		System.out.println ("Se verifico si es clickeable el input: " + input.getBy ());
	}
	after (Label label) :
	call (boolean Label.clickable ()) && target (label) {
		System.out.println ("Se verifico si es clickeable el label: " + label.getBy ());
	}
	
	//El random siempre retorna 0 porque el valor maximo que obtiene de la lista 
	//de elementos en la pagina es 0
	after (double rand) returning (double result) :
	call (double Math.floor (double)) && args (rand) {
		System.out.println ("Se calculo un numero entero random: " + (int) result);
	}
	
}