package com.example.testesono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        getSupportActionBar().hide();

        TextView resultado = (TextView) findViewById(R.id.resultado);
        TextView avaliacao = (TextView) findViewById(R.id.avaliacao);
        ImageView imgResultado = (ImageView)findViewById(R.id.imgResultado);



        Intent intent = getIntent();
        int pontos = intent.getIntExtra("resultado", 0);
        if(pontos<=6){
            resultado.setText("Resultado: " + pontos);
            avaliacao.setText("Não apresenta sonolência");
            imgResultado.setImageResource(R.drawable.resultado1);
        }else if(pontos>6 && pontos <=10){
            resultado.setText("Resultado: " + pontos);
            avaliacao.setText("Pode apresentar sonolência");
            imgResultado.setImageResource(R.drawable.resultado2);
        }else if(pontos>10 && pontos <=14){
            resultado.setText("Resultado: " + pontos);
            avaliacao.setText("Sonolência Leve");
            imgResultado.setImageResource(R.drawable.resultado3);
        }else if(pontos>14 && pontos <=19){
            resultado.setText("Resultado: " + pontos);
            avaliacao.setText("Sonolência Moderada");
            imgResultado.setImageResource(R.drawable.resultado4);
        }else {
            resultado.setText("Resultado: " + pontos);
            avaliacao.setText("Sonolência Grave");
            imgResultado.setImageResource(R.drawable.resultado5);
        }
    }

    public void btnResultadoOnClick(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}