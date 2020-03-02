package zork;

public interface ZorkData {
    public static final String[] TEXT = {
        "Te encuentras en la entrada principal de un antiguo templo, 80 km al norte de Siem Reap." +
        "Oculto entre la espesura de la selva, sinuosas raíces y tallos trepadores pugnan por abrirse " +
        "camino entre sus ancianas paredes\n" +
        "Aún después de siglos de abandono y olvido, conserva toda su grandeza y majestuosidad..." +
        "Rápido! No hay tiempo que perder! El edificio podría venirse abajo en cualquier momento!" +
        "Recuerda! Al sur de la estancia donde te encuentras, se haya la salida del recinto sagrado.",

        "Has salido al exterior de la pirámide...\nApenas segundos antes de que se desmorone!\n" +
        "Con el tiempo, el espesor de la jungla borrará para siempre su recuerdo y sus tesoros aún ocultos...",

        "Vaya! La linterna ha vuelto a fallar!\n" +
        "A oscuras, consigues prender una antorcha improvisada...\n" + 
        "A través de la vacilante luz, vislumbras un sinfín de monedas y estatuillas de oro, " +
        "piedras preciosas, suntuosos collares y brazaletes...\n" +
        "Lo has conseguido! Es la Cámara del Tesoro!\n" +
        "Rápido! La pirámide está a punto de derrumbarse... Hazte con lo que puedas y sal de aquí!",

        "Oyes un ruido a tu espalda!\nAl atravesar la puerta, accionaste el mecanismo que ciega " +
        "el corredor por el que llegaste...\nToneladas de piedra y arena, bloquean ahora la entrada...\n" +
        "Maldices tu suerte, al tiempo que la luz de tu linterna comienza a desvanecerse también...\n" +
        "Estás acabado... y lo sabes!",

        "Ante ti se abre una enorme estancia.\n" +
        "Algún mobiliario, desvencijado por el implacable paso del tiempo pero que aún " +
        "conserva restos de su cromado original, languidece contra las paredes.\n" +
        "Puñados de monedas, cálices y vasijas de bronce se entremezclan con la madera carcomida.",

        "Te encuentras en una pequeña habitación.\n" + 
        "Restos de antiguas vasijas de barro y de armas primitivas carcomidas por la herrumbre " +
        "se amontonan en las esquinas",

        "Te adentras en un corredor angosto y oscuro cuyas paredes parecen abalanzarse sobre ti.\n" + 
        "Apenas hay espacio para atravesarlo y las hendiduras y hoquedades de suelo " + 
        "y paredes no presagian nada bueno..."        
    };   
    
    public static final int NUM_SALAS = 10;
    public static final int TEXT_ENT = 0;
    public static final int TEXT_EXT = 1;
    public static final int TEXT_TES = 2;
    public static final int TEXT_TRA = 3;
    public static final int TEXT_COM_INI = 4;
    public static final int TEXT_COM_LEN = 3;    
}