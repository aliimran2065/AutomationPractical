package page;

import java.util.Random;


//Code for random number generator 
public class BasePage {
	public int generateRandomNum(int boundryNum) {
		Random rnd= new Random();
		int generatedNum = rnd.nextInt(boundryNum);
		return generatedNum;
		
	}

}
