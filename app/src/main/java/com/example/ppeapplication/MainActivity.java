package com.example.ppeapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.ppeapplication.models.User;
import com.example.ppeapplication.outilHttp.OpenDataWS;
import com.example.ppeapplication.outilHttp.OutilHttp;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText email ;
    private EditText password ;
    private Button connect ;
    private Button inscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        email = findViewById(R.id.editTextEmailAddress_main);
        password = findViewById(R.id.editTextPassword_main);
        connect = findViewById(R.id.button_connecter_main);
        inscription = findViewById(R.id.button_inscription_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonAstask task = new MonAstask();
                // execute c'est une fonction qui permet de lancer le thread
                task.execute(email.getText().toString(), password.getText().toString());

            }

        });
        inscription.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
    }



    /*  public   void connect(View v){
               // tasck c'est une instance de la classse MonAstask
              MonAstask task = new MonAstask();
              // execute c'est une fonction qui permet de lancer le thread
              task.execute(email.getText().toString(), password.getText().toString());

            }*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public class MonAstask extends AsyncTask<String,String,User> {
        User user = null;
        @Override
        protected User doInBackground(String ... params) {
            try {
                //Log.i(" url :" , "http://192.168.0.39/android/authentificationUser.php?email="+params[0]+"&mdp="+params[1]);
                user = OpenDataWS.getAuthUserWS(params[0],params[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }
        @Override
        protected void onPostExecute(User user) {
            super.onPostExecute(user);
            //Message d'erreur pour le connect
            if(user == null) {
                Log.i(" resultat :", "email et le mot de passe non valide");
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(MainActivity.this);
                dlgAlert.setMessage("Email ou mot de passe non valide");
                dlgAlert.setTitle("Erreur");
                dlgAlert.setPositiveButton("OK", null);
                dlgAlert.setCancelable(true);
                dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Click sur le boutton OK", Toast.LENGTH_SHORT).show();
                    }
                });
                dlgAlert.create().show();
            }else{
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                intent.putExtra("KEY",user);
                Log.i("ok",user.getDate_deb_sejour());
                startActivity(intent);
            }

        }

        }
    }// fin MonAstask




