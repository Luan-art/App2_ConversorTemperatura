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
    public double getConversion(double temperature) {

        temperature = (temperature - 32)/1.8;

       return temperature;
    }
}
