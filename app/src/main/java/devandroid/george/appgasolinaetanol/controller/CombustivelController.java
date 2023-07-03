package devandroid.george.appgasolinaetanol.controller;

import android.content.SharedPreferences;

import devandroid.george.appgasolinaetanol.model.Combustivel;
import devandroid.george.appgasolinaetanol.view.MainActivity;

public class CombustivelController {
    SharedPreferences preferences;
    SharedPreferences.Editor infoCombustivel;
    public static final String NOME_PREFERENCE = "pref_infoCombustivel";

    public CombustivelController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCE, 0);
        infoCombustivel = preferences.edit();
    }


    public void salvar(Combustivel combustivel){
        infoCombustivel.putFloat("Gasolina", combustivel.getGasolina());
        infoCombustivel.putFloat("Etanol", combustivel.getEtanol());
        infoCombustivel.apply();
    }

    public void getDados(Combustivel combustivel) {
        combustivel.setGasolina(preferences.getFloat("Gasolina", 0));
        combustivel.setEtanol(preferences.getFloat("Etanol", 0));
    }
}
