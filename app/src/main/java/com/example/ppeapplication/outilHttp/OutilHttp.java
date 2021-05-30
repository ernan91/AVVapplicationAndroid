package com.example.ppeapplication.outilHttp;

import java.net.HttpURLConnection;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class OutilHttp {
    public static String getHttp(String url) throws Exception {
// Première étape, instancier un OkHttpClient
        OkHttpClient client = new OkHttpClient();
// Construire ensuite sa requête GET

        Request request = new Request.Builder()

                .url(url)
                .build();
// Exécuter la requête
        Response response = client.newCall(request).execute();
        if (response.code() != HttpURLConnection.HTTP_OK)
        {
            throw new Exception(" Response du serveur incorrecte"+response.code() );
        }else
// retourne le corps de la réponse sous format String
            return response.body().string();
    }
}
