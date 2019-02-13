package bw.com.administor.myapplication2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @Auther: 董建茹
 * @Date: 2019/1/18 14:32:37
 * @Description:
 */
public class mySql  extends SQLiteOpenHelper {
    public mySql(Context context) {
        super(context, "bw.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        private  String img;
//        private  String step;

        db.execSQL("create table person(img varchar(20),step varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
