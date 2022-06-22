package modele;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DbAdapter {
    private SQLiteDatabase db;
    private LivredBHelper dbHelper;
    private Context context;

    //utilisation du constructeur de LivredBHelper
    public DbAdapter (Context context){
        this.dbHelper = new LivredBHelper(context, LivredBHelper.BD_NOM, null, LivredBHelper.VERSION);
    }

    //méthode pour ouvrir une BD
    public void openBd(){
        db = dbHelper.getWritableDatabase();
    }

    //méthode pour fermer une BD
    public void fermerBd(){
        db.close();
    }

    //méthode pour ajouter un livre
    public void addLivre(Livre livre){
        openBd();
        String titre = livre.getTitre();
        String auteur = livre.getAuteur();
        int annee = livre.getAnnee();
        String resume = livre.getResume();
        String commentaire = livre.getCommentaire();
        String date = livre.getDateLecture();
        ContentValues cv = new ContentValues();
        cv.put(LivredBHelper.COL_TITRE, titre);
        cv.put(LivredBHelper.COL_AUTEUR, auteur);
        cv.put(LivredBHelper.COL_ANNEE, annee);
        cv.put(LivredBHelper.COL_RESUME, resume);
        cv.put(LivredBHelper.COL_COMMENTAIRE, commentaire);
        cv.put(LivredBHelper.COL_DATELECTURE, date);
        db.insert(LivredBHelper.TABLE_1, null, cv);
        fermerBd();
    }

    public Cursor listingDetailsLivre(){
        openBd();
        String[] cols = {LivredBHelper.COL_ID, LivredBHelper.COL_TITRE,LivredBHelper.COL_AUTEUR, LivredBHelper.COL_ANNEE, LivredBHelper.COL_RESUME, LivredBHelper.COL_COMMENTAIRE, LivredBHelper.COL_DATELECTURE};
        Cursor curseur = db.query(LivredBHelper.TABLE_1, cols, null, null, null, null, null, null);
        return curseur;
    }


    public void updateLivre(long id, Livre livre){
        String titre = livre.getTitre();
        String auteur = livre.getAuteur();
        int annee = livre.getAnnee();
        String resume = livre.getResume();
        String commentaire = livre.getCommentaire();
        String date = livre.getDateLecture();
        ContentValues cv = new ContentValues();
        cv.put(LivredBHelper.COL_TITRE, titre);
        cv.put(LivredBHelper.COL_AUTEUR, auteur);
        cv.put(LivredBHelper.COL_ANNEE, annee);
        cv.put(LivredBHelper.COL_RESUME, resume);
        cv.put(LivredBHelper.COL_COMMENTAIRE, commentaire);
        cv.put(LivredBHelper.COL_DATELECTURE, date);
        db.update(LivredBHelper.TABLE_1, cv, LivredBHelper.COL_ID +" =?" , new String[]{String.valueOf(id)});
        fermerBd();
    }

    public void removeItem(long id){
        db.delete(LivredBHelper.TABLE_1, LivredBHelper.COL_ID +" =?", new String[]{String.valueOf(id)});
        fermerBd();
    }
}
