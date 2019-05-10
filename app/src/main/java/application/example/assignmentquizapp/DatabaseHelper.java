package application.example.assignmentquizapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="quiz.db";
    public static final String TABLE_ANSWERS ="answer";
    public static final String TABLE_SA="submit";
    public static final String TABLE_COM ="compare";

    // col for answers

    public static final String COL_ANS_1 ="ID";
    public static final String COL_ANS_2 ="ans";
    // col for submitted answers

    public static final String COL_SUBANS_1 ="ID";
    public static final String COL_SUBANS_2 ="sa";
    // col for comparaison

    public static final String COL_COM_1 ="ID";
    public static final String COL_COM_2 ="value";
    public DatabaseHelper(Context context) {
        super (context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" +TABLE_ANSWERS+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, ans TEXT)");
        db.execSQL("CREATE TABLE" +TABLE_SA+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, sa TEXT)");
        db.execSQL("CREATE TABLE" +TABLE_COM+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, value TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL ("DROP TABLE IF EXISTS"+TABLE_ANSWERS);
        db.execSQL ("DROP TABLE IF EXISTS"+TABLE_SA);
        db.execSQL ("DROP TABLE IF EXISTS"+TABLE_COM);

        onCreate ();

    }
}
