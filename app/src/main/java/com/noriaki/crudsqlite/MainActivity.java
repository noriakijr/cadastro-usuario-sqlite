package com.noriaki.crudsqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText etNome;
    private EditText etLogin;
    private EditText etSenha;
    private Button btSalvar;
    private Usuario usuario = new Usuario();

    public void inicializarComponentes() {
        etNome = (EditText) findViewById(R.id.etNome);
        etLogin = (EditText) findViewById(R.id.etLogin);
        etSenha = (EditText) findViewById(R.id.etSenha);
        btSalvar = (Button) findViewById(R.id.btSalvar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();

        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setNome(etNome.getText().toString());
                usuario.setLogin(etLogin.getText().toString());
                usuario.setSenha(etSenha.getText().toString());
                new UsuarioDao(getApplicationContext()).inserir(usuario);
                Toast.makeText(getApplicationContext(), "Salvo com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
