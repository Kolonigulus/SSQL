/*  1:   */ package mainSSQL.types;
/*  2:   */ 
/*  3:   */ public class SQLType
/*  4:   */ {
/*  5:   */   SQLTypesEnum type;
/*  6: 5 */   int maxlenght = 0;
/*  7: 6 */   int floatlength = 0;
/*  8:   */   String modifier;
/*  9:   */   
/* 10:   */   public SQLType(SQLTypesEnum type)
/* 11:   */   {
/* 12: 9 */     this.type = type;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public SQLType(SQLTypesEnum type, int maxlength)
/* 16:   */   {
/* 17:12 */     this.type = type;
/* 18:13 */     this.maxlenght = maxlength;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public SQLType(SQLTypesEnum type, int maxlenght, int floatlength)
/* 22:   */   {
/* 23:16 */     this.type = type;
/* 24:17 */     this.maxlenght = maxlenght;
/* 25:18 */     this.floatlength = floatlength;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public void setModifier(String modifier)
/* 29:   */   {
/* 30:21 */     this.modifier = modifier;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public SQLTypesEnum getType()
/* 34:   */   {
/* 35:24 */     return this.type;
/* 36:   */   }
/* 37:   */   
/* 38:   */   public int getMaxLenght()
/* 39:   */   {
/* 40:27 */     return this.maxlenght;
/* 41:   */   }
/* 42:   */   
/* 43:   */   public int getFloalength()
/* 44:   */   {
/* 45:30 */     return this.floatlength;
/* 46:   */   }
/* 47:   */   
/* 48:   */   public boolean hasMaxlenght()
/* 49:   */   {
/* 50:33 */     if (this.maxlenght == 0) {
/* 51:34 */       return false;
/* 52:   */     }
/* 53:36 */     return true;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public boolean hasFloatLenght()
/* 57:   */   {
/* 58:39 */     if (this.floatlength == 0) {
/* 59:40 */       return false;
/* 60:   */     }
/* 61:42 */     return true;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public String getModifier()
/* 65:   */   {
/* 66:45 */     return this.modifier;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public boolean hasModifier()
/* 70:   */   {
/* 71:48 */     if (this.modifier == null) {
/* 72:49 */       return false;
/* 73:   */     }
/* 74:51 */     return true;
/* 75:   */   }
/* 76:   */ }


