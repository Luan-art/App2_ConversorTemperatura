package br.edu.ifsp.dmos5;

public class FahrenheitStrategy implements ConversorTemperatura{

    //Atributo de classe.
    private static FahrenheitStrategy instance = null;

    private FahrenheitStrategy(){}

    public static FahrenheitStrategy getInstance(){
        if(instance == null){
            instance = new FahrenheitStrategy();
        }
        return instance;
    }

    @Override
    public double getConversion(double temperature, int value) {

        // para transformar em celsius
        // fahrenheit para celsius
        if(value == 1){
            temperature = (temperature - 32)/1.8;
        //kelvin para celsius
        } else if (value == 2) {
            temperature = (temperature - 273);
        }

        return temperature;
    }
}
