/*  1:   */ package mainSSQL.types;
/*  2:   */ 
/*  3:   */ import mainSSQL.SQLTable;
/*  4:   */ 
/*  5:   */ public abstract class SuperSQLType
/*  6:   */ {
/*  7:   */   SQLTable table;
/*  8:   */   String ID;
/*  9:   */   boolean offline;
/* 10:   */   
/* 11:   */   public SuperSQLType(String ID, SQLTable table)
/* 12:   */   {
/* 13:10 */     this.table = table;
/* 14:11 */     this.ID = ID;
/* 15:12 */     this.offline = false;
/* 16:   */   }
/* 17:   */   
/* 18:   */   public String getID()
/* 19:   */   {
/* 20:15 */     return this.ID;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public SQLTable getTable()
/* 24:   */   {
/* 25:18 */     return this.table;
/* 26:   */   }
/* 27:   */ }
