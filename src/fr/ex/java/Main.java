package fr.ex.java;
import java.util.*;


public class Main {
	
	// This method find guests who are known by every other guests
	// so they are a potential celebrities
	public static Set<Integer> findKnownByEveryone(Map<Integer, String> guestNames , Map<Integer, List<Integer>> knownGuests){
		
		// We initialize our set to stock potentialCelebrities (known by all)
		Set<Integer> potentialCelebrities = new HashSet<>();
		
		// We check for each guest 
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
		
		// Our guests list with their id and names
        Map<Integer, String> guestNames = new HashMap<>();
        guestNames.put(1, "Albert");
        guestNames.put(2, "Bénédicte");
        guestNames.put(3, "Christophe");
        guestNames.put(4, "Delphine");
        guestNames.put(5, "Edouard");
        guestNames.put(6, "Françoise");
        guestNames.put(7, "Gaston");
        guestNames.put(8, "Héloïse");

        // Id and known guests 
        Map<Integer, List<Integer>> knownGuests = new HashMap<>();
        knownGuests.put(1, Arrays.asList(2, 5, 6));
        knownGuests.put(2, Arrays.asList(3, 5, 6));
        knownGuests.put(3, Arrays.asList(2, 4, 5, 6));
        knownGuests.put(4, Arrays.asList(1, 2, 5, 6, 8));
        knownGuests.put(5, Arrays.asList(6));
        knownGuests.put(6, Arrays.asList(5));
        knownGuests.put(7, Arrays.asList(2, 3, 5, 6, 8));
        knownGuests.put(8, Arrays.asList(2, 4, 5, 6 , 7));
        
        // We find every guest who is known by everyone
        Set<Integer> knownByEveryone = findKnownByEveryone(guestNames, knownGuests);
        
        // Then we filter if they known other celebrities
        Set<Integer> validatedCelebrities = filteringCelebrities(knownByEveryone, knownGuests);
        
        // Final display
        System.out.println("==============================");
        System.out.println("Célébrités identifiées :\n");
        for (Integer id : validatedCelebrities) {
            System.out.println("- " + guestNames.get(id));
        }
        System.out.println("==============================");
	}

}
