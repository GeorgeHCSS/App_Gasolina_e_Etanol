package devandroid.george.appgasolinaetanol.apoio;

public class UtilGasEta {
    public static String calcularMelhorOpcao(double gasolina, double etanol) {
        double precoIdeal = gasolina * 0.70;
        String mensagemDeRetorno;

        if(etanol <= precoIdeal){
            mensagemDeRetorno = "Abastecer com Etanol";
        } else {
            mensagemDeRetorno = "Abatecer com Gasolina";
        }
             return mensagemDeRetorno;
    }
}
