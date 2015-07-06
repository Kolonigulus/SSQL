package mainSSQL.TContent.fields;

import java.sql.ResultSet;
import java.sql.SQLException;

import mainSSQL.TContent.SQLColumn;
import mainSSQL.TContent.SQLRow;

public class SQLField {
	SQLRow row;
	ResultSet set;
	SQLColumn column;

	public SQLField(SQLRow row, SQLColumn column) throws SQLException {
		this.row = row;
		this.column = column;
		set = row.getRowSet();

	}

	public SQLRow getRow() {
		return row;
	}

	public SQLColumn getColumn() {
		return column;
	}

	public SQLValue getValue() {
		return (new SQLValue(this));
	}

	protected ResultSet getSet() {
		return set;
	}

	public void setValue(SQLValue value) throws SQLException {
		row.getTable()
				.getStatement()
				.executeUpdate(
						"UPDATE " + row.getTable().getName() + " SET "
								+ column.getName() + "='"
								+ value.getRawObjekt() + "' WHERE ID ="
								+ row.getID());
	}
}
