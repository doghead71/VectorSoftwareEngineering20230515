package databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

public class DBAdapter {
    SQLiteDatabase _db;
    DatabaseHelper _dbHelper;
    static final  String DATABASE_NAME = "AppDB";
    static final String DATABASE_USER_TABLE = "_user";
    static final int DATABASE_VERSION = 3;
    final Context _context;
    static final String TAG = "DBAdapter";

    public DBAdapter(Context context){
        this._context = context;
        this._dbHelper = new DatabaseHelper(context);
    }

    public void open() {
        _db = _dbHelper.getWritableDatabase();
    }

    public void close(){
        _dbHelper.close();
    }

    public long insertUser(String username,String password, String email){
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        values.put("email", email);

       return _db.insert(DATABASE_USER_TABLE, null, values);
    }

    public boolean deleteUser(String username){
        String whereClause = "username = ?";
        String[] whereArgs = new String []{username};
        int rowsDeleted = _db.delete(DATABASE_USER_TABLE, whereClause, whereArgs);
        return rowsDeleted > 0;
    }

    public boolean updateUser(String username,String password, String email){
        ContentValues values = new ContentValues();
        values.put("password", password);
        values.put("email", email);
        String whereClause = "username = ?";
        String[] whereArgs = new String []{username};
        int rowsUpdated = _db.update(DATABASE_USER_TABLE,values,whereClause,whereArgs);
        return rowsUpdated > 0;
    }

    public Cursor findUser(String username){
        String whereClause = "username = ?";
        String[] whereArgs = new String []{username};
        String [] selectList = new String[] {"username", "password", "email"};

        Cursor cursor = _db.query(DATABASE_USER_TABLE,selectList,whereClause,whereArgs,null,null,null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    //Helper class
    private static class DatabaseHelper extends SQLiteOpenHelper{
        DatabaseHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }

        //How to create database
        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.i(TAG, "Creating database");
            String createSQl = "CREATE TABLE "
                                + DATABASE_USER_TABLE
                                + "(username text primary key"
                                + ",password text not null"
                                + ",email text);";

            try {
                db.execSQL(createSQl);
            }catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        //How to upgrade database
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            String dropSQL = "DROP TABLE if exists " + DATABASE_USER_TABLE;
            db.execSQL(dropSQL);
            onCreate(db);
        }
    }
}
