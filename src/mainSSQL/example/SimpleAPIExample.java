package mainSSQL.example;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import mainSSQL.SQLTable;
import mainSSQL.SSQLO;
import mainSSQL.types.SQLType;
import mainSSQL.types.SQLTypesEnum;

public class SimpleAPIExample {

	public static void main(String[] args) {
		boolean stopped = false;
		HashMap<String, SQLType> types = new HashMap<String, SQLType>();
		types.put("Kunde", (new SQLType(SQLTypesEnum.TINYTEXT)));
		types.put("Guthaben", (new SQLType(SQLTypesEnum.INT, 100)));
		types.put("Verifiziert", (new SQLType(SQLTypesEnum.BOOLEAN)));
		// Die HashMap für die Tabelle wurde erstellt. Sie beinhaltet eine
		// Spalte die 255 Zeichen aufnehmen kann und "Kunde" heist, eine Spalte
		// die eine Ganzzahl aufnehmen kann und eine maximale Zeichenlänge von
		// hundert haben darf und "Guthaben" heist, und eine Spalte namens
		// "Verifiziert" die den Typ BOOLEAN speichert.
		try {
			SSQLO SQL = new SSQLO("localhost", "3306", "test", "root",
					"xUOTZz1FNEaCO5hnZQml");
			SQLTable table = SQL.CreateTable(types, "FUBAR");
			Scanner sc = new Scanner(System.in);
			while(!stopped){
				System.out.println("1 = stoppen \n 2 = Eingabe tätigen \n 3 = Daten auslesen");
				int i = sc.nextInt();
				if(i == 1){
					stopped = true;
				}
				else if(i == 2){
					p("Bitte alle spalten mit einem Komma getrennt (ohne Leerezeichen) angeben");
					String input = sc.nextLine();
					String[] spalten
				}
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void p(String e) {
		System.out.println(e);
	}

}
