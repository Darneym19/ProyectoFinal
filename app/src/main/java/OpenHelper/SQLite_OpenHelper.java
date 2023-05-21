package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite_OpenHelper extends SQLiteOpenHelper {
    public SQLite_OpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table usuarios(_ID integer primary key autoincrement, user text, password text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void abrir(){
        this.getWritableDatabase();
    }

    public void cerrar(){
        this.close();
    }

    public void insert(String user, String password){
        ContentValues values = new ContentValues();
        values.put("user",user);
        values.put("password",password);
        this.getWritableDatabase().insert("usuarios", null, values);

    }

    public Cursor validation(String user, String password){
        Cursor mcursor = null;
        mcursor = getReadableDatabase().query("usuarios", new String[]{"user","password"},"user like '"+user+"' and password like'"+password+"'",null,null,null,null);
        return mcursor;
    }
}