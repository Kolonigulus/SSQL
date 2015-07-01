package mainSSQL.types;

public class SQLType {
	SQLTypesEnum type;
	int maxlenght = 0;
	int floatlength = 0;
	String modifier;

	public SQLType(SQLTypesEnum type) {
		this.type = type;
	}

	public SQLType(SQLTypesEnum type, int maxlength) {
		this.type = type;
		this.maxlenght = maxlength;
	}

	public SQLType(SQLTypesEnum type, int maxlenght, int floatlength) {
		this.type = type;
		this.maxlenght = maxlenght;
		this.floatlength = floatlength;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public SQLTypesEnum getType() {
		return this.type;
	}

	public int getMaxLenght() {
		return this.maxlenght;
	}

	public int getFloalength() {
		return this.floatlength;
	}

	public boolean hasMaxlenght() {
		if (this.maxlenght == 0) {
			return false;
		}
		return true;
	}

	public boolean hasFloatLenght() {
		if (this.floatlength == 0) {
			return false;
		}
		return true;
	}

	public String getModifier() {
		return this.modifier;
	}

	public boolean hasModifier() {
		if (this.modifier == null) {
			return false;
		}
		return true;
	}
}
