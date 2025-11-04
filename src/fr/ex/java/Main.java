package fr.ex.java;
import java.util.*;


public class Main {
	
	// On cherche qui est connu de tout le monde
	public static Set<Integer> findKnownByEveryone(Map<Integer, String> guestNames , Map<Integer, List<Integer>> knownGuests){
		// le set pour stocker les invité connu de tous
		Set<Integer> potentialCelebrities = new HashSet<>();
		
		for (Integer guestId : guestNames.keySet()) {
			boolean knownByAll = true;
			
			for (Integer otherGuestId: guestNames.keySet()) {
				
				if (!otherGuestId.equals(guestId)) {
					List<Integer> known = knownGuests.get(otherGuestId);
					
					if (known == null || !known.contains(guestId)) {
						knownByAll = false;
						break;
					}
				}
			}
			if (knownByAll) {
				potentialCelebrities.add(guestId);
			}
		}
		return potentialCelebrities;
	}
	
	public static Set<Integer> filteringCelebrities(Set<Integer> candidates, Map<Integer, List<Integer>> knownGuests){
		
		Set<Integer> result = new HashSet<>();
		
		for (Integer candidateId: candidates) {
			List<Integer> knownByCandidate = knownGuests.get(candidateId);
			boolean onlyKnownCelebrities = true;
			
			if (knownByCandidate != null) {
				
				for (Integer knownId: knownByCandidate) {
					
					if (!candidates.contains(knownId)) {
						onlyKnownCelebrities = false;
						break;
					}
				}
			}
			if (onlyKnownCelebrities) {
				result.add(candidateId);
			}
		}
		return result;
		
	}

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
        knownGuests.put(8, Arrays.asList(2, 4, 5, 6 , 7));
        
        Set<Integer> knownByEveryone = findKnownByEveryone(guestNames, knownGuests);
        
        Set<Integer> validatedCelebrities = filteringCelebrities(knownByEveryone, knownGuests);
        
        System.out.println(validatedCelebrities);
	}

}
