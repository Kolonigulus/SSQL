package mainSSQL.types;

import java.util.ArrayList;


public class RowContainer extends ArrayList<SQLRow> {


	public RowContainer(SQLRow[] rows){
		super();
		for (SQLRow e : rows) {
			super.add(e);
		}
	}

}
