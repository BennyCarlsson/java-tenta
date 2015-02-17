import java.util.Scanner;
//****************************************************************** 
//Programmerare: Benny Carlsson (bencar-4)
//Datum: 2015-01-16
//Senast uppdaterad: --
//Beskrivning: En Enkel Miniräknare som kan räkna ut formler med addition,subtraktion eller muliplikation
//Version: 1.0
//******************************************************************
public class SimpleCalculater {
	//------------------------------------------------------
	// Beskrivning: Startar programmet, presenterar menyn, 
	// tar in användarens inmatning, ger felmeddelande vid fel inmatning
	// ser till att programmet fortsätter köras efter att en uträkning gjorts
	//------------------------------------------------------
	public static void main(String[] args) {
		boolean running = true;
		Scanner keyboard = new Scanner(System.in);
		while(running){
			System.out.println("A Simple Calculater!");
			System.out.print("Enter your formula: ");
			String formula = keyboard.next();
			if(inputValidation(formula) == false){
				System.out.println("\nWrong input!");
				System.out.println("Your formula must use atleast one of: +,-,*");
				System.out.println("Example: 1+2+3\n");
			}else{
				calculate(formula);
			}			
		}
	}
	
	//------------------------------------------------------
	// Beskrivning: Validerar användarens input
	// Inparametrar: String input. formeln/värdet använderen skrev in
	// Returvärde: boolean true om valideringen går igenom annars false
	//-----------------------------------------------------
	private static boolean inputValidation(String input){
		//kollar så att input innehåller "+","-","*" men bara en utav dom
		if(input.contains("+") && input.contains("-")){
			return false;
		}else if(input.contains("+") && input.contains("*")){
			return false;
		}else if(input.contains("-") && input.contains("*")){
			return false;
		}else if(!input.contains("+") && !input.contains("-") 
				&& !input.contains("*")){
			return false;
		}
		return true;
	}
	
	//------------------------------------------------------
	// Beskrivning: Räknar ut formeln, presenterar uträkningen och resultatet
	// Inparametrar: String formula, formeln som användaren skrev in
	// Returvärde: void
	//-----------------------------------------------------
	private static void calculate(String formula){
		String indicator;
		if(formula.contains("+")){
			indicator = "+";
		}else if(formula.contains("-")){
			indicator = "-";
		}else{
			indicator = "*";
		}
		String stArray[] = formula.split("\\"+indicator);
		int result = Integer.parseInt(stArray[0]);
		for(int i = 1; i < stArray.length; i++){
			System.out.println("  "+result);
			System.out.println(indicator+" "+stArray[i]);
			if(indicator == "+"){
				result = result + Integer.parseInt(stArray[i]);
			}else if(indicator == "-"){
				result = result - Integer.parseInt(stArray[i]);
			}else{
				result = result * Integer.parseInt(stArray[i]);
			}
			System.out.println("----");
		}
		System.out.println("  "+result+"\n");
	}
}