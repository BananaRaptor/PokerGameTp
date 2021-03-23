# Liste de Patron de conception :

## Factory
![Factory](https://refactoring.guru/images/patterns/content/factory-method/factory-method-en-2x.png)

En premier lieu, pour initialiser mes différentes types de jeux de poker (Texas, Limit, etc). J'ai utiliser une factory qui instancie une sous-classe de PokerGame basée selon le paramètre à la fonction de la factory. Il permet par le fait même d'ajouter facilement d'autres types de jeux.

## Strategy
![Strategy](https://refactoring.guru/images/patterns/content/strategy/strategy-2x.png)

Par la suite, j'ai utilisé le patron de la strategy pour permettre l'interaction de plusieurs facon avec un deck deck tout en utilisant des fonctions communes. Exemple si un jeu devais s'instancier avec 2 paquets de carte au lieu d'un, ou bien qu'il doit utiliser un technique de brassage particulière. La deck strategy permet que des algorithmes different puisse être effectué sur le même objet.

## Template Method
![TemplateMethod](https://refactoring.guru/images/patterns/content/template-method/template-method-2x.png)

Pour continuer, le patron du Template Method est utilisé par la mainGameLogic dans le PokerGame qui défini cette fonction comme abstraite. Ce qui permet au type de jeu de modifier cette méthode ! De plus, les différentes méthodes essentielles (Ex. Trouver un gagnant, passer des cartes) sont attribué à des méthodes abstraites que les différents jeux doivent implémenter et peuvent être exécuté dans des ordres différents dans le mainGameLogic.

## Chain of Responsibility
![ChainOfResponsabilty](https://refactoring.guru/images/patterns/content/chain-of-responsibility/chain-of-responsibility-2x.png)

Pour conclure, la chaîne de responsabilité fut utilisé au niveau de la vérification des mains. Elle retourne une WinCondition qui inclus une chaine de caractères et un entier.
#### Réflexion
Je crois que de l'utiliser dans ce context est judicieux car il permet à la chaine d'immédiatement se briser si l'on découvre la main la plus haute du joueur. En effet, si l'on compose la chaine correctement (Main la plus forte au début et descendant de facon décroissante) on peut s'assurer que la main la plus forte du joueur est toujours celle qui est évaluée.