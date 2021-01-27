package prog2021.eval2A_damdaw1;

import java.sql.Date;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class Utilidades {

    /**
     * Función que pide al usuario que introduzca 's' o 'S' para Sí o 'n' o 'N'
     * para No y devuelve true o false en cada caso. Si el usuario no introduce
     * ni 's' ni 'S' ni 'n' ni 'N' entonces avisa al usuario y le vuelve a pedir
     * a que lo introduzca de nuevo.
     *
     * @return true si el usuario introduce 's' o 'S'; false si el usuario
     * introduce 'n' o 'N'
     */
   /* public static boolean entrarBolean() {

        char res;
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("entre s/S es si o  n/N si es no");
            res = in.nextLine().charAt(0);
        } while (res != 's' && res != 'S' && res != 'n' && res != 'N');

        //return  true o false depende del valor de res
        if (res == 's' || res == 'S') {
            return true;
        } else {
            return false;
        }
    }
    */

    public static boolean leerBoolean() {
        boolean ret;
        Scanner in;
        char resp;
        do {
            System.out.println("Pulse s para Sí o n para No");
            in = new Scanner(System.in, "ISO-8859-1");
            resp = in.nextLine().charAt(0);
            if (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N') {
                System.out.println("Valor introducido incorrecto.");
            }
        } while (resp != 's' && resp != 'S' && resp != 'n' && resp != 'N');
        if (resp == 's' || resp == 'S') {
            ret = true;
        } else {
            ret = false;
        }
        return ret;
    }

    /**
     * Función que pide al usuario que introduzca un valor decimal por la
     * entrada estándar. Si el formato introducido no es correcto, avisa al
     * usuario y le vuelve a pedir que lo introduzca de nuevo.
     *
     * @return el valor double introducido por el usuario
     */
    public static double leerDouble() {
        double ret = 0.0;
        boolean correcto = false;
        Scanner in;
        do {
            System.out.println("Introduzca un valor decimal (xx.xx)");
            in = new Scanner(System.in, "ISO-8859-1");
            try {
                ret = in.nextDouble();
                correcto = true;
            } catch (InputMismatchException ime) {
                System.out.println("Formato introducido incorrecto.");
                correcto = false;
            }
        } while (!correcto);
        return ret;
    }

    /**
     * Función que pide al usuario que introduce un valor para una fecha a
     * partir de 3 enteros para el día, mes y año respectivamente. Si los
     * valores introducidos no producen una fecha correcta, avisa al usuario y
     * le pide que los introduzca de nuevo. Si no lo consigue, devolverá null
     *
     * @return una fecha de la clase java.sql.Date o null si hay error
     */

    public static java.sql.Date leerFecha() {
        //una fecha de la clase java.sql.Date egual null si hay error
        Date ret = null;
        // 3 enteros 
        int dia, mes, anio;
        // puede ser false o true
        boolean correcto = false;
        //Función que pide al usuario que introduce un valor para una fecha a
        //partir de 3 enteros para el día, mes y año respectivamente
        Scanner in;
        do {
            System.out.println("Introduzca un valor para el día (1...31)");
            in = new Scanner(System.in, "ISO-8859-1");
            dia = in.nextInt();
            System.out.println("Introduzca un valor para el mes (1...12)");
            in = new Scanner(System.in, "ISO-8859-1");
            mes = in.nextInt();
            System.out.println("Introduzca un valor para el año");
            in = new Scanner(System.in, "ISO-8859-1");
            anio = in.nextInt();
//Si los valores introducidos no producen una fecha correcta, avisa al usuario y
//le pide que los introduzca de nuevo. 
            try {
                ret = Date.valueOf(LocalDate.of(anio, mes, dia));
                correcto = true;
            } catch (Exception e) {
                System.out.println("Fecha introducida incorrecta." + e);
                correcto = false;
            }
            //avisa al usuario y le pide que los introduzca de nuevo. 
        } while (!correcto);
        //return una fecha de la clase java.sql.Date o null si hay error
        return ret;
    }

    public static String removeDiacriticalMarks(String string) {
        //Form.NFC acepta ñ y distingue las tildes en español
        return Normalizer.normalize(string, Form.NFC)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
