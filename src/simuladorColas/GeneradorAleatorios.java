package simuladorColas;

import java.util.Random;

/**
 *
 * @author Fabi�n Guevara
 * @date 16-6-10
 * @version 0.1
 *
 * Esta es una clase de utiler�a con funciones estad�sticas generales para
 * producir n�meros aleatorios con diferentes distribuciones
 */
public class GeneradorAleatorios {

    static java.util.Random generador;

    //private static int[] bufferAleatorios = new int[624];

    /**
     * Dado un entero n, obtiene un n�mero real que toma a 0 como parte entera y
     * a los d�gitos de n como parte flotante
     * @param num n�mero entero a partir del cu�l se construye el n�mero real
     * @return un n�mero real que usa a los d�gitos de num como parte flotante
     * y a 0 como parte entera. Es decir, el n�mero devuelto es igual a 0.num
     */
    private static double convertir(int num) {
        if(Integer.signum(num)!=1){
            num*=-1;
        }
        String valor = num+"";
        valor = "0."+valor;
        return Double.parseDouble(valor);
    }
    /**
     * Ajusta un nuevo valor como semilla
     * @param s nueva semilla
     */
    public static void setSemilla(long s) {
        /*GeneradorAleatorios.generador = new java.util.Random();
        GeneradorAleatorios.generador.setSeed(s);
        for (int i = 0; i < 624; i++)
        {
            bufferAleatorios[i] = GeneradorAleatorios.generador.nextInt();
        }
        indiceDelBuffer = 0;*/
    }

    /**
     * Genera un nuevo n�mero pseudo-aleatorio uniforme en [0, 1[ usando el
     * m�todo de Mersenne Twister
     * @see http://www.qbrundage.com/michaelb/pubs/essays/random_number_generation.html
     * @return un n�mero pseudo-aleatorio uniforme en [0, 1[
     */
    public static double nextUniforme() {
        //c�digo para generar un random uniforme en [0, 1[
        int seed[] = new int[256];
        Random aleatorio = new Random();
        for (int i = 0; i < seed.length; i++) {
            seed[i] = (int)(aleatorio.nextFloat()*10000);
        }
        Rand x = new Rand(seed);
        for (int i = 0; i < 2; ++i) {
            x.Isaac();
        }
        double alea = convertir(x.rsl[x.SIZE-1*x.SIZE]);
        double valor = convertir(x.rsl[(int)alea]);
        //System.out.println(valor);
        return valor;
       // return generador.nextDouble();
    }

    /**
     * Genera un nuevo entero pseudo-aleatorio uniforme en [0, tope[
     * @param cota superior al valor devuelto por este m�todo
     * @return un entero pseudo-aleatorio uniforfe en [0, tope[
     */
    public static int nextUniforme(int tope) {
        return (int) (GeneradorAleatorios.nextUniforme() * tope);
    }

    /**
     * Genera un nuevo n�mero pseudo-aleatorio exponencial en [0, 1[
     * @param lambda valor esperado (media)
     * @return un n�mero pseudo-aleatorio uniforfe en [0, 1[
     */
    public static double nextExponencial(double lambda)
    {
        return -1*Math.log(GeneradorAleatorios.nextUniforme())/lambda;
    }
}