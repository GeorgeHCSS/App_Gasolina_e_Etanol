package devandroid.george.appgasolinaetanol.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import devandroid.george.appgasolinaetanol.database.GasEtaDB;
import devandroid.george.appgasolinaetanol.model.Combustivel;
import devandroid.george.appgasolinaetanol.view.MainActivity;

public class CombustivelController extends GasEtaDB {
    SharedPreferences preferences;
    SharedPreferences.Editor infoCombustivel;
    public static final String NOME_PREFERENCE = "pref_infoCombustivel";

    public CombustivelController(MainActivity activity) {
        super(activity);
        preferences = activity.getSharedPreferences(NOME_PREFERENCE, 0);
        infoCombustivel = preferences.edit();
    }


    public void salvar(Combustivel combustivel){
        ContentValues dados = new ContentValues();
        infoCombustivel.putFloat("Gasolina", combustivel.getGasolina());
        infoCombustivel.putFloat("Etanol", combustivel.getEtanol());
        infoCombustivel.putString("Recomendação", combustivel.getResultado());
        infoCombustivel.apply();

        dados.put("gasolina", combustivel.getGasolina());
        dados.put("etanol", combustivel.getEtanol());
        dados.put("recomendacao", combustivel.getResultado());

        salvarObjeto("Combustivel", dados);

    }

    public void getDados(Combustivel combustivel) {
        combustivel.setGasolina(preferences.getFloat("Gasolina", 0));
        combustivel.setEtanol(preferences.getFloat("Etanol", 0));
        combustivel.setResultado(preferences.getString("RESULTADO", "NA"));
    }
    public void limpar(){
        infoCombustivel.clear();
        infoCombustivel.apply();
    }
}
