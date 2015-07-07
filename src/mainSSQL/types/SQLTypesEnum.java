package mainSSQL.types;

public enum SQLTypesEnum {
	INT, FLOAT, DOUBLE, TEXT, BOOLEAN, DATE, TINYTEXT;

	public static String[] names() {
		SQLTypesEnum[] states = values();
		String[] names = new String[states.length];
		for (int i = 0; i < states.length; i++) {
			names[i] = states[i].name();
		}
		return names;
	}
}
