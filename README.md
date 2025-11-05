# 🎉 Système de détection de Célébrités dans une Liste d'Invités

Ce projet Java permet d’identifier les célébrités parmi un groupe d’invités, en se basant sur deux critères :
1. Une célébrité est connue par tous les autres invités
2. Une célébrité ne connait que d'autres célébrités
---
### 📁 Méthodes clés :
- **findKnownByEveryone()** : identifie les invités connus par tous les autres
- **filteringCelebrities()** : filtre les candidats pour ne garder que ceux qui ne connaissent que d'autres célébrités
---
### 🧠 Logique du programme
1. **findKnownByEveryone()** :
   Avec cette méthodeon parcourt tous les invités et vérifie pour chacun s’il est connu par tous les autres. Si c’est le cas, il est ajouté à la liste des célébrités potentielles.
2. **filteringCelebrities()** :
   Cette méthode prend les célébrités potentielles et élimine celles qui connaissent des personnes lambda. Elle répète ce filtrage jusqu’à la stabilisation de la liste des célébrités.
3. **main()** :
   - On initialise les invités avec leurs noms et les relations de connaissance
   - On identifie les célébrités potentielles
   - On applique ensuite le filtrage final
   - Affiche les célébrités trouvées ou un message si aucune n'a été trouvée
---
### 🚀 Pour exécuter le projet
1. Compiler le fichier:

         javac Main.java
2. Lancer le programme:

         java fr.ex.java.Main
  
