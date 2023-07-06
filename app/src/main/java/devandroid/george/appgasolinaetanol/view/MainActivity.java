package devandroid.george.appgasolinaetanol.view;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import devandroid.george.appgasolinaetanol.R;
import devandroid.george.appgasolinaetanol.apoio.UtilGasEta;
import devandroid.george.appgasolinaetanol.controller.CombustivelController;
import devandroid.george.appgasolinaetanol.database.GasEtaDB;
import devandroid.george.appgasolinaetanol.model.Combustivel;

public class MainActivity extends AppCompatActivity {
    CombustivelController combustivelController;
    Combustivel combustivel;
    GasEtaDB gasEtaDB;

    EditText editGasolina;
    EditText editEtanol;
    TextView editResultado;

    Button btnCalcular;
    Button btnSalvar;
    Button btnLimpar;
    Button btnFinalizar;

    double mGasolina;
    double mEtanol;
    String recomendacao;

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

        GasEtaDB db = new GasEtaDB(MainActivity.this);



        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDadosOk = true;
                if(TextUtils.isEmpty(editGasolina.getText())){
                    editGasolina.setError("* Obrigatório");
                    editGasolina.requestFocus();
                    isDadosOk = false;
                    btnSalvar.setEnabled(false);
                }
                if(TextUtils.isEmpty(editEtanol.getText())) {
                    editEtanol.setError("* Obrigatório");
                    editEtanol.requestFocus();
                    isDadosOk = false;
                    btnSalvar.setEnabled(false);
                }
                if(isDadosOk){
                    mGasolina = Double.parseDouble(editGasolina.getText().toString());
                    mEtanol = Double.parseDouble(editEtanol.getText().toString());
                    recomendacao = UtilGasEta.calcularMelhorOpcao(mGasolina,mEtanol);
                    editResultado.setText(recomendacao);
                    btnSalvar.setEnabled(true);


                }else {
                    Toast.makeText(MainActivity.this,
                            "Por Favor, digite os Dados Obrigatorios", Toast.LENGTH_LONG).show();

                }
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editGasolina.setText("");
                editEtanol.setText("");
                editResultado.setText("RESULTADO");
                combustivelController.limpar();
                btnSalvar.setEnabled(false);
            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mGasolina = Double.parseDouble(editGasolina.getText().toString());
                mEtanol = Double.parseDouble(editEtanol.getText().toString());
                combustivel.setGasolina((float) mGasolina);
                combustivel.setEtanol((float) mEtanol);
                combustivel.setResultado(recomendacao);

                combustivelController.salvar(combustivel);
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