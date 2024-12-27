package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Druid extends Hero {
    private boolean usedSummon = false;
    private int bossInitialHealth = -1;

    public Druid(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.HEAL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (bossInitialHealth == -1) {
            bossInitialHealth = boss.getHealth(); // Сохраняем изначальное здоровье босса
        }

        if (!usedSummon) {
            usedSummon = true;
            boolean summonAngel = RPG_Game.random.nextBoolean();

            if (summonAngel) {
                System.out.println("Druid summoned an Angel!");
                boolean medicFound = false;
                for (Hero hero : heroes) {
                    if (hero instanceof Medic) {
                        ((Medic) hero).increaseHealPoints(10);
                        medicFound = true;
                    }
                }
                if (!medicFound) {
                    System.out.println("But there is no Medic to boost!");
                }
            } else {
                System.out.println("Druid summoned a Crow!");
                if (boss.getHealth() < bossInitialHealth / 2) {
                    boss.setDamage(boss.getDamage() + 15); // Увеличение урона фиксированным значением
                    System.out.println("The Crow made the boss more aggressive! Boss damage increased to: " + boss.getDamage());
                } else {
                    System.out.println("The boss is too healthy for the Crow to take effect.");
                }
            }
        }
    }
}
