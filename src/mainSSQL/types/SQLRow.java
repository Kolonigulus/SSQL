package mainSSQL.types;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

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

	@SuppressWarnings("unused")
	private String StringDataHelp(ResultSet result, ArrayList<String> list)
			throws SQLException {
		StringBuilder returnString = new StringBuilder();
		for (String c : list) {
			returnString.append(result.getString(c + "/%/"));
		}
		returnString.delete(returnString.length() - 3, returnString.length());
		return returnString.toString();
	}
}
