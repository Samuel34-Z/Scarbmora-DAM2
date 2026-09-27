package ADAT.ud1.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExportarImportarXML2 {
    public static void main(String[] args) {
        boolean continuar = true;
        List<Persona> lista = new ArrayList<>();

        while (continuar) {
            Scanner sc = new Scanner(System.in);
            System.out.println("===============");
            System.out.println("1. Añadir persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Buscar persona ");
            System.out.println("4. Importar/Exportar XML");
            System.out.println("5. Salir \n");
            System.out.print("Que desea hacer?: ");
            int eleccion = sc.nextInt();
            sc.nextLine();

            switch (eleccion) {
                case 1:
                    System.out.println();
                    System.out.print("Introduce su nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Introduce su edad: ");
                    int edad = sc.nextInt();

                    lista.add(new Persona(nombre, edad));

                    break;
                case 2:
                    System.out.println();
                    for (Persona persona : lista) {
                        System.out.println(persona.toString());
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.println("1. Filtrar por nombre");
                    System.out.println("2. Filtrar por edad");
                    System.out.print("Que desea hacer?: ");
                    eleccion = sc.nextInt();
                    sc.nextLine();

                    switch (eleccion) {
                        case 1:
                            System.out.print("Introduce el nombre: ");
                            nombre = sc.nextLine();

                            for (Persona persona : lista) {
                                if (persona.nombre.equals(nombre)) {
                                    System.out.println(persona.toString());
                                }
                            }
                            break;

                        case 2:
                            System.out.print("Introduce la edad: ");
                            edad = sc.nextInt();

                            for (Persona persona : lista) {
                                if (persona.edad == edad) {
                                    System.out.println(persona.toString());
                                }
                            }

                            break;
                        default:
                            System.out.println("Esa selección no es válida");
                            break;
                    }
                    break;
                case 4:
                    File archivo = new File("persona.xml");
                    System.out.println();
                    System.out.println("1. Importar lista desde XML");
                    System.out.println("2. Exportar lista a XML");
                    System.out.print("Que desea hacer?: ");
                    eleccion = sc.nextInt();
                    sc.nextLine();
                    switch (eleccion) {
                        case 1:
                            try (XMLDecoder in = new XMLDecoder(
                                    new BufferedInputStream(new FileInputStream(archivo)))) {
                                lista.addAll((List<Persona>) in.readObject());

                            } catch (Exception e) {
                                System.out.println("Se ha producido un error" + e.getMessage());
                            }
                            break;
                        case 2:
                            try (XMLEncoder out = new XMLEncoder(
                                    new BufferedOutputStream(new FileOutputStream(archivo)))) {

                                out.writeObject(lista);

                            } catch (Exception e) {
                                // TODO: handle exception
                            }
                            break;
                        default:
                            System.out.println("Esa selección no es válida");
                            break;
                    }

                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    continuar = false;
                    sc.close();
                    break;

                default:
                    System.out.println("Esa selección no es válida");
                    break;
            }
        }
    }
}
