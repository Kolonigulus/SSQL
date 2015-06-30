package mainSSQL.types;

import java.util.Map;

public class SQLColumn {
	SQLTable table;
	public Map.Entry<String, SQLType> info;

	public SQLColumn(Map.Entry<String, SQLType> info, SQLTable table) {
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

