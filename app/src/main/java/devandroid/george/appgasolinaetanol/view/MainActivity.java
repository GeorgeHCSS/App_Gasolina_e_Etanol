package devandroid.george.appgasolinaetanol.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import devandroid.george.appgasolinaetanol.R;
import devandroid.george.appgasolinaetanol.controller.CombustivelController;
import devandroid.george.appgasolinaetanol.model.Combustivel;

public class MainActivity extends AppCompatActivity {
    CombustivelController combustivelController;
    Combustivel combustivel;

    EditText editGasolina;
    EditText editEtanol;
    TextView editResultado;

    Button btnCalcular;
    Button btnSalvar;
    Button btnLimpar;
    Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        combustivelController = new CombustivelController(MainActivity.this);
        combustivel = new Combustivel();
        combustivelController.getDados(combustivel);

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);
        editResultado = findViewById(R.id.editResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editGasolina.setText("");
                editEtanol.setText("");
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}