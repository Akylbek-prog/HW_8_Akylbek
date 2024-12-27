package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Magic extends Hero {
    public Magic(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRoundNumber() <= 4) {
            int boostAmount = 5; // Увеличение атаки на 5 единиц
            for (Hero hero : heroes) {
                if (hero.getHealth() > 0 && hero != this) {
                    hero.setDamage(hero.getDamage() + boostAmount);
                }
            }
            System.out.println("Magic boosted heroes' attack by " + boostAmount);
        }
    }
}
