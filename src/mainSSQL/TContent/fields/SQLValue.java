package mainSSQL.TContent.fields;

import java.sql.SQLException;

/**
 * Alle Getter dieser Methode funktionieren nur wenn in der MySQL Tabelle der
 * Wert auch von dem entsprechenden Typ ist.
 * 
 * @author Leonhard
 */
public class SQLValue {
	private SQLField f;
	private Object value;

	public SQLValue(SQLField f) {
		this.f = f;
	}

	/**
	 * Wenn dieser Konstruktor verwendet wird um eine Instanz dieser Klasse zu
	 * erzeugen werfen alle Methoden NullPointer Exceptions!
	 * 
	 * @param o
	 */
	public SQLValue(Object o) {
		this.value = o;
	}

	public Class<?> getType() throws SQLException {
		return f.getSet().getObject(f.getColumn().getName()).getClass();
	}

	public Integer getInteger() throws SQLException {
		return f.getSet().getInt(f.getColumn().getName());
	}

	public String getString() throws SQLException {
		return f.getSet().getString(f.getColumn().getName());

	}

	public Float getFloat() throws SQLException {
		return f.getSet().getFloat(f.getColumn().getName());
	}

	public Object getRawObjekt() throws SQLException {
		return f.getSet().getObject(f.getColumn().getName());
	}

	protected Object getValueFromObject() {
		return value;
	}

}
