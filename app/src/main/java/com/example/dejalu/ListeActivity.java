package com.example.dejalu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import modele.DbAdapter;
import modele.LivredBHelper;

public class ListeActivity extends AppCompatActivity {

    private ListView listView;
    private Intent intentLivre;
    private SimpleCursorAdapter listAdapter;
    static DbAdapter dbAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);
        setWidgets();
        setListeners();
        dbAdapter = new DbAdapter(ListeActivity.this);
        listerLivre();
    }

    private void setWidgets() {
        listView = findViewById(R.id.listView);
        }


    private void listerLivre(){
        Cursor curseur = dbAdapter.listingDetailsLivre();
        String [] cols = {LivredBHelper.COL_TITRE,LivredBHelper.COL_AUTEUR, LivredBHelper.COL_DATELECTURE};
        int [] vBind = new int[] {R.id.txtTitre, R.id.txtAuteur, R.id.txtDate};
        listAdapter = new SimpleCursorAdapter(this, R.layout.list_item, curseur, cols, vBind);
        listView.setAdapter(listAdapter);
    }

    //méthode qui va permettre de se diriger vers la page Détails, avec les informations nécessaires
    private void setListeners() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor cursor = (Cursor) listAdapter.getItem(i);
                String titre = cursor.getString(1);
                String auteur = cursor.getString(2);
                String annee = cursor.getString(3);
                String resume = cursor.getString(4);
                String comment = cursor.getString(5);
                String date = cursor.getString(6);
                intentLivre = new Intent(ListeActivity.this, DetailsActivity.class);
                intentLivre.putExtra("id", l);
                intentLivre.putExtra("titre", titre);
                intentLivre.putExtra("auteur", auteur);
                intentLivre.putExtra("annee", annee);
                intentLivre.putExtra("resume", resume);
                intentLivre.putExtra("comment", comment);
                intentLivre.putExtra("date", date);
                startActivity(intentLivre);
                finish();
            }
        });
    }


}