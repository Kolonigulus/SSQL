package mainSSQL.TContent.fields;

import java.sql.SQLException;


public class SQLValue {
	private SQLField f;

	public SQLValue(SQLField f) {
		this.f = f;
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
	public Object getRawObjekt() throws SQLException{
		return f.getSet().getObject(f.getColumn().getName());
	}
	
}
