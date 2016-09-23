/**
 * Project: A00971562Gis
 * File: ComparePersonaWithGame.java
 * Date: Jun 18, 2016
 * Time: 12:04:48 AM
 */
package a00971562.gis.util;

import java.util.List;

import a00971562.gis.data.Persona;
import a00971562.gis.data.Score;

/**
 * @author Rei Ruiz, A00971562
 *
 */
public class ComparePersonaWithScore {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ComparePersonaWithScore() {

	}

	/**
	 * Compares a persona's id with the score's persona id.
	 * 
	 * @param persona
	 *            a persona object
	 * @param score
	 *            a score object
	 * @return an integer
	 */
	private static int compareId(Persona persona, Score score) {
		return persona.getId() - score.getPersonaId();
	}

	/**
	 * Assigns the fields of a persona to a score.
	 * 
	 * @param persona
	 *            a persona object
	 * @param score
	 *            a score object
	 */
	private static void assign(Persona persona, Score score) {
		score.setFirstName(persona.getFirstName());
		score.setLastName(persona.getLastName());
		score.setEmailAddress(persona.getEmailAddress());
		score.setBirthDate(persona.getBirthDate());
		score.setPersonaId(persona.getId());
		score.setPlayerId(persona.getPlayerId());
		score.setGamerTag(persona.getGamerTag());
		score.setPlatform(persona.getPlatform());
	}

	/**
	 * Scans through a list of personas and scores to identify identical personas and scores.
	 * 
	 * @param personaList
	 *            a list of personas
	 * @param scoreList
	 *            a list of scores
	 */
	public static void assignField(List<Persona> personaList, List<Score> scoreList) {
		for (int i = 0; i < personaList.size(); i++) {
			for (int j = 0; j < scoreList.size(); j++) {
				if (compareId(personaList.get(i), scoreList.get(j)) == 0)
					assign(personaList.get(i), scoreList.get(j));
			}
		}
	}

}
