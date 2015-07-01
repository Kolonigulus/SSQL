/*  1:   */ package mainSSQL.types;
/*  2:   */ 
/*  3:   */ public enum SQLTypesEnum
/*  4:   */ {
/*  5: 4 */   INT,  STRING,  TEXT,  BOOLEAN,  DATE,  TINYTEXT;
/*  6:   */   
/*  7:   */   public static String[] names()
/*  8:   */   {
/*  9: 7 */     SQLTypesEnum[] states = values();
/* 10: 8 */     String[] names = new String[states.length];
/* 11:10 */     for (int i = 0; i < states.length; i++) {
/* 12:11 */       names[i] = states[i].name();
/* 13:   */     }
/* 14:14 */     return names;
/* 15:   */   }
/* 16:   */ }
