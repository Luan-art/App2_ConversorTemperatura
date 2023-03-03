package br.edu.ifsp.dmos5;

public class CelsiusStrategy implements ConversorTemperatura{

    //Atributo de classe.
    private static CelsiusStrategy instance = null;

    private CelsiusStrategy(){}

    public static CelsiusStrategy getInstance(){
        if(instance == null){
            instance = new CelsiusStrategy();
        }
        return instance;
    }

    @Override
    public double getConversion(double temperature) {

        temperature = 1.8 * temperature + 32;

        return temperature;
    }
}

