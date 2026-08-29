/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrodeestudiantes;

/**
 *
 * @author Adriana
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class gestionarAlumno {

    Scanner lector = new Scanner(System.in);
    ArrayList<Alumno> misAlumnos = new ArrayList<>();

    public gestionarAlumno() {
        try {
            leerAlumnos();
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo, se iniciará vacío.");
        }
    }

    public void registrarAlumno(Scanner lector) throws FileNotFoundException, IOException {

        System.out.println("ingrese su cedula");
        String cedula = lector.nextLine();

        for (Alumno c : misAlumnos) {
            if (c.getCedula().equals(cedula)) {
                System.out.println("este codigo ya existe");
            }
        }
        String nombre;

        while (true) {
            try {
                System.out.println("Ingrese el nombre:");
                nombre = lector.nextLine();

                for (int i = 0; i < nombre.length(); i++) {
                    if (Character.isDigit(nombre.charAt(i))) {
                        throw new IllegalArgumentException(
                                "El nombre no puede contener numeros.");
                    }
                }

                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String apellido;

        while (true) {
            try {
                System.out.println("Ingrese el apellido:");
                apellido = lector.nextLine();

                for (int i = 0; i < apellido.length(); i++) {
                    if (Character.isDigit(apellido.charAt(i))) {
                        throw new IllegalArgumentException(
                                "El apellido no puede contener numeros.");
                    }
                }

                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        int edad;
        int semestre;
        while (true) {
            try {
                System.out.println("Ingrese su edad:");
                edad = Integer.parseInt(lector.nextLine());

                if (edad < 0) {
                    throw new IllegalArgumentException(
                            "La edad no puede ser menor a 0."
                    );
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero.");

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.println("Ingrese su semestre:");
                semestre = Integer.parseInt(lector.nextLine());

                if (semestre < 1 || semestre > 10) {
                    throw new IllegalArgumentException(
                            "El semestre debe estar entre 1 y 10."
                    );
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero.");

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        Alumno miAlumnos = new Alumno(cedula, nombre, apellido, edad, semestre);

        misAlumnos.add(miAlumnos);

        System.out.println("Alumno agregado con exito");

        grabarAlumno();

    }

    public void listarrAlumnos() {

        if (misAlumnos.isEmpty()) {

            System.out.println("No hay animales registrados");
            return;
        }

        System.out.println("========================================");
        System.out.println("          LISTADO DE ALUMNOS");
        System.out.println("========================================");
        for (Alumno c : misAlumnos) {
            System.out.println(c.resumenBasico());
            System.out.println("-------------------------");

        }
    }

    public void modificarAlumno() {
        if (misAlumnos.isEmpty()) {
            System.out.println("No hay estudiantes registrados");
            return;
        }
        System.out.println("ingrese la cedula");
        String cedula = lector.nextLine();

        boolean encontrado = false;

        for (Alumno c : misAlumnos) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                encontrado = true;

                System.out.println("ALUMNO ENCONTRADO");

                System.out.println("Ingerese su nuevo nombre");
                String nuevo_nombre = lector.nextLine();
                c.setNombre(nuevo_nombre);

                System.out.println("Ingrese su nuevo apellido");
                String nuevo_apellido = lector.nextLine();
                c.setApellido(nuevo_apellido);

                System.out.println("Ingrese su nueva edad");
                int nueva_edad = Integer.parseInt(lector.nextLine());
                c.setEdad(nueva_edad);

                System.out.println("Ingrese su nuevo semestre");
                int nuevo_semestre = Integer.parseInt(lector.nextLine());
                c.setSemestre(nuevo_semestre);

                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encuentra estudiante registrado");
        }
    }

    public void eliminarEstudiante() {

        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados");
            return;
        }

        System.out.println("Ingrese la cedula:");
        String cedula = lector.nextLine();

        for (Alumno c : misAlumnos) {

            if (c.getCedula().equalsIgnoreCase(cedula)) {

                misAlumnos.remove(c);
                System.out.println("Alumno eliminado correctamente");

                return;
            }
        }

        System.out.println("Alumno no encontrado");
    }

    public void generarReporte() {

        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados");
            return;
        }

        int totalAlumnos = misAlumnos.size();

        int sumaEdades = 0;
        int mayorEdad = misAlumnos.get(0).getEdad();
        int menorEdad = misAlumnos.get(0).getEdad();

        Alumno alumnoMayor = misAlumnos.get(0);
        Alumno alumnoMenor = misAlumnos.get(0);

        int[] alumnosPorSemestre = new int[11];

        int jovenes = 0;
        int adultosJovenes = 0;
        int adultos = 0;

        for (Alumno c : misAlumnos) {

            int edad = c.getEdad();
            int semestre = c.getSemestre();
            sumaEdades += edad;
            // Edad mayor
            if (edad > mayorEdad) {
                mayorEdad = edad;
                alumnoMayor = c;
            }
            // Edad menor
            if (edad < menorEdad) {
                menorEdad = edad;
                alumnoMenor = c;
            }
            // Alumnos por semestre
            if (semestre >= 1 && semestre <= 10) {
                alumnosPorSemestre[semestre]++;
            }

            // Rangos de edad
            if (edad <= 20) {
                jovenes++;
            } else if (edad <= 25) {
                adultosJovenes++;
            } else {
                adultos++;
            }
        }
        double promedioEdad = (double) sumaEdades / totalAlumnos;
        // Buscar el semestre con más alumnos
        int semestreMayor = 1;
        for (int i = 1; i <= 10; i++) {
            if (alumnosPorSemestre[i] > alumnosPorSemestre[semestreMayor]) {
                semestreMayor = i;
            }
        }
        System.out.println("REPORTE DE ALUMNOS");

        System.out.println("Total de alumnos registrados: " + totalAlumnos);

        System.out.printf("Edad promedio: %.2f años%n", promedioEdad);

        System.out.println();
        System.out.println("              -EDADES-               ");

        System.out.println("Alumno de mayor edad:");
        System.out.println(alumnoMayor.getNombre() + " "
                + alumnoMayor.getApellido()
                + " - " + mayorEdad + " años");

        System.out.println();

        System.out.println("Alumno de menor edad:");
        System.out.println(alumnoMenor.getNombre() + " "
                + alumnoMenor.getApellido()
                + " - " + menorEdad + " años");

        System.out.println();
        System.out.println("             - SEMESTRES -            ");

        for (int i = 1; i <= 10; i++) {
            if (alumnosPorSemestre[i] > 0) {
                System.out.println("Semestre " + i + ": "
                        + alumnosPorSemestre[i] + " alumno(s)");
            }
        }

        System.out.println();

        System.out.println("Semestre con mayor cantidad de alumnos: "
                + semestreMayor
                + " (" + alumnosPorSemestre[semestreMayor]
                + " alumno(s))");

        System.out.println();
        System.out.println("- RANGOS DE EDAD -");

        System.out.println("Hasta 20 años: " + jovenes + " alumno(s)");
        System.out.println("De 21 a 25 años: " + adultosJovenes + " alumno(s)");
        System.out.println("Mayores de 25 años: " + adultos + " alumno(s)");

        System.out.println();
    }

    /**
     * metodo grabar alumno
     *
     */
    private void grabarAlumno() throws FileNotFoundException {//pasar la contenedora al archivo tal como esta, no hace nada mas 
        File archivo = new File("./data/alumnos.txt");//ES UNA RUTA RELATIVA
        try (PrintWriter pluma = new PrintWriter(archivo)) {

            for (Alumno a : misAlumnos) {
                pluma.println(a.getCedula() + ","
                        + a.getNombre() + ","
                        + a.getApellido() + ","
                        + a.getEdad() + ","
                        + a.getSemestre());
            }

        }

    }

    private void leerAlumnos() throws FileNotFoundException, IOException {
        File archivo = new File("./data/alumnos.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(fr);

        lector.readLine();
        String linea = lector.readLine();

        while (linea != null) {
            String[] datos = linea.split(",");
            String cedula = datos[0];
            String nombre = datos[1];
            String apellido = datos[2];
            int edad = Integer.parseInt(datos[3]);
            int semestre = Integer.parseInt(datos[4]);

            Alumno alumno = new Alumno(cedula, nombre, apellido, edad, semestre);

            misAlumnos.add(alumno);

            linea = lector.readLine();

        }
        fr.close();
        lector.close();
    }

}
