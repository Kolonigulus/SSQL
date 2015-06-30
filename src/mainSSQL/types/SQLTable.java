package mainSSQL.types;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import mainSSQL.SSQLO;

public class SQLTable {

	String name;
	SSQLO SQL;
	Connection con;
	Statement stmt;
	HashMap<String, SQLType> Spalten;
	String[] SpaltenNamen;

	public SQLTable(SSQLO SQLer, HashMap<String, SQLType> Spalten, String name)
			throws SQLException {

		this.Spalten = Spalten;
		SQL = SQLer;
		this.name = name;
		this.con = this.SQL.con;
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

	public void putData(String[] daten, String[] spalten) throws SQLException {
		String temp = "INSERT INTO " + this.name + " ("
				+ Arrays.toString(spalten).replace("[", "").replace("]", "")
				+ ") " + " VALUES ( "
				+ Arrays.toString(daten).replace("[", "").replace("]", "");

		temp = temp + " );";
		System.out.println(temp);
		this.stmt.executeUpdate(temp);
	}

	public SQLRow getRow(int ID) {
		return new SQLRow(ID, this);
	}

	public SQLColumn getColumn(String name) {
		Map.Entry<String, SQLType> entry = null;
		for (Entry<String, SQLType> c : this.Spalten.entrySet()) {
			if (c.getKey().equals(name)) {
				entry = c;
				break;
			}
		}
		return new SQLColumn(entry, this);
	}

	public void delTable() throws SQLException {
		this.stmt.executeUpdate("DROP TABLE " + this.name);
	}

	public Statement getStatement() throws SQLException {
		return this.con.createStatement();
	}

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

	public RowContainer getRowsByValue(SQLColumn column, String value)
			throws SQLException {
		ResultSet set = getStatement().executeQuery(
				"SELECT * FROM " + getName() + " WHERE " + column.getName()
						+ "='" + value + "'");
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(set.next()){
			list.add(set.getInt("ID"));
			
		}
		ArrayList<SQLRow> alsolist = new ArrayList<SQLRow>();
		for(Integer e : list){
			alsolist.add(getRow(e.intValue()));
		}
		return (new RowContainer(alsolist.toArray(new SQLRow[0])));
	}
}
