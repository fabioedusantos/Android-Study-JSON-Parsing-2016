package br.fabio.jsonteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView lblUsuario1;
    private TextView lblSenha1;
    private TextView lblUsuario2;
    private TextView lblSenha2;
    private TextView lblUsuario3;
    private TextView lblSenha3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblUsuario1 = (TextView) findViewById(R.id.lbl_usuario_1);
        lblSenha1 = (TextView) findViewById(R.id.lbl_senha_1);
        lblUsuario2 = (TextView) findViewById(R.id.lbl_usuario_2);
        lblSenha2 = (TextView) findViewById(R.id.lbl_senha_2);
        lblUsuario3 = (TextView) findViewById(R.id.lbl_usuario_3);
        lblSenha3 = (TextView) findViewById(R.id.lbl_senha_3);
    }

    public void ler(View v){
        //String com Array JSON validada e funcional
        String json = "[" +
                "    {\"usuario\":\"John\", \"senha\":\"Doe\"}," +
                "    {\"usuario\":\"Anna\", \"senha\":\"Smith\"}," +
                "    {\"usuario\":\"Peter\",\"senha\":\"Jones\"}" +
                "]";

        try {
            //Decodificamos o array Json
            JSONArray jsonArray = new JSONArray(json);

            //Corremos o Array Json
            for(int i = 0; i < jsonArray.length(); i++){
                //Cada linha do Array teremos um JsonObject
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                switch (i){
                    case 0:
                        //Um JsonObject permite pegar as suas informações utilizando getString, getLong...
                        lblUsuario1.setText(jsonObj.getString("usuario"));
                        lblSenha1.setText(jsonObj.getString("senha"));
                        break;
                    case 1:
                        lblUsuario2.setText(jsonObj.getString("usuario"));
                        lblSenha2.setText(jsonObj.getString("senha"));
                        break;
                    case 2:
                        lblUsuario3.setText(jsonObj.getString("usuario"));
                        lblSenha3.setText(jsonObj.getString("senha"));
                        break;
                }
            }

        } catch (final JSONException e){
            Log.d("app", "JSONException: " + e.getMessage());
        }
    }
}
