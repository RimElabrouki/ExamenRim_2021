/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog2021.eval2A_damdaw1;

import entidades.AJaula;
import entidades.ALibertad;
import entidades.Animal;
import entidades.Cuidador;
import entidades.Empleado;
import entidades.Jaula;
import entidades.Recinto;
import entidades.Veterinario;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rim
 */
public class ExamenRim {

    public static void main(String[] args) {
        //cargar los datos desde los arrays de la clase DatosBD (pseudo-Base de datos)
        ArrayList<Jaula> jaulas = Jaula.convertir(DatosBD.JAULAS);
        ArrayList<Recinto> recintos = Recinto.convertir(DatosBD.RECINTOS);
        ArrayList<Animal> animales = new ArrayList<Animal>();
        ArrayList<AJaula> animalesJaula = AJaula.convertir(DatosBD.ANIMALESJAULA);
        ArrayList<ALibertad> animalesLibres = ALibertad.convertir(DatosBD.ANIMALESLIBRES);
        animales.addAll(animalesJaula.subList(0, 6));
        animales.addAll(animalesLibres.subList(0, 6));
        animales.addAll(animalesJaula.subList(6, 10));
        animales.addAll(animalesLibres.subList(6, 10));
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        ArrayList<Veterinario> veterinarios = Veterinario.convertir(DatosBD.VETERINARIOS);
        ArrayList<Cuidador> cuidadores = Cuidador.convertir(DatosBD.CUIDADORES);
        empleados.addAll(cuidadores);
        empleados.addAll(veterinarios);
        /*
          cargamos los datos de las relaciones entre las entidades que no fue
          posible cargar directamente desde DatosBD (ya que no es una BD real).
         */
        //Relación "cuidar" entre Veterinario-Animal (desde el lado del Veterinario)
        animales.get(0).cuidarDe(veterinarios.get(1));
        animales.get(0).cuidarDe(veterinarios.get(3));
        animales.get(1).cuidarDe(veterinarios.get(1));
        animales.get(1).cuidarDe(veterinarios.get(3));
        animales.get(2).cuidarDe(veterinarios.get(1));
        animales.get(2).cuidarDe(veterinarios.get(2));
        animales.get(3).cuidarDe(veterinarios.get(1));
        animales.get(3).cuidarDe(veterinarios.get(2));
        animales.get(4).cuidarDe(veterinarios.get(1));
        animales.get(4).cuidarDe(veterinarios.get(2));
        animales.get(5).cuidarDe(veterinarios.get(1));
        animales.get(5).cuidarDe(veterinarios.get(3));
        animales.get(7).cuidarDe(veterinarios.get(0));
        animales.get(7).cuidarDe(veterinarios.get(2));
        animales.get(8).cuidarDe(veterinarios.get(0));
        animales.get(8).cuidarDe(veterinarios.get(2));
        animales.get(11).cuidarDe(veterinarios.get(1));
        animales.get(11).cuidarDe(veterinarios.get(2));
        animales.get(12).cuidarDe(veterinarios.get(1));
        animales.get(11).cuidarDe(veterinarios.get(3));
        animales.get(13).cuidarDe(veterinarios.get(3));
        animales.get(14).cuidarDe(veterinarios.get(3));
        animales.get(15).cuidarDe(veterinarios.get(3));
        animales.get(16).cuidarDe(veterinarios.get(1));
        animales.get(16).cuidarDe(veterinarios.get(2));
        animales.get(17).cuidarDe(veterinarios.get(2));
        animales.get(18).cuidarDe(veterinarios.get(4));
        animales.get(19).cuidarDe(veterinarios.get(4));

        //Relación "encargado" entre Cuidador-Recinto (desde el lado del Cuidador)
        cuidadores.get(5).encargadoDe(recintos.get(0)); //Antonio Rollo Pérez encargado de R1
        cuidadores.get(0).encargadoDe(recintos.get(1)); //Jordi Fraga Pull encargado de R2
        recintos.get(2).encargadoDe(cuidadores.get(3)); //Pedro Luis Márquez Prieto encargado de R3
        recintos.get(3).encargadoDe(cuidadores.get(2)); //Raquel Gal Ordas encargada de R4

        /*
          A partir de este punto ya se tienen cargados todos los datos.
          Debería trabajarse sólo con los ArrayList empleados, recintos y animales.
         */
        int opcion = -1, opcion2 = -1;
        Scanner in;
    }
}
