package adat.ud1.examen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

/**
 * @author Samuel
 */

public class LeerEmpleadosXml {
    public static void main(String[] args) {
        String fichero = "DATOS\\Empleados.xml";
        leerEmpleados(fichero);
    }

    public static List<Empleado> leerEmpleados(String fichero) {
        List<Empleado> listaEmpleados = new ArrayList<>();

        try {
            JAXBContext contexto = JAXBContext.newInstance(Empleado.class);//TODO cambiar por nodelist

            Unmarshaller unmarshaller = contexto.createUnmarshaller();

            Empleado empleado = (Empleado) unmarshaller.unmarshal(new File(fichero));

            System.out.println(empleado);
            listaEmpleados.add((Empleado) unmarshaller.unmarshal(new File(fichero)));
        } catch (JAXBException e) {
            System.out.println("Error JAXB" + e.getMessage());
        }

        return listaEmpleados;

        /*
         * DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         * DocumentBuilder builder = null;
         * try {
         * builder = factory.newDocumentBuilder();
         * } catch (ParserConfigurationException e) {
         * System.out.println("Error en el pareso " + e.getMessage());
         * }
         * // Leer XML
         * Document documento = null;
         * try {
         * documento = builder.parse(new File("DATOS\\Empleados.xml"));
         * } catch (SAXException | IOException e) {
         * System.out.println("Se ha producido un error " + e.getMessage());
         * }
         * 
         * Element empleados = documento.getDocumentElement();
         * 
         * NodeList lista = empleados.getChildNodes();
         * 
         * return null;
         * }
         */
    }
}
