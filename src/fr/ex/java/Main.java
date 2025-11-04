package fr.ex.java;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		
		// le nom des invité lié a un numéro d'invité
		Map<Integer, String> guestNames = Map.of(
				1, "Albert",
				2, "Bénédicte",
				3, "Christophe",
				4, "Delphine",
				5, "Edouard",
				6, "Françoise",
				7, "Gaston",
				8, "Héloïse"
			);

		// les relations entre les invités
		Map<Integer, List<Integer>> knownGuest = Map.of(
				1, Arrays.asList(2, 5, 6),
				2, Arrays.asList(3, 5, 6),
				3, Arrays.asList(2, 4, 5, 6),
				4, Arrays.asList(1, 2, 5, 6, 8),
				5, Arrays.asList(6),
				6, Arrays.asList(5),
				7, Arrays.asList(2, 3, 5, 6, 8),
				8, Arrays.asList(2, 4, 5, 6, 7)
			);
		
		
	}

}
