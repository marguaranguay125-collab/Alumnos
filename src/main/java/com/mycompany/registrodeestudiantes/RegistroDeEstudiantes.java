/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.registrodeestudiantes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Adriana
 */
public class RegistroDeEstudiantes {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        gestionarAlumno gestionar = new gestionarAlumno ();
         Scanner lector = new Scanner (System.in);

        boolean activo = true;
        int opc;
        // contruir el menu 
        do {
            try {
                System.out.println("==== MENU DE OPCIONES ====");
                System.out.println("==== Seleccione una opcion====");
                System.out.println("1. Registar estudiante");
                System.out.println("2. Listar todos los alumnos");
                System.out.println("3. Modificar alumnos(mediante cedula)");
                System.out.println("4. Eliminar alumno(mediante cedula)");
                System.out.println("5. Generar un reporte de alumnos registrados ");
                System.out.println("6. Salir del programa");
                System.out.println("===============================");
                System.out.print("Selecciona una opcion: ");
                opc = Integer.parseInt(lector.nextLine());
                // contruir en el computador
                switch (opc) {
                    case 1 ->
                        gestionar.registrarAlumno(lector);
                    case 2 ->
                        gestionar.listarrAlumnos();
                    case 3 ->
                        gestionar.modificarAlumno(); 
                    case 4 ->
                        gestionar.eliminarEstudiante();
                    case 5 ->
                        gestionar.generarReporte();
                    case 6 -> {
                        activo = false;
                        System.out.println("usted ha salido del sistema ");
                    }
                    default ->
                        System.out.println("Ha ingresado mal la opcion");
                }
            } catch (NumberFormatException e) {

                System.out.println("Error: debe ingresar un numero.");
            }

        } while (activo);

    }

}
