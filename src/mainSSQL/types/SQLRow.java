package mainSSQL.types;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import mainSSQL.SQLTable;

public class SQLRow {
	int ID;
	SQLTable table;

	public SQLRow(int ID, SQLTable table) {
		this.ID = ID;
		this.table = table;
	}

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
				sb.append(result.getString(i));
				System.out.println(result.getString(i));
			}
			System.out.println(sb.toString());
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

	public ResultSet getRowSet() throws SQLException{
		ResultSet set = table.getStatement().executeQuery("SELECT * FROM " + table.getName() + " WHERE ID = " + ID);
		return set;
	}

	public String getValue(String columnLabel) throws SQLException {
		ResultSet set = getRowSet();
		set.next();
		return set.getString(columnLabel);
	}
}
