/*  1:   */ package mainSSQL.types;
/*  2:   */ 
/*  3:   */ import java.sql.ResultSetMetaData;
/*  4:   */ import java.sql.SQLException;
/*  5:   */ import java.util.HashMap;
/*  6:   */ import java.util.Set;
/*  7:   */ 
/*  8:   */ public class SQLCInformation
/*  9:   */ {
/* 10:   */   ResultSetMetaData metadata;
/* 11:   */   HashMap<String, SQLTypesEnum> columns;
/* 12:   */   
/* 13:   */   public SQLCInformation(ResultSetMetaData metadata)
/* 14:   */     throws SQLException
/* 15:   */   {
/* 16:12 */     this.metadata = metadata;
/* 17:13 */     this.columns = new HashMap();
/* 18:14 */     String[] EnumNames = SQLTypesEnum.names();
/* 19:15 */     for (int i = 0; i < metadata.getColumnCount(); i++) {
/* 20:16 */       for (String c : EnumNames) {
/* 21:17 */         if (c.equalsIgnoreCase(metadata.getColumnName(i))) {
/* 22:18 */           this.columns.put(metadata.getColumnName(i), SQLTypesEnum.valueOf(c));
/* 23:   */         }
/* 24:   */       }
/* 25:   */     }
/* 26:   */   }
/* 27:   */   
/* 28:   */   public String[] getColumns()
/* 29:   */   {
/* 30:24 */     return (String[])this.columns.keySet().toArray(new String[0]);
/* 31:   */   }
/* 32:   */   
/* 33:   */   public SQLTypesEnum getType(String column)
/* 34:   */   {
/* 35:27 */     return (SQLTypesEnum)this.columns.get(column);
/* 36:   */   }
/* 37:   */ }


/* Location:           E:\Leon\Libs\SSQL.jar
 * Qualified Name:     mainSSQL.types.SQLCInformation
 * JD-Core Version:    0.7.0.1
 */