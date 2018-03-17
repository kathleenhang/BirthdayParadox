/*  Java Class: BirthdayParadox
    Author: Kathleen Hang
    Class: CSCI 220
    Date: 8/30/2017
    Description: Lab 1: P-1.3 Calculates the odds of at least one pair in the room 
    							having the same birthday given a preset of different amounts
    							 of people in the room.
*/
	
import java.util.Random;

public class BirthdayParadox 
{
	public static final int YEAR = 365;
	
	public static void main(String[] args){
		
		int numberOfPeople = 5;
		int experiment = 1;
		int [] daysInYear = new int [YEAR];
		
		//populate 365 array with days
		for(int i = 0; i < daysInYear.length; i++)
		{
			daysInYear[i] = i + 1;
		}
	
		Random randomNumber = new Random();
		
		//loop from 5, 10, 15, 20...100
		while(numberOfPeople <= 100)
		{
			//System.out.println("Experiment: " + experiment);
			//System.out.println();
			int matchCounter = 0;
			
			int [] birthdayRecord = new int[numberOfPeople];
			
			//populate birthdayRecord array with birthdays
			for(int i = 0; i < birthdayRecord.length; i++)
			{
				int day = randomNumber.nextInt(YEAR);
				birthdayRecord[i] = daysInYear[day];
			}
			
			for(int i = 0; i < birthdayRecord.length; i++)
			{
				int person1 = birthdayRecord[i];
				int person2 = i + 1;
				
				// compare person 1 against every other person in the group
				for(int j = person2; j < birthdayRecord.length; j++)
				{
					// increment match counter if the 2 people share same birthdays
					if(person1 == birthdayRecord[j])
					{
						matchCounter++;
					}
				}
			}
			System.out.println("Group of " + numberOfPeople + " = " + matchCounter + " birthday matches" );
			numberOfPeople += 5;
			experiment++;
		}
	}
}
