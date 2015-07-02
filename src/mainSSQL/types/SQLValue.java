package mainSSQL.types;

public class SQLValue {
	Object o;

	public SQLValue(Object o) {
		this.o = o;
	}

	public Class<?> getType() {
		return o.getClass();
	}

	public Integer getInteger() {
		return (Integer) o;
	}

	public String getString() {
		return (String) o;

	}
	
}
