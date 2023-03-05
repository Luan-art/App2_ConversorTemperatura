package br.edu.ifsp.dmos5;

public class KelvinStrategy implements ConversorTemperatura{

    //Atributo de classe.
    private static KelvinStrategy instance = null;

    private KelvinStrategy(){}

    public static KelvinStrategy getInstance(){
        if(instance == null){
            instance = new KelvinStrategy();
        }
        return instance;
    }

    @Override
    public double getConversion(double temperature, int value) {
        
        if(value == 0){
            temperature = temperature + 273;
        } else if (value == 1) {
            temperature = (temperature - 32) * 5/9 + 273.15;

        }

        return temperature;
    }
}
