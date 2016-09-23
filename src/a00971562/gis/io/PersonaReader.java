/**
 * Project: A00971562Gis
 * File: PersonaReader.java
 * Date: Jun 17, 2016
 * Time: 8:54:41 PM
 */
package a00971562.gis.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import a00971562.gis.ApplicationException;
import a00971562.gis.data.Persona;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class PersonaReader {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private PersonaReader() {

	}

	/**
	 * Reads the persona input data.
	 * 
	 * @param personaData
	 *            the input data
	 * @return a list of personas
	 * @throws ApplicationException
	 * @throws IOException
	 */
	public static List<Persona> read(File personaData) throws ApplicationException, IOException {
		Scanner scan = new Scanner(personaData);
		List<Persona> personas = new ArrayList<Persona>();
		try {
			if (scan.hasNext())
				scan.nextLine();
			while (scan.hasNext()) {
				String row = scan.nextLine();
				List<String> elements = Arrays.asList(row.split("\\|"));
				if (elements.size() != 4)
					throw new ApplicationException("Missing element. Expected 4 elements from 'personas.dat' but got " + elements.size());
				Persona persona = new Persona();
				int index = 0;
				persona.setId(Integer.parseInt(elements.get(index++)));
				persona.setPlayerId(Integer.parseInt(elements.get(index++)));
				persona.setGamerTag(elements.get(index++));
				persona.setPlatform(elements.get(index++));
				personas.add(persona);
			}
		} finally {
			scan.close();
		}

		return personas;
	}
}
