package com.example.testesono;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.testesono.database.DadosOpenHelper;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layoutContentMain;
    private SQLiteDatabase conexao;
    private DadosOpenHelper dadosOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        layoutContentMain = (ConstraintLayout)findViewById(R.id.layoutContentMain);
        criarConexao();
    }

    private void criarConexao(){
        try{

            dadosOpenHelper = new DadosOpenHelper(this);
            conexao = dadosOpenHelper.getWritableDatabase();
            Snackbar.make(layoutContentMain, "Conexão com SQLite criada com sucesso!", Snackbar.LENGTH_SHORT).setAction("OK",null).show();

        }catch (SQLException ex){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setTitle("Erro");
            dlg.setMessage(ex.getMessage());
            dlg.setNeutralButton("OK",null);
            dlg.show();

        }
    }

    public void btnJogarOnClick(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void btnSobreTeste(View view) {
        Intent intent = new Intent(this, SobreActivity.class);
        startActivity(intent);
    }
}