package com.example.dejalu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import modele.DbAdapter;
import modele.Livre;

public class AjoutActivity extends AppCompatActivity {

    private TextView txtTitre, txtAuteur, txtResume, txtComment, txtAnnee, txtDateAjout;
    private Button btnAjout;
    private Intent recuIntent;
    private DbAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        setWidgets();
        dbAdapter = new DbAdapter(AjoutActivity.this);
    }

    private void setWidgets() {
        txtAuteur = findViewById(R.id.txtAuteur);
        txtAnnee = findViewById(R.id.txtAnnee);
        txtTitre = findViewById(R.id.txtTitre);
        txtComment = findViewById(R.id.txtComment);
        txtDateAjout = findViewById(R.id.txtDateAjout);
        txtResume = findViewById(R.id.txtResume);
        btnAjout = findViewById(R.id.btnAjout);
    }

    public void onAjouter(View view) {
        int annee = Integer.parseInt(txtAnnee.getText().toString());
        Livre livre = new Livre(txtTitre.getText().toString(),txtAuteur.getText().toString(), annee, txtResume.getText().toString(), txtComment.getText().toString(), txtDateAjout.getText().toString());
        dbAdapter.addLivre(livre);
        Toast.makeText(AjoutActivity.this, "Livre ajouté!", Toast.LENGTH_LONG).show();
        clearFields();
    }

    private void clearFields() {
        txtResume.setText("");
        txtTitre.setText("");
        txtAuteur.setText("");
        txtAnnee.setText("");
        txtDateAjout.setText("");
        txtComment.setText("");
    }


}