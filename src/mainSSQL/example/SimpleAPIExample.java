package mainSSQL.example;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import mainSSQL.RowContainer;
import mainSSQL.SQLTable;
import mainSSQL.SSQLO;
import mainSSQL.TContent.SQLRow;
import mainSSQL.TContent.fields.SQLValue;
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
			String[] daten = new String[3];
			daten[0] = sc.nextLine(); // Daten eingeben
			daten[1] = sc.nextLine();
			daten[2] = sc.nextLine();
			table.putData(daten, table.getColumns());// Daten in die Tabelle
														// packen
			p("Bitte Kunde eingeben nach dem Gesucht werden soll:");
			RowContainer c = table.getRowsByValue(table.getColumn("Kunde"),
					sc.nextLine()); // Herausfinden in welchen Zeilen der Wert
									// in Spalte "Kunde" der eingaben entspricht
			for (SQLRow cr : c) {
				System.out.println(cr.DataToString()); // Einfach alle Zeilen
														// die oben entstanden
														// sind ausgeben
			}
			p("Bitte Kunden für den ein Update gemacht werden soll angeben:");
			p("Bitte neues Guthaben eingeben:");
			c = table.getRowsByValue(table.getColumn("Kunde"), sc.nextLine()); // Genau
																				// wie
																				// oben
			for (SQLRow cr : c) {
				cr.getField(table.getColumn("Guthaben")).setValue(
						(new SQLValue(sc.nextLine()))); // für jeden Kunden
														// einen Neuen Wert
														// eingeben lassen.
														// Reihenfolge ist wie
														// in der Tabelle
			}
			sc.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * Für Leute die zu faul sind die ganze Zeit System.out.println(); zu schreiben :D
	 */
	private static void p(String e) {
		System.out.println(e);
	}

}
