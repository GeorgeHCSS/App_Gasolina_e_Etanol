package devandroid.george.appgasolinaetanol.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GasEtaDB extends SQLiteOpenHelper {
    public static final String DB_NAME ="gaseta.db";
    public static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    String sqlTabelaCombustivel
            = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "gasolina REAL, " +
            "etanol REAL, " +
            "resultado TEXT)";

     db.execSQL(sqlTabelaCombustivel);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
