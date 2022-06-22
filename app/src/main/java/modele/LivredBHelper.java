package modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class LivredBHelper extends SQLiteOpenHelper {

    //Déclaration de constantes
    public static final String TABLE_1 = "livre";
    public static final String COL_ID = "_id";
    public static final String COL_TITRE = "titre";
    public static final String COL_AUTEUR = "auteur";
    public static final String COL_ANNEE = "annee";
    public static final String COL_RESUME = "resume";
    public static final String COL_COMMENTAIRE = "commentaire";
    public static final String COL_DATELECTURE = "date";

    public static final String BD_NOM = "dejaLu";
    public static final int VERSION = 1;

    //DDL
    public static final String LIVRE_DDL = "create table " + TABLE_1 + " (" + COL_ID + " integer primary key autoincrement, " +
            COL_TITRE + " TEXT, " +
            COL_AUTEUR + " TEXT, " +
            COL_ANNEE + " INTEGER, " +
            COL_RESUME+ " TEXT, " +
            COL_COMMENTAIRE + " TEXT, " +
            COL_DATELECTURE + " TEXT)";

    //Constructeur

    public LivredBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(LIVRE_DDL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_1 + ";");
        onCreate(sqLiteDatabase);
    }

}
