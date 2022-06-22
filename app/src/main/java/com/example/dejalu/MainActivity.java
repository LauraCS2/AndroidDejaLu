package com.example.dejalu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import modele.DbAdapter;

public class MainActivity extends AppCompatActivity {

    private Intent monIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onVoirListe(View view) {
        monIntent = new Intent(MainActivity.this, ListeActivity.class);
        startActivity(monIntent);
    }

    public void onAjouterLivre(View view) {
        monIntent = new Intent(MainActivity.this, AjoutActivity.class);
        startActivityForResult(monIntent, 401);
    }
}