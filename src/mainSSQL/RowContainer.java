package mainSSQL;

import java.sql.SQLException;
import java.util.ArrayList;

import mainSSQL.TContent.SQLColumn;
import mainSSQL.TContent.SQLRow;

/**
 * Beinhaltet alle Ergebnisse von SQLTable.getByValue und RowContainer.select
 * Kann wie eine ArrayList verwendet und modifiziert werden!
 * 
 * @author Leonhard
 *
 */
@SuppressWarnings("serial")
public class RowContainer extends ArrayList<SQLRow> {

	public RowContainer(SQLRow[] rows) {
		super();
		for (SQLRow e : rows) {
			super.add(e);
		}
	}

	/**
	 * @param column
	 * @param value
	 * @return Ähmlich wie {@linkplain mainSSQL.SQLTable.getRowsByValue}
	 * @throws SQLException
	 */
	public RowContainer select(SQLColumn column, String value)
			throws SQLException {
		ArrayList<SQLRow> newContainer = new ArrayList<SQLRow>();
		for (SQLRow e : this) {
			if (e.getRowSet().getString(column.getName()).equals(value)) {
				newContainer.add(e);
			}

		}
		return (new RowContainer(newContainer.toArray(new SQLRow[0])));
	}

}
