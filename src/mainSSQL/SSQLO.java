/*  1:   */ package mainSSQL;
/*  2:   */ 
/*  3:   */  import java.sql.Connection;
/*  5:   */ import java.sql.DriverManager;
/*  6:   */ import java.sql.SQLException;
/*  7:   */ import java.sql.Statement;
/*  8:   */ import java.util.HashMap;

import mainSSQL.types.SQLTable;
import mainSSQL.types.SQLType;
/* 10:   */ 
/* 11:   */ public class SSQLO
/* 12:   */ {
/* 13:   */   Connection con;
/* 14:   */   private Statement stmt;
/* 15:   */   
/* 16:   */   public SSQLO(String url, String port, String db, String user, String passwd)
/* 17:   */     throws SQLException, ClassNotFoundException
/* 18:   */   {
/* 19:   */     try
/* 20:   */     {
/* 21:43 */       Class.forName("com.mysql.jdbc.Driver");
/* 22:44 */       System.out.println("Treiber werden geladen");
/* 23:   */     }
/* 24:   */     catch (ClassNotFoundException e)
/* 25:   */     {
/* 26:46 */       throw e;
/* 27:   */     }
/* 28:   */     try
/* 29:   */     {
/* 30:50 */       this.con = DriverManager.getConnection("jdbc:mysql://" + url + ":" + 
/* 31:51 */         port + "/" + db + "?" + "user=" + user + "&" + 
/* 32:52 */         "password=" + passwd);
/* 33:53 */       System.out.println("Verbindung wird aufgebaut");
/* 34:54 */       this.stmt = this.con.createStatement();
/* 35:   */     }
/* 36:   */     catch (SQLException e)
/* 37:   */     {
/* 38:56 */       throw e;
/* 39:   */     }
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void close()
/* 43:   */     throws SQLException
/* 44:   */   {
/* 45:   */     try
/* 46:   */     {
/* 47:69 */       this.con.close();
/* 48:   */     }
/* 49:   */     catch (SQLException e)
/* 50:   */     {
/* 51:71 */       throw e;
/* 52:   */     }
/* 53:   */   }
/* 54:   */   
/* 55:   */   public SQLTable CreateTable(HashMap<String, SQLType> Spalten, String name)
/* 56:   */     throws SQLException
/* 57:   */   {
/* 58:95 */     SQLTable table = new SQLTable(this, Spalten, name);
/* 59:96 */     return table;
/* 60:   */   }
/* 61:   */ }

