package mainSSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import mainSSQL.TContent.SQLColumn;
import mainSSQL.TContent.SQLRow;
import mainSSQL.types.SQLType;

public class SQLTable {

	String name;
	SSQLO SQL;
	Connection con;
	Statement stmt;
	HashMap<String, SQLType> Spalten;
	String[] SpaltenNamen;
	SQLColumn[] Columns;

	/**
	 * Sollte eigentlich nur von dem SSQLO Objekt aufgerufen werden, trotzdem
	 * möglich
	 * 
	 * @param SQLer
	 * @param Spalten
	 * @param name
	 * @throws SQLException
	 */
	public SQLTable(SSQLO SQLer, HashMap<String, SQLType> Spalten, String name)
			throws SQLException {

		this.Spalten = Spalten;
		SQL = SQLer;
		this.name = name;
		this.con = this.SQL.getConnection();
		this.stmt = this.con.createStatement();
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE IF NOT EXISTS " + name + "(");
		sb.append("id INT NOT NULL AUTO_INCREMENT, ");
		for (Entry<String, SQLType> c : Spalten.entrySet()) {
			sb.append(c.getKey() + " " + (c.getValue()).getType().name());
			if ((c.getValue()).hasMaxlenght()) {
				sb.append("(" + (c.getValue()).getMaxLenght());
				if ((c.getValue()).hasFloatLenght()) {
					sb.append("," + ((c.getValue()).getFloalength()));
				}
				sb.append(")");
			}
			if ((c.getValue()).hasModifier()) {
				sb.append((c.getValue()).getModifier());
			}
			sb.append(", ");
		}
		sb.append("PRIMARY KEY (id));");
		System.out.println(sb.toString());
		this.stmt.executeUpdate(sb.toString());
		ArrayList<String> SpaltenNamentemp = new ArrayList<String>();
		for (Entry<String, SQLType> c : Spalten.entrySet()) {
			SpaltenNamentemp.add(c.getKey());
		}
		this.SpaltenNamen = SpaltenNamentemp.toArray(new String[1]);
	}

	/**
	 * Mit dieser Methoden können Daten (nur in String-Form) in die Tabelle in
	 * eine neue Spalte eingefügt werden
	 * 
	 * @param daten
	 *            die Daten. Das die Daten müssen die gleiche Reihenfolge haben
	 *            wie die dazugehörigen SQLColumns
	 * @param columns
	 *            Die Spalten in die "daten" eingeben werden soll. Wenn eine
	 *            Spalte ausgelassen wird, wird der Wert "null" eingefügt,
	 *            sofern kein anderer Standart Wert gesetzt wurde. Als Vorlage
	 *            kann {@linkplain SQLTable.getColumns} dienen
	 * @throws SQLException
	 */
	public void putData(String[] daten, SQLColumn[] columns)
			throws SQLException {
		ArrayList<String> l = new ArrayList<String>();
		for (SQLColumn e : columns) {
			l.add(e.getName());
		}
		String[] spalten = l.toArray(new String[0]);
		String temp = "INSERT INTO " + this.name + " ("
				+ Arrays.toString(spalten).replace("[", "").replace("]", "")
				+ ") " + " VALUES ( "
				+ Arrays.toString(daten).replace("[", "").replace("]", "");

		temp = temp + " );";
		System.out.println(temp);
		this.stmt.executeUpdate(temp);
	}

	/**
	 * @param ID
	 * @return Ein SQLRow-Objekt das die Zeile mit der ID des int "ID"
	 *         repräsentiert
	 */
	public SQLRow getRow(int ID) {
		return new SQLRow(ID, this);
	}

	public SQLColumn getColumn(String name) {
		Entry<String, SQLType> entry = null;
		for (Entry<String, SQLType> c : this.Spalten.entrySet()) {
			if (c.getKey().equals(name)) {
				entry = c;
				break;
			}
		}
		return new SQLColumn(entry, this);
	}

	/**
	 * löscht diese Tabelle aus der Datenbank. Diese Aktion kann nicht wieder
	 * rückgängig gemacht werden!
	 * 
	 * @throws SQLException
	 */
	public void delTable() throws SQLException {
		this.stmt.executeUpdate("DROP TABLE " + this.name);
	}

	public Statement getStatement() throws SQLException {
		return this.con.createStatement();
	}

	/**
	 * @return Die HashMap<String, SQLType> die bei
	 *         {@linkplain SSQLO.CreateTable} verwendet wurde
	 */
	public HashMap<String, SQLType> getHeader() {
		return this.Spalten;
	}

	public String getName() {
		return this.name;
	}

	public String getData(String id, String column) throws SQLException {
		ResultSet result = getStatement().executeQuery(
				"SELECT " + column + "FROM" + this.name + "WHERE id=" + id);
		return result.getString(column);
	}

	/**
	 * @param column
	 * @param value
	 * @return Ein Row Container der alle SQLRows beinhaltet auf die der Wert
	 *         "value" in der Spalte "column" zutrifft
	 * @throws SQLException
	 */
	public RowContainer getRowsByValue(SQLColumn column, String value)
			throws SQLException {
		ResultSet set = getStatement().executeQuery(
				"SELECT * FROM " + getName() + " WHERE " + column.getName()
						+ "='" + value + "'");
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (set.next()) {
			list.add(set.getInt("ID"));

		}
		ArrayList<SQLRow> alsolist = new ArrayList<SQLRow>();
		for (Integer e : list) {
			alsolist.add(getRow(e.intValue()));
		}
		return (new RowContainer(alsolist.toArray(new SQLRow[0])));
	}

	public SQLColumn[] getColumns() {
		return Columns;
	}
}
