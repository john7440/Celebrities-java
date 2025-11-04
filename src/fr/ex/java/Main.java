package fr.ex.java;
import java.util.*;


public class Main {

	public static void main(String[] args) {
		
		// noms des invités
        Map<Integer, String> guestNames = new HashMap<>();
        guestNames.put(1, "Albert");
        guestNames.put(2, "Bénédicte");
        guestNames.put(3, "Christophe");
        guestNames.put(4, "Delphine");
        guestNames.put(5, "Edouard");
        guestNames.put(6, "Françoise");
        guestNames.put(7, "Gaston");
        guestNames.put(8, "Héloïse");

        // connaissances des autres invités
        Map<Integer, List<Integer>> knownGuests = new HashMap<>();
        knownGuests.put(1, Arrays.asList(2, 5, 6));
        knownGuests.put(2, Arrays.asList(3, 5, 6));
        knownGuests.put(3, Arrays.asList(2, 4, 5, 6));
        knownGuests.put(4, Arrays.asList(1, 2, 5, 6, 8));
        knownGuests.put(5, Arrays.asList(6));
        knownGuests.put(6, Arrays.asList(5));
        knownGuests.put(7, Arrays.asList(2, 3, 5, 6, 8));
        knownGuests.put(5, Arrays.asList(2, 4, 5, 6 , 7));
	}

}
