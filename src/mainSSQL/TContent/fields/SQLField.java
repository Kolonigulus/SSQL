package mainSSQL.TContent.fields;

import java.sql.ResultSet;
import java.sql.SQLException;

import mainSSQL.TContent.SQLColumn;
import mainSSQL.TContent.SQLRow;

/**
 * @author Leonhard
 * Diese Klasse repräsentiert ein Feld aus einer MySQLTabelle
 */
public class SQLField {
	SQLRow row;
	ResultSet set;
	SQLColumn column;

	/**
	 * @param row 
	 * @param column
	 * @throws SQLException
	 */
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

	/**
	 * @return {@linkplain mainSSQL.TContent.fields.SQLValue}
	 */
	public SQLValue getValue() {
		return (new SQLValue(this));
	}

	protected ResultSet getSet() {
		return set;
	}

	/** Setzt den Wert dieses Feldes auf "value"
	 * @param value Ein SQLValue Objekt mit dem 
	 * @throws SQLException
	 */
	public void setValue(SQLValue value) throws SQLException {
		row.getTable()
				.getStatement()
				.executeUpdate(
						"UPDATE " + row.getTable().getName() + " SET "
								+ column.getName() + "='"
								+ value.getValueFromObject() + "' WHERE ID ="
								+ row.getID());
	}
}
