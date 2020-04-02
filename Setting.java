import java.util.*;

public interface Setting{
    Warrior Gaerdal_Ironhand = new Warrior("Gaerdal_Ironhand", 100, 700, 500, 600, 1354, 7);
    Warrior Sehanine_Monnbow = new Warrior("Sehanine_Monnbow", 600, 700 , 800, 500, 2500, 8);
    Warrior Muamman_Duathall = new Warrior("Muamman_Duathall", 300, 900, 500, 750, 2546, 6);
    Warrior Flandal_Steelskin = new Warrior("Flandal_Steelski", 200, 750, 650, 700, 2500, 7);
    Weapon sword = new Weapon("Sword",500, 1,800,1);
    Armor Platinum_Shield = new Armor("Platinum_Shield",150, 1,200);
    
    Sorcerer Garl_Glittergold = new Sorcerer("Garl_Glittergold", 700, 550, 600, 500, 2500, 7);
    Sorcerer Rillifane_Rallathil = new Sorcerer("Rillifane_Rallat", 1300, 750, 450, 500, 2500, 9);
    Sorcerer Segojan_Earthcaller = new Sorcerer("Segojan_Earthcal", 900, 800, 500, 650, 2500, 5);
    Sorcerer Skoraeus_Stonebones = new Sorcerer("Skoraeus_Stonebo", 800, 850, 600, 450, 2500, 6);
    
    Paladin Solonor_Thelandira = new Paladin("Solonor_Theland", 300, 750, 650, 700, 2500, 7);
    Paladin Sehanine_Moonbow = new Paladin("Sehanine_Moonbo", 300, 750, 700, 700, 2500, 7);
    Paladin Nora_Wang = new Paladin("Nora_Wang123456", 250, 650, 600, 350, 2500, 4);
    Paladin Jackson_Wang = new Paladin("Jackson_Wang123", 100, 600, 500, 400, 2500, 5);
    
    
    ArrayList<Warrior> warriors=new ArrayList<Warrior>(Arrays.asList(Gaerdal_Ironhand, Sehanine_Monnbow, Muamman_Duathall,Flandal_Steelskin ));
    ArrayList<Sorcerer> sorcerers =new ArrayList<Sorcerer>(Arrays.asList(Garl_Glittergold, Rillifane_Rallathil, Segojan_Earthcaller, Skoraeus_Stonebones ));;
    ArrayList<Paladin> paladins=new ArrayList<Paladin>(Arrays.asList(Solonor_Thelandira, Sehanine_Moonbow, Nora_Wang, Jackson_Wang));;
    //ArrayList<T> defaultHeroes= new ArrayList<T>(Arrays.asList(warriors,sorcerers, paladins));
    
    
    List<String> heroNames = Arrays.asList(
                                           "Gaerdal_Ironhand", "Sehanine_Monnbow", "Muamman_Duathall", "Flandal_Steelski", 
                                           "Garl_Glittergold", "Rillifane_Rallat", "Segojan_Earthcal", "Skoraeus_Stonebo",
                                           "Solonor_Theland","Sehanine_Moonbo", "Nora_Wang123456", "Jackson_Wang123"
    
    ); 
    
    
    
    Object[][] iceSpell = {new Object[] {"Number", "Name", "Cost", "Level","damage","mana cost" },
        new Object[] {"1", "Snow_Canon",500, 2,650,250},
        new Object[] {"2", "Ice_Blade",250, 1,450,100 },
        new Object[] {"3", "Frost_Blizzard",750, 5,850,350 },
        new Object[] {"4", "Arctic_storm",700, 6,800,300 }
    };
    
    Object[][] fireSpell = {new Object[] {"Number", "Name", "Cost", "Level","damage","mana cost" },
     new Object[] {"5", "Flame_Tornado",700, 4,850,300},
     new Object[] {"6","Breath_of_Fire",350, 1,450,100 },
     new Object[] {"7","Heat_Wave",450, 2,600,150 },
     new Object[] {"8","Lava_Commet",800, 7,1000,550 }};
    
    Object[][] lighteningSpell = { new Object[] {"Number", "Name", "Cost", "Level","damage","mana cost" },
        new Object[] {"9", "LightningDagger",400, 1,500,150},
        new Object[] {"10", "Thunder_Blast",750, 4,950,400 },
        new Object[] {"11", "Electric_Arrows",550, 5,650,200 },
        new Object[] {"12", "Spark_Needles",500, 2,600,200 }
    };
            
