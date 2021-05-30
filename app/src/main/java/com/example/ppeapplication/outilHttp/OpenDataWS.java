package com.example.ppeapplication.outilHttp;

import android.util.Log;

import com.example.ppeapplication.models.User;
import com.google.gson.Gson;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class OpenDataWS {
    private final static String URLAut = "http://192.168.0.14/android/authentificationUser.php";
    private final static String INSERT ="http://192.168.0.14/android/registeruser.php";
    private static final String URL_Fiche = "http://192.168.0.14/android/hpdSelectOffres.php";
    public static User getAuthUserWS(String email, String mdp) throws Exception {
        String URL = URLAut+"?email="+email+"&mdp="+mdp;
        Log.i("URLA", URL );
        Gson gson = new Gson();
        String reponce = OutilHttp.getHttp(URL );
        Log.i("reponse", reponce) ;
        User user = gson.fromJson(reponce, User.class);
         Log.i("name", user.getDate_deb_sejour()) ;

        return user;
    }

    //task.execute(Email.getText().toString(), password.getText().toString(),
                        //NumeroTel.getText().toString(), NomDeCompte.getText().toString()
                        //,DebutSejour.getText().toString(), FinSejour.getText().toString());

//if( isset($_GET['NumeroTel']) && isset($_GET['password']) && isset($_GET['Email']) && isset($_GET['NomDeCompte']) && isset($_GET['DebutSejour'])&& isset($_GET['FinSejour']));
    public static  String  getInsertFFWS(String Email, String password, String NumeroTel, String NomDeCompte, String DebutSejour,String FinSejour) throws Exception {
        {
        String URL = INSERT+"?Email="+Email+"&password="+password+"&NumeroTel="+NumeroTel+"&NomDeCompte="+NomDeCompte+"&DebutSejour="+DebutSejour+"&FinSejour="+FinSejour;
        Log.i("URLINSERT", URL );
        String reponce = OutilHttp.getHttp(URL );
        Log.i("reponse", reponce) ;
        return reponce;
    }

// http://192.168.0.14/android/registeruser.php?Email=ffgg&password=ddd&NumeroTel=66&NomDeCompte=xxx&DebutSejour=555&FinSejour=22
}

}



