package mainSSQL.TContent;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import mainSSQL.SQLTable;
import mainSSQL.TContent.fields.SQLField;

/**
 * Repr�sentiert eine Zeile in einer MySQL Tabelle
 * 
 * @author Leonhard
 */
public class SQLRow {
	int ID;
	SQLTable table;

	public SQLRow(int ID, SQLTable table) {
		this.ID = ID;
		this.table = table;
	}

	/**
	 * @return ein String, der alle Werte dieser SQLTabellen-Zeile mit einem
	 *         Komma separiert beinhaltet
	 * @throws SQLException
	 */
	public String DataToString() throws SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM " + this.table.getName());
		sb.append(" WHERE id=" + this.ID);
		ResultSet result = this.table.getStatement()
				.executeQuery(sb.toString());
		ResultSetMetaData meta = result.getMetaData();
		if (result.next()) {
			sb = new StringBuilder();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				sb.append(result.getString(i) + " ");
			}
			return sb.toString();
		}
		return null;
	}

	public SQLTable getTable() {
		return this.table;
	}

	public int getID() {
		return this.ID;
	}

	/**
	 * @return ein Result Set das diese Zeile beinhaltet
	 * @throws SQLException
	 */
	public ResultSet getRowSet() throws SQLException {
		ResultSet set = table.getStatement().executeQuery(
				"SELECT * FROM " + table.getName() + " WHERE ID = " + ID);
		return set;
	}

	private String getValue(String columnLabel) throws SQLException {
		ResultSet set = getRowSet();
		set.next();
		return set.getString(columnLabel);
	}

	public SQLField getField(SQLColumn column) throws SQLException {
		return (new SQLField(this, column));
	}

	public void delete() throws SQLException {
		table.getStatement().executeUpdate(
				"DELETE FROM " + table.getName() + " WHERE ID=" + ID);
	}
}
