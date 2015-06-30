package mainSSQL.types;

import java.util.Map.Entry;

public class SQLColumn {
	SQLTable table;
	public Entry<String, SQLType> info;

	public SQLColumn(Entry<String, SQLType> info, SQLTable table) {
		this.table = table;
		this.info = info;
	}

	public SQLTable getTable() {
		return this.table;
	}

	public String getName() {
		return this.info.getKey();
	}

	public SQLType getType() {
		return this.info.getValue();
	}
}

