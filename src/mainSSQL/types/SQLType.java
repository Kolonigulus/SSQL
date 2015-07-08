package mainSSQL.types;

/**
 * Diese Klasse repr�sentiert einen SQLTyp
 * 
 * @author Leonhard
 */
public class SQLType {
	SQLTypesEnum type;
	int maxlenght = 0;
	int floatlength = 0;
	String modifier;

	/**
	 * Standart Konstruktor, mei�tens in Kombination mit dem SQLTypesEnum TEXT,
	 * TINYTEXT
	 * 
	 * @param type
	 */
	public SQLType(SQLTypesEnum type) {
		this.type = type;
	}

	/**
	 * �hnlich wie die anderen Konstruktoren, gibt nur eine maximale L�nge f�r
	 * den Wert an, mei�tens in Kombination mit INT, FLOAT, DOUBLE NICHT
	 * verwenden bei TEXT, TYNITEXT, etc......
	 * 
	 * @param type
	 * @param maxlength
	 *            die Maximale Anzahl der Zeichen
	 */
	public SQLType(SQLTypesEnum type, int maxlength) {
		this.type = type;
		this.maxlenght = maxlength;
	}

	/**
	 * �hnlich wie SQLType(SQLTypesEnum typem, int maxlength) aber gibt die
	 * maximale L�nge der Nachkommastellen an (nur NUR mit FLOAT und DOUBLE
	 * verwenden!!!!
	 * 
	 * @param type
	 * @param maxlenght
	 *            die maximale Anzahl der Zeichen
	 * @param floatlength
	 *            Die Anzahl der Nachkomma Stellen
	 */
	public SQLType(SQLTypesEnum type, int maxlenght, int floatlength) {
		this.type = type;
		this.maxlenght = maxlenght;
		this.floatlength = floatlength;
	}

	/**
	 * ein zus�tzlicher Modifier, der bei der Erstellung des CREATE TABLE
	 * updates hinter oben genannte Typen gestellt wird
	 * 
	 * @param modifier
	 */
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
