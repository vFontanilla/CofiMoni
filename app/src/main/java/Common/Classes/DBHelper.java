package Common.Classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "COFIMONI.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        //code
        DB.execSQL("CREATE TABLE USER_MASTER (" +
                "M_ID INTEGER NOT NULL, " +
                "M_USERNAME TEXT NOT NULL, " +
                "M_PASSWORD NUMERIC NOT NULL, " +
                "M_CREATEDATETIME TEXT NOT NULL, " +
                "PRIMARY KEY(M_ID));");

        DB.execSQL("CREATE TABLE M_CATEGORY (" +
                "CAT_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "CAT_CODE TEXT NOT NULL, " +
                "CAT_CATEGORY TEXT NOT NULL, " +
                "CAT_CREATEDATETIME TEXT NOT NULL);");

        DB.execSQL("CREATE TABLE M_MENU (" +
                "MEN_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "MEN_CODE TEXT NOT NULL, " +
                "MEN_ITEMNAME TEXT NOT NULL, " +
                "MEN_PRICE REAL NOT NULL);");

        DB.execSQL("CREATE TABLE T_ORDERS (" +
                "ORD_ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "ORD_ITEMNAME TEXT NOT NULL, " +
                "ORD_CODE TEXT NOT NULL, " +
                "ORD_QTY INTEGER NOT NULL, " +
                "ORD_TOTALAMT REAL NOT NULL, " +
                "ORD_LocalFlag INTEGER DEFAULT 0, " +
                "ORD_CREATEDATETIME TEXT NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {

        //code
        DB.execSQL("drop Table if exists USER_MASTER");
        DB.execSQL("drop Table if exists M_CATEGORY");
        DB.execSQL("drop Table if exists M_MENU");
        DB.execSQL("drop Table if exists T_ORDERS");
        onCreate(DB);
    }

    public boolean insert_T_ORDERS (String ORD_ITEMNAME, String ORD_CODE, int ORD_QTY, double ORD_TOTALAMT, String ORD_CREATEDATETIME){
        //code
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ORD_ITEMNAME", ORD_ITEMNAME);
        contentValues.put("ORD_CODE", ORD_CODE);
        contentValues.put("ORD_QTY", ORD_QTY);
        contentValues.put("ORD_TOTALAMT", ORD_TOTALAMT);
        contentValues.put("ORD_CREATEDATETIME", ORD_CREATEDATETIME);
        long result = DB.insert("T_ORDERS", null, contentValues);
        if(result==-1){
            return  false;
        } else {
            return true;
        }
    }

    public boolean insert_M_CATEGORY (String CAT_CODE, String CAT_CATEGORY, String CAT_CREATEDATETIME){
        //code
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("CAT_CODE", CAT_CODE);
        contentValues.put("CAT_CATEGORY", CAT_CATEGORY);
        contentValues.put("CAT_CREATEDATETIME", CAT_CREATEDATETIME);
        long result = DB.insert("M_CATEGORY", null, contentValues);
        if(result==-1){
            return  false;
        } else {
            return true;
        }
    }

    public boolean insert_M_MENU_CB(String MEN_CODE,String MEN_ITEMNAME, double MEN_PRICE) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MEN_CODE", MEN_CODE);
        contentValues.put("MEN_ITEMNAME", MEN_ITEMNAME);
        contentValues.put("MEN_PRICE", MEN_PRICE);
        long result = DB.insert("M_MENU", null, contentValues);
        if(result==-1){
            return  false;
        } else {
            return true;
        }
    }

    public boolean insert_USER_MASTER (String M_USERNAME, String M_PASSWORD, String M_CREATEDATETIME){
        //code
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("M_USERNAME", M_USERNAME);
        contentValues.put("M_PASSWORD", M_PASSWORD);
        contentValues.put("M_CREATEDATETIME", M_CREATEDATETIME);
        long result = DB.insert("USER_MASTER", null, contentValues);
        if(result==-1){
            return  false;
        } else {
            return true;
        }
    }

    public Cursor EQuery(String query) {
        SQLiteDatabase DB = this.getWritableDatabase();
        String Query = query;
        Cursor cursor = DB.rawQuery(Query, null);
        return cursor;
    }
}





























































