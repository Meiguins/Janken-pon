package com.kauan.janken_pon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("rock");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("paper");
    }

    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("scissors");
    }


    public  void opcaoSelecionada(String escolhaUsuario){

        ImageView imageResultado = findViewById(R.id.imageResult);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"rock","paper","scissors"};
        String escolhaApp = opcoes[ numero ];

        switch ( escolhaApp ){
            case "rock" :
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "paper" :
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "scissors" :
                imageResultado.setImageResource(R.drawable.tesoura);
                break;

        }

        if(
                (escolhaApp == "scissors" && escolhaUsuario == "paper")  ||
                        (escolhaApp == "paper" && escolhaUsuario == "rock" ) ||
                        (escolhaApp == "rock" && escolhaUsuario == "scissors")
        ){//app ganhador
            textoResultado.setText("You lost :(");

        } else if (
                (escolhaUsuario == "scissors" && escolhaApp == "paper")  ||
                (escolhaUsuario == "paper" && escolhaApp == "rock" ) ||
                (escolhaUsuario == "rock" && escolhaApp == "scissors")
        ){//Usuario ganhador
             textoResultado.setText("You won :)");
        } else {//Empate
             textoResultado.setText("It looks like we tied '-'");
        }

        System.out.println( "item clicked:" + escolhaApp);


    }

}