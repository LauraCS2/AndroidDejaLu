package com.example.dejalu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import modele.DbAdapter;
import modele.Livre;
import modele.LivredBHelper;

public class DetailsActivity extends AppCompatActivity {

    private TextView txtDetailTitre, txtDetailAuteur, txtDetailAnnee, txtDetailResume, txtDetailComment, txtDetailDate;
    private long id;
    Livre livre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setWidgets();
        afficherDetails();
    }

    private void setWidgets() {
        txtDetailTitre = findViewById(R.id.txtDetailTitre);
        txtDetailAuteur = findViewById(R.id.txtDetailAuteur);
        txtDetailAnnee = findViewById(R.id.txtDetailAnnee);
        txtDetailComment = findViewById(R.id.txtDetailComment);
        txtDetailResume = findViewById(R.id.txtDetailResume);
        txtDetailDate = findViewById(R.id.txtDate);
    }

    public void afficherDetails(){
        id = getIntent().getExtras().getLong("id");
        String titre = getIntent().getExtras().getString("titre");
        String auteur = getIntent().getExtras().getString("auteur");
        String annee = getIntent().getExtras().getString("annee");
        String resume = getIntent().getExtras().getString("resume");
        String comment = getIntent().getExtras().getString("comment");
        String date = getIntent().getExtras().getString("date");
        txtDetailTitre.setText(titre);
        txtDetailAuteur.setText(auteur);
        txtDetailAnnee.setText(annee);
        txtDetailResume.setText(resume);
        txtDetailComment.setText(comment);
        txtDetailDate.setText(date);
    }

    //modifier les détails d'un livre
    public void onModifierItem(View view) {
        int annee = Integer.parseInt(txtDetailAnnee.getText().toString());
        Livre livre = new Livre(txtDetailTitre.getText().toString(),txtDetailAuteur.getText().toString(), annee, txtDetailResume.getText().toString(),
                txtDetailComment.getText().toString(), txtDetailDate.getText().toString());
        ListeActivity.dbAdapter.updateLivre(id, livre);
        Toast.makeText(DetailsActivity.this, "Livre modifié!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent (DetailsActivity.this, ListeActivity.class));
        finish();
    }

    //supprimer les détails d'un livre
    public void onSupprimerItem(View view) {
        ListeActivity.dbAdapter.removeItem(id);
        startActivity(new Intent (DetailsActivity.this, ListeActivity.class));
        finish();
    }

    //faire le retour à la liste des livres
    public void onRetourListe(View view){
        startActivity(new Intent (DetailsActivity.this, ListeActivity.class));
        finish();
    }


}