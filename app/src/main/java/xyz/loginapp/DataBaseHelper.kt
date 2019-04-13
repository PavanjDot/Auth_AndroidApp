package xyz.loginapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract
import java.security.AccessControlContext

class DataBaseHelper(context:Context): SQLiteOpenHelper(context, dbname, factory, version) {

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table user (id integer primary key autoincrement," +
        "name varchar(30), email varchar(100), password varchar(20)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertUserData(username: String, Email: String, Password: String){

        val db:SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("name", username)
        values.put("email", Email)
        values.put("password", Password)
        db.insert("user", null, values)
        db.close()

    }

    fun userPresent(login_email: String, login_password: String): Boolean{

        val db = writableDatabase
        val query = "select * from user where email = '$login_email' and password='$login_password'"
        val cursor = db.rawQuery(query, null)
        if(cursor.count<=0){
            cursor.close()
            return false

        }
        cursor.close()
        return true
    }

    companion object {
        internal val dbname="username"
        internal val factory=null
        internal val version = 1
    }
}