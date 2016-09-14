package br.fabio.jsonteste;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        String json = "[" +
                "    {\"usuario\":\"John\", \"senha\":\"Doe\"}," +
                "    {\"usuario\":\"Anna\", \"senha\":\"Smith\"}," +
                "    {\"usuario\":\"Peter\",\"senha\":\"Jones\"}" +
                "]";
    }
}
