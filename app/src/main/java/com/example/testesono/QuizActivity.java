package com.example.testesono;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class QuizActivity extends AppCompatActivity {

    List<Questao> questoes = new ArrayList<Questao>(){
        {
            add(new Questao("Sentado e Lendo", "Nenhuma chance de cochilar", "Leve chance de cochilar", "Chance moderada de cochilar", "Alta chance de cochilar"));
            add(new Questao("Sentado vendo televisão", "Nenhuma chance de cochilar", "Leve chance de cochilar", "Chance moderada de cochilar", "Alta chance de cochilar"));
            add(new Questao("Ficar sentado, sem fazer nada, em um local público","Nenhuma chance de cochilar", "Leve chance de cochilar", "Chance moderada de cochilar", "Alta chance de cochilar"));
            add(new Questao("Ficar sentado, por uma hora, como passageiro em um carro", "Nenhuma chance de cochilar", "Leve chance de cochilar", "Chance moderada de cochilar", "Alta chance de cochilar"));
            add(new Questao("Deitar a tarde para descansar","Nenhuma chance de cochilar", "Leve chance de cochilar", "Chance moderada de cochilar", "Alta chance de cochilar"));
            add(new Questao("Sentar e conversar com ourtra pessoa","Nenhuma chance de cochilar", "Leve chance de cochilar", "Chance moderada de cochilar", "Alta chance de cochilar"));
            add(new Questao("Sentar, em silêncio, depois do almoço (sem ingestão de álcool)", "Nenhuma chance de cochilar", "Leve chance de cochilar", "Chance moderada de cochilar", "Alta chance de cochilar"));
            add(new Questao("Sentado em um carro, parado por alguns minutos por causa do trânsito",  "Nenhuma chance de cochilar", "Leve chance de cochilar", "Chance moderada de cochilar", "Alta chance de cochilar"));
        }
    };


    private void carregarQuestao(){
        if(questoes.size() > 0) {
            Questao q = questoes.remove(0);
            pergunta.setText(q.getPergunta());
            List<String> resposta = q.getRespostas();
            rbResposta1.setText(resposta.get(0));
            rbResposta2.setText(resposta.get(1));
            rbResposta3.setText(resposta.get(2));
            rbResposta4.setText(resposta.get(3));
        }
        else{
            Intent intent = new Intent(this, ResultadoActivity.class);
            intent.putExtra("resultado", pontos);
            startActivity(intent);
            finish();
        }
    }

    private boolean testaBtnGroup(int btnChkID){

        int id1 = 2131296522;
        int id2 = 2131296523;
        int id3 = 2131296524;
        int id4 = 2131296525;

        if(btnChkID == id1 || btnChkID == id2 || btnChkID == id3 || btnChkID == id4){
            return true;
        }
        else return false;

    }

    private int idPoints(int btnChkdID){

        if( btnChkdID == 2131296522) return 0;
        if( btnChkdID == 2131296523) return 1;
        if( btnChkdID == 2131296524) return 2;
        if( btnChkdID == 2131296525) return 3;
        else return 1000;
    }

    private int pontos = 0;

    TextView pergunta;
    RadioButton rbResposta1, rbResposta2, rbResposta3, rbResposta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        getSupportActionBar().hide();

        pergunta = (TextView)findViewById(R.id.pergunta);
        rbResposta1 = (RadioButton)findViewById(R.id.rbResposta1);
        rbResposta2 = (RadioButton)findViewById(R.id.rbResposta2);
        rbResposta3 = (RadioButton)findViewById(R.id.rbResposta3);
        rbResposta4 = (RadioButton)findViewById(R.id.rbResposta4);
        carregarQuestao();
    }

    public void btnResponderOnClick(View v){
        RadioGroup rgRespostas = (RadioGroup)findViewById(R.id.rgRespostas);

        Intent intent = new Intent(this, RespostaActivity.class);

        /*if(rbResposta1.isChecked()){
            pontos = pontos + 0;
            startActivity(intent);
            rgRespostas.clearCheck();
        }else if(rbResposta2.isChecked()) {
            pontos = pontos + 1;
            startActivity(intent);
            rgRespostas.clearCheck();
        }else if(rbResposta3.isChecked()){
                pontos = pontos + 2;
                startActivity(intent);
                rgRespostas.clearCheck();
        }else if(rbResposta4.isChecked()) {
            pontos = pontos + 3;
            startActivity(intent);
            rgRespostas.clearCheck(); */
        if(testaBtnGroup(rgRespostas.getCheckedRadioButtonId())) {

            pontos = idPoints(rgRespostas.getCheckedRadioButtonId()) + pontos;
            startActivity(intent);
            rgRespostas.clearCheck();
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Você precisa marcar uma opção!";
            //CharSequence text = ""+rgRespostas.getCheckedRadioButtonId();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
    @Override
    protected void onRestart(){
        super.onRestart();
        carregarQuestao();
    }
}