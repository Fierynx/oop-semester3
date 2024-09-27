package case_study_character;

import java.util.ArrayList;
import java.util.Scanner;

class Character{
	String name;
	
	Character(String name){ //constructor, best practice if we want to add new attribute to the character in the future
		this.name = name;
	}
}

public class CaseStudyCharacter {
	
	static String[] starterCharacters = {"Cecilion", "Carmilla"};
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Character> heroes = new ArrayList<>();

	public static void main(String[] args) {
		for (String c : starterCharacters) {
			Character character = new Character(c);
			heroes.add(character);
		}
		menu();
		System.out.println("Thank you!");
	}
	
	public static void menu() {
		boolean loop = true;
		while(loop) {
			System.out.println("------------------------");
			System.out.println("Welcome to Mobile Legends!");
			System.out.println("1. Add character");
			System.out.println("2. View all characters");
			System.out.println("3. Update character");
			System.out.println("4. Delete character");
			System.out.println("------------------------");
			System.out.print("Choose an option (input '0' to exit): ");
			
			boolean exception = false;
			int opsi = -1;
			try {
				opsi = scan.nextInt();
			}catch(Exception e) {
				cls();
				System.err.println("Please input an integer!");
				exception = true;
			}
			scan.nextLine();
			
			switch (opsi) {
			case 1:
				add();
				System.out.println("\nENTER to continue");
				scan.nextLine();
				cls();
				break;
			case 2:
				view();
				System.out.println("\nENTER to continue");
				scan.nextLine();
				cls();
				break;
			case 3:
				update();
				System.out.println("\nENTER to continue");
				scan.nextLine();
				cls();
				break;
			case 4:
				delete();
				System.out.println("\nENTER to continue");
				scan.nextLine();
				cls();
				break;
			case 0:
				cls();
				loop = false;
				break;
			default:
				if(!exception) {
					cls();
					System.err.println("Please input the correct option!");
				}
				
			}
		}
		
	}
	
	public static void add() {
		int jumlah = -1;
		do {
			try {
				System.out.print("Enter the amount of characters to be added: ");
				jumlah = scan.nextInt();
			}catch(Exception e) {
				System.err.println("Please input an integer!");
			}
			scan.nextLine();
		}while(jumlah < 0);
		
		for(int i = 0; i < jumlah; i++) {
			String name;
			do {
				System.out.print("Enter your character name: ");
				name = scan.nextLine();
			}while(name.isEmpty() || name.isBlank());
			
			Character character = new Character(name);
			heroes.add(character);
			System.out.printf("Successfully added %s to your character list!\n", name);
		}
	}
	
	public static void view() {
		if(heroes.size() <= 0) {
			System.out.println("No character exists!");
		}else {
			for (int i = 0; i < heroes.size(); i++) {
				System.out.printf("%d. %s\n", i+1, heroes.get(i).name);
			}
		}
		
	}
	
	public static void update() {
		if(heroes.size() <= 0) {
			System.err.println("No character exists!");
			return;
		}
		view();
		int num = -1;
		do {
			System.out.println("Enter the number of character to be updated: ");
			try {
				num = scan.nextInt();
			}catch(Exception e) {
				System.err.println("Please input an integer!");
			}
			scan.nextLine();
			
		}while(num <= 0 || num > heroes.size());
		
		System.out.print("Enter your new character name: ");
		String newName = scan.nextLine();
		Character character = new Character(newName);
		String oldName = heroes.get(num - 1).name;
		heroes.set(num - 1, character);
		System.out.printf("Successfully updated %s to %s!\n", oldName, newName);
	}
	
	public static void delete() {
		if(heroes.size() <= 0) {
			System.err.println("No character exists!");
			return;
		}
		view();
		int num = -1;
		do {
			System.out.println("Enter the number of character to be deleted: ");
			try {
				num = scan.nextInt();
			}catch(Exception e) {
				System.err.println("Please input an integer!");
			}
			scan.nextLine();
		}while(num <= 0 || num > heroes.size());
		String name = heroes.get(num - 1).name;
		heroes.remove(num - 1);
		System.out.printf("Successfully deleted %s!\n", name);
	}
	
	public static void cls() {
		for(int i = 0; i < 32; i++) {
			System.out.println();
		}
	}

}
