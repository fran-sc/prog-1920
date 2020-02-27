package zork;

public class SalaComun extends Sala {
    private final String[] TEXT = {
        "Ante ti se abre una enorme estancia.\n" +
        "Algún mobiliario, desvencijado por el implacable paso del tiempo pero que aún " +
        "conserva restos de su cromado original, languidece contra las paredes.\n" +
        "Puñados de monedas, cálices y vasijas de bronce se entremezclan con la madera carcomida.",

        "Te encuentras en una pequeña habitación.\n" + 
        "Restos de antiguas vasijas de barro y de armas primitivas carcomidas por la herrumbre " +
        "se amontonan en las esquinas",

        "Te encuentras en un corredor estrecho y oscuro cuyas paredes parecen abalanzarse sobre ti.\n" + 
        "Apenas hay espacio para atravesarlo y las hendiduras y hoquedades de suelo y paredes no " +
        "presagian nada bueno..."
    };
    
    public SalaTesoro() {
        super(TEXT[new java.util.Random().nextInt(TEXT.length)]);
    }
}