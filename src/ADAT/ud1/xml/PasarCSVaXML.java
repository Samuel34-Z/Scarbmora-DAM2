package ADAT.ud1.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/*
    CSV se encarga de registrar faltas de asistencia de alumnos del centro
    Lee CSV y en base a eso
    Genera XML que muestra faltas sin justificar de alumnado de un cliclo (DAM2)

    Necesario pensar en la eficiencia de cara a un uso bastante amplio
*/

public class PasarCSVaXML {
    public static void main(String[] args) {

        DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder constructor = fabrica.newDocumentBuilder();

            Document documento = constructor.newDocument();

            Element alumno = documento.createElement("Alumno");

            documento.appendChild(alumno);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
