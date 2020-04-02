
How to compile and execute: 
 - compile: javac [allfiles]
 - execute: java PlayGame

Class Usabilities: 
 - Property: a super class contains all things in market. (Weapon, armor, spell, potion) 
 - Cell has three subclasses including(Common, NoAccess, Market)
 - PlayGame: a class that could play any game
 - Setting: an interface contains all default values
 - HeroTeam: a class represent team of heroes
 - FightRound: a class represent the fight of a hero and a monster


Clarifications: 

(a) The Fight: 
 - In my game, if all heroes dead, the game ends automatically because there    is no one can revive them 
 - When hero has an empty inventory, or only have armors, they can't have any damage to monsters; Then, When hero chooses regular attack, but do not have have a weapon, they have the choice to do the decision again. 

(b)The Quest board 
- the cells in board is assigned randomly, except for (0,0) is set to be a common cell, and (0,1) is set to be a market. So can making sure that player can have chance to buy some weapon before go to fight and die quickly, it can also making sure player start the game with a position where the adjacent cells are NON-ACCESS

(c)Potion: 
 - my implementation of attribute increase is ask user to choose the attribute they want to increase. Since every potion has different level, however choosing increase which of the attributes should not decided by player's level.





