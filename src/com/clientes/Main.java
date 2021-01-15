package com.clientes;

import com.clases.BeneficiosCovid19;
import com.clases.Constantes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * Crear 2 lista de beneficios para clientes Lista 1 y Lista 2 por ejemplo
     * Ejemplo:
     * id:12121
     * nombre: Beneficiados que perdieron su trabajo por COVID19
     * valorSubsidio: 150000
     *
     * Ejemplo:
     * id:895656
     * Nombre: Beneficios para persona tercera edad dagnificados COVID
     * valorSubsidio:200000
     */

    public static void main(String[] args) {
	// write your code her

        //Crear objeto de la clase BeneficiosCovid19
        BeneficiosCovid19 beneficioscovid = new BeneficiosCovid19();

        // Declarar tamaño vector
        int nroarray;

        // Crear lista de la Clase BeneficiosCovid19
        ArrayList<BeneficiosCovid19> lista1 = new ArrayList<BeneficiosCovid19>();
        ArrayList<BeneficiosCovid19> lista2 = new ArrayList<BeneficiosCovid19>();

        //Ingresar Informacion al lista1
        nroarray= 1;
        lista1 = IngresarInfoLista(nroarray);
        /*
        for (int i = 0; i < lista1.size(); i++){
            System.out.println("ID: " + lista1.get(i).getId());
            System.out.println("Nombre: " + lista1.get(i).getNombre());
            System.out.println("Valor: " + lista1.get(i).getValorSubsidio());
        }
        */

        //Ingresar Informacion al lista2
        nroarray= 2;
        lista2 = IngresarInfoLista(nroarray);
        /*
        for (int i = 0; i < lista2.size(); i++){
            System.out.println("ID: " +lista2.get(i).getId());
            System.out.println("Nombre: " +lista2.get(i).getNombre());
            System.out.println("Valor: " +lista2.get(i).getValorSubsidio());
        }
        */

        //Comparar y mostra comparacion entre lista
        getMejorbeneficios(lista1,lista2);

    }

    //** Metodo para cargar informacion a las listas
    public static ArrayList IngresarInfoLista(int posarray){

        // Definir  objeto de la clase constanste para mensajes
        Constantes constantes = new Constantes();

        // Definir  Array del objeto de la clase BeneficiosCovid
        ArrayList <BeneficiosCovid19> arrayBeneficios = new ArrayList <BeneficiosCovid19>();

        System.out.println("Por favor ingresar Subsidios para la lista Nro: " + posarray);

        // Variables de trabajo
        String tipoDato = "";
        String info = "";
        String idrandom;
        String continuar = constantes.TXT_SI;
        //iniciar Ciclo para cargar informacion
        //while (continuar.equals("SI")){

            //Definir Objeto de la clase BeneficiosCovid
            BeneficiosCovid19 beneficios_Covid = new BeneficiosCovid19();

            //Ingresar Nombre Tipo Alfa
            tipoDato = "A";
            info = validarinfo(constantes.TXT_Inp_Nombre,tipoDato);
            beneficios_Covid.setNombre(info);

            //Ingresar Valor Subsidio Tipo Numerico
            tipoDato = "N";
            info = validarinfo(constantes.TXT_Inp_Subsidio,tipoDato);
            beneficios_Covid.setValorSubsidio(Float.parseFloat(info));

            //Obtener el ID de manera aleatoria
            idrandom = getIdBeneficio();
            beneficios_Covid.setId(idrandom);

            arrayBeneficios.add(beneficios_Covid);

            /**
             * Validacion para continuar o finalizar el ciclo
             * principaly finalizar Main de manera controlada
             * por consola
              **/

        /*  tipoDato = "A";
            continuar = validarinfo(constantes.TXT_Msg_Continuar,tipoDato);
            // Validar valor ingrsado para continuar o finalizar aplicación
            while ( !continuar.equals("SI") && !continuar.equals("NO")) {
                continuar = validarinfo(constantes.TXT_Msg_Continuar, tipoDato);
            }

        }
        */
         return arrayBeneficios;
    }

    /**
    Procedimiento para Validar la informacion ingresada
    **/
    public static String validarinfo(String message, String tipo) {

        //Variable para capturar Info por consola
        String infoval;

        Scanner in = new Scanner(System.in);

        System.out.println(message);
        infoval = in.nextLine();

        switch (tipo){
            case "N":
                while (!isNumeric(infoval)) {
                    System.out.println(message);
                    infoval = in.nextLine();
                }
                break;

            case "A":
               break;
        }
        return infoval;
    }

    /**
     Procedimiento para Validar si la informacion ingreda es numerica
     **/
    public static boolean isNumeric(String value) {
        // Procedimiento para monitorear e informar sobre la excepcion
        try {
            //Se realiza  asignacion de dato numerico
            Float.parseFloat(value);
            return true;

        }
        //Mostrar mensaje de error
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null,Constantes.TXT_Msg_Error,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

            return false;

        }

    }

    /**
     * Implementa un metodo que te entregue un numero aletorio para el ide de los
     * beneficios usar el wrapper de Integer
    **/
    public static String getIdBeneficio(){
        //La Clase Math tiene varios metodos que te ayudaran
        //Escoger numero aleatorio entre 100000 y 1
        int idrandom1 = (int) (Math.random() * 1000000 + 1);

        String idrandom = Integer.toString(idrandom1);

        return idrandom;
    }


    /**
     * Implementa un metodo que entregue un reporte de comparacion de las 2 listas este metodo
     * solo imprimira regiostros
     * Cuando un metodo no retorna un tipo de datos se trabaja con la palabra clave VOID
     * Abarcar los operadores terniarios para condiciones logicas
     * Operadores logicos
     * Operacionres aritmeticos
     **/
    public static void getMejorbeneficios(ArrayList<BeneficiosCovid19> lista1, ArrayList<BeneficiosCovid19> lista2){

        // obetjo de la clase BeneficiosCovid19 para almacenar los datos mayores
        BeneficiosCovid19 beneficiosMayores = new BeneficiosCovid19();

        //Variable para implementar el Wrapper del objeto tipo Float
        float valor = 0;

        //Almacenamos valor = 0
        beneficiosMayores.setValorSubsidio(valor);

        // Ciclo para obtener el subsidio mayor
        for (int i = 0;i< lista1.size();i++) {
            BeneficiosCovid19 auxiliarCovid = lista1.get(i);

            if (auxiliarCovid.getValorSubsidio() > beneficiosMayores.getValorSubsidio()){
                beneficiosMayores = auxiliarCovid;
            }
        }

        // Ciclo para obtener el ID mayor
        for (int i = 0;i< lista2.size();i++) {
            BeneficiosCovid19 auxiliarCovid2 = lista2.get(i);
            if (auxiliarCovid2.getValorSubsidio() > beneficiosMayores.getValorSubsidio()){
                beneficiosMayores = auxiliarCovid2;
            }
        }

        // Mostra resultado de las busquedas
        System.out.println("El id del subsidio mayor es:  " + beneficiosMayores.getId());
        System.out.println("El nombre subsidio mayor es:  " + beneficiosMayores.getNombre());
        System.out.println("El valor  subsidio mayor es:  " + beneficiosMayores.getValorSubsidio());

    }


} // Fin Class Main