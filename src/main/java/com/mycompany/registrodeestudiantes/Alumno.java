/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrodeestudiantes;

/**
 *
 * @author Adriana
 */
public class Alumno {

    String Cedula;
    String Nombre;
    String Apellido;
    int Edad;
    int Semestre;

    public Alumno() {
    }

    public Alumno(String Cedula, String Nombre, String Apellido, int Edad, int Semestre) {

        if (Edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser menor a 0.");
        }

        if (Semestre < 1 || Semestre > 10) {
            throw new IllegalArgumentException("El semestre debe estar entre 1 y 10.");
        }
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Semestre = Semestre;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad() {

        return Edad;
    }

    public void setEdad(int Edad) {

        if (Edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser menor a 0.");
        }

        this.Edad = Edad;
    }

    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int Semestre) {
        if (Semestre < 1 || Semestre > 10) {
            throw new IllegalArgumentException("El semestre debe estar entre 1 y 10.");
        }
        this.Semestre = Semestre;
    }

    public String resumenBasico() {
        return "Cedula: " + Cedula
                + "\nNombre: " + Nombre
                + "\nApellido: " + Apellido
                + "\nEdad: " + Edad
                + "\nSemestre: " + Semestre;
    }

}
