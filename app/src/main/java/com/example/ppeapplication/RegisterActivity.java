package com.example.ppeapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ppeapplication.outilHttp.OpenDataWS;


public class RegisterActivity extends AppCompatActivity {
     private EditText NomDeCompte;
     private EditText password;
     private EditText Email;
     private EditText NumeroTel;
     private EditText FinSejour;
     private EditText DebutSejour;
     private Button button_inscription;
    @Override
    // Le mot-clé @override est utilisé pour définir une méthode qui est héritée de la classe parente.
    // On ne l'utilise donc que dans le cas de l'héritage. En plaçant ce mot-clé dans le commentaire de la méthode réécrite,
    // le compilateur vérifiera que la méthode est correctement utilisée (mêmes arguments, même type de valeur de retour)
    // et affichera un message d'avertissement si ce n'est pas le cas.
    //Ecrire ce commentaire permet également au développeur d'avoir une meilleure lisibilité du code.
    // Depuis la version 1.6 de Java, le mot-clé @override est également utilisé pour une méthode qui
    // implémente une interface. Le compilateur affichera également un avertissement si le prototype de la
    // méthode originale n'est pas respecté.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        NumeroTel = findViewById(R.id.NumeroTel_register);
        password = findViewById(R.id.password_register);
        Email = findViewById(R.id.Email_register);
        NomDeCompte = findViewById(R.id.editTextTextPersonName2_register);
        DebutSejour = findViewById(R.id.DebutSejour_register);
        FinSejour = findViewById(R.id.FinSejour_register);
        button_inscription = findViewById(R.id.button_register);

        button_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterActivity.MonAstask task = new RegisterActivity.MonAstask();
                 //execute c'est une fonction qui permet de lancer le thread
                task.execute(Email.getText().toString(), password.getText().toString(),
                        NumeroTel.getText().toString(), NomDeCompte.getText().toString()
                        ,DebutSejour.getText().toString(), FinSejour.getText().toString());

                Log.i("date",FinSejour.getText().toString());
            }
        });


    }


    public class MonAstask extends AsyncTask<String,String, String> {

        String text;
        @Override
        protected String doInBackground(String...params) {
            String resultat = " ok" ;
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


           // if(info.contains("true")) {

                Log.i("insert", info);

            //}
        }


    }

    public void register(View view) {
        // task est une instance de la classe MainActivity
        MonAstask task = new MonAstask();
        // execute une fonction qui permet de lancer le thread
        task.execute(FinSejour.getText().toString(), NomDeCompte.getText().toString(), NumeroTel.getText().toString(), Email.getText().toString(), password.getText().toString(), DebutSejour.getText().toString());
    }

}