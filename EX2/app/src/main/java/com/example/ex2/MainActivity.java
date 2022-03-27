package com.example.ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerCursoUm, spinnerCursoDois, spinnerCursoTres;
    TextView resultado;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.txtResultados);

        // Atribuição dos spinners
        spinnerCursoUm = (Spinner)findViewById(R.id.spinnerQuestaoUm);
        spinnerCursoDois = (Spinner)findViewById(R.id.spinnerQuestaoDois);
        spinnerCursoTres = (Spinner)findViewById(R.id.spinnerQuestaoTres);

        // Preenchendo os spinners com os array configurados pelo quiz.xml
        String[] questaoUm = getResources().getStringArray(R.array.QuestaoUm_array);
        String[] questaoDois = getResources().getStringArray(R.array.QuestaoDois_array);
        String[] questaoTres = getResources().getStringArray(R.array.QuestaoTres_array);

        // Atribuindo os adapters aos arrays
        ArrayAdapter<String> adapterUm = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,questaoUm);

        ArrayAdapter<String> adapterDois = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,questaoDois);

        ArrayAdapter<String> adapterTres = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,questaoTres);

        spinnerCursoUm.setAdapter(adapterUm);
        spinnerCursoDois.setAdapter(adapterDois);
        spinnerCursoTres.setAdapter(adapterTres);
    }

    // Método da validação dos resultados do Quiz
    public void OnClick (View view) {
        String valorSelecionadoQuestaoUm = spinnerCursoUm.getSelectedItem().toString();
        String valorSelecionadoQuestaoDois = spinnerCursoDois.getSelectedItem().toString();
        String valorSelecionadoQuestaoTres = spinnerCursoTres.getSelectedItem().toString();

        for (int i = 0; i < 1; i++) {
            if (valorSelecionadoQuestaoUm.equals("Private")) {
                count++;
            } if (valorSelecionadoQuestaoDois.equals("Plankalkül")) {
                count++;
            } if (valorSelecionadoQuestaoTres.equals("Typescript")) {
                count++;
            }
        }

        resultado.setText("Você acertou: " + count + " de 3 questões.");
        // Limpando o count
        count = 0;
    }
}