    final Object[][] weapon = {new Object[] {"Number", "Name", "Cost", "Level","damage","required hands" },
        new Object[] {"1", "Sword",500, 1,800,1},
         new Object[] {"2", "Bow",300, 2,500,2 },
        new Object[] {"3", "Scythe",1000, 6,1100,2 },
        new Object[] {"4", "Axe ",550, 5,850,1 },
        new Object[] {"5", "Shield",400, 1,100,1 },
        new Object[] {"6", "TSwords ",1400, 8,1600,2 },
         new Object[] {"7", "Dagger",200, 1,250,1 }
    };
    final Object[][] armor = {
        new Object[] {"Number", "Name", "Cost", "Level","damage reduction" },
        new Object[] {"8","Platinum_Shield",150, 1,200},
        new Object[] {"9", "Breastplate",350, 3,600},
        new Object[] {"10", "Full_Body_Armor",1000, 8,1100 },
        new Object[] {"11", "Wizard_Shield",1200, 10,1500 },
        new Object[] {"12", "Speed_Boots",550, 4,600 }
    };
    final Object[][] potion = {
        new Object[] { "Number", "Name", "Cost", "Level","attribute increase" },
        new Object[] {"13", "Healing_Potion",250, 1,100},
        new Object[] {"14", "Strength_Potion",200, 1,75},
        new Object[] {"15", "Magic_Potion",350, 2,100 },
        new Object[] {"16", "Luck_Elixir",500, 4,65 },
        new Object[] {"17", "Mermaid_Tears",850, 5,100 },
        new Object[] {"18","Ambrosia",1000, 8,150 }
    };  

    
    ArrayList<Monster> monsters = new ArrayList<Monster>(Arrays.asList(
                                                                       new Dragon("Desghidorrah",3,300,400, 35),
                                                                       new Dragon ("Chrysophylax", 2, 200, 100, 20),
                                                                       new Dragon ("BunsenBurner", 4, 400, 500, 45),
                                                                       new Dragon ("Natsunomeryu", 1, 100, 100, 10),
                                                                       new Dragon ("TheScaleless", 7, 700, 600, 75),
                                                                       new Dragon ("Kas-Ethelinh", 5, 600, 500, 60),
                                                                       new Dragon ("Alexstraszan", 10, 1000, 9000, 55),
                                                                       new Dragon ("Phaarthurnax", 6, 600, 700, 60),
                                                                       new Dragon ("D-Maleficent", 9, 900, 950, 85),
                                                                       new Dragon ("TheWeatherbe", 8, 800, 900, 80),
                                                                       
                                                                       new Exoskeleton("Cyrrollalee", 7,700, 800, 75),
                                                                       new Exoskeleton("Brandobaris", 3, 350, 450, 30 ),
                                                                       new Exoskeleton("BigBad-Wolf", 1, 150, 50, 15),
                                                                       new Exoskeleton("WickedWitch", 2, 250, 150, 25),
                                                                       new Exoskeleton("Aasterinian", 4, 400, 500, 45),
                                                                       new Exoskeleton("Chronepsish", 6, 650, 750, 60),
                                                                       new Exoskeleton("Kiaransalee", 8, 850, 950, 85),
                                                                       new Exoskeleton("St-Shargaas", 5, 550, 650, 55 ),
                                                                       new Exoskeleton("Merrshaullk", 10, 1000, 900, 55),
                                                                       new Exoskeleton("St-Yeenoghu", 9, 950, 850, 90),
                                                                       
                                                                       new Spirit("Andrealphus",2,600, 200, 40),
                                                                       new Spirit("Aim-Haborym", 1, 450, 50, 35),
                                                                       new Spirit("Andromalius", 3, 550, 450, 25),
                                                                       new Spirit("Chiang-shih", 4, 700, 600, 40 ),
                                                                       new Spirit("FallenAngel", 5, 800, 700, 50),
                                                                       new Spirit("Ereshkigall", 6 , 950, 450, 35 ),
                                                                       new Spirit( "Melchiresas", 7, 350, 150, 75  ),
                                                                       new Spirit("Jormunngand", 8, 600, 900, 20 ),
                                                                       new Spirit("Rakkshasass", 9, 550, 600, 35 ),
                                                                       new Spirit( "Taltecuhtli", 10, 300, 200, 50)
                                                                       
                                                                       
                                                                       
    ));
    
     //System.out.println(monsters.size());

    
    
    
    
    
    
    
    
    
    
    
    
} 