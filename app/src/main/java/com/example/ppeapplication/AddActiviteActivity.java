package com.example.ppeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.AsyncTask;

import com.example.ppeapplication.outilHttp.OpenDataWS;

public class AddActiviteActivity extends AppCompatActivity {
    private EditText HeureRdv;
    private EditText DateRDV;
    private EditText DateFinRDV;
    private EditText prixactivite;
    private EditText nomResponsable;
    private EditText prenomResponsable;
    private EditText nomActivite;
    private EditText descriptionactivite;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activite);
        // On instancie les fields.
        HeureRdv =  findViewById(R.id.heure_rdv);
        DateRDV = findViewById(R.id.DateRdv);
        DateFinRDV = findViewById(R.id.DateFinRdv);
        prixactivite = findViewById(R.id.prix_activite);
        nomResponsable = findViewById(R.id.prenom_responsable);
        prenomResponsable = findViewById(R.id.nom_activite);
        nomActivite = findViewById(R.id.description_activite);
        descriptionactivite = findViewById(R.id.description_activite);
        Button buttonAddActivite = findViewById(R.id.button_add_activite);

        buttonAddActivite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddActiviteActivity.MonAstask task = new AddActiviteActivity.MonAstask();
                // execute c'est une fonction qui permet de lancer le thread
                task.execute(HeureRdv.getText().toString(), DateRDV.getText().toString(),
                        DateFinRDV.getText().toString(), prixactivite.getText().toString()
                        ,nomResponsable.getText().toString(), prenomResponsable.getText().toString()
                        ,nomActivite.getText().toString(),descriptionactivite.getText().toString());
            }
        });
    }
    public class MonAstask extends AsyncTask<String,String, String> {
        String resultat = null ;
        String text;
        @Override
        protected String doInBackground(String...params) {
            try {
                Log.i("FF", params[0]);
                resultat = OpenDataWS.getInsertFFWS(params[0],params[1],params[2],params[3],params[4],params[5]);

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultat;
        }
        @Override
        protected void onProgressUpdate(String...values) {
            super.onProgressUpdate(values);


        }
        @Override
        protected void onPostExecute(String o) {
            super.onPostExecute(o);
            String info = o ;


            if(info.contains("true")) {

                Log.i("insert", "ok");

            }
        }
        public void register(View view) {
            // task est une instance de la classe MainActivity
            AddActiviteActivity.MonAstask task = new AddActiviteActivity.MonAstask();
            // execute une fonction qui permet de lancer le thread
            task.execute(HeureRdv.getText().toString(), DateRDV.getText().toString(), DateFinRDV.getText().toString(), prixactivite.getText().toString(), nomResponsable.getText().toString(), prenomResponsable.getText().toString(), nomActivite.getText().toString(), descriptionactivite.getText().toString());
        }
}
}