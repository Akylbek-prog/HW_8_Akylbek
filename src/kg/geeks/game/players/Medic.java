package kg.geeks.game.players;

public class Medic extends Hero {
    private int healPoints;

    public Medic(String name, int health, int damage, int healPoints) {
        super(name, health, damage, SuperAbility.HEAL);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && hero != this) {
                hero.setHealth(hero.getHealth() + healPoints);
            }
        }
    }

    // Новый метод, который увеличивает лечащие очки
    public void increaseHealPoints(int points) {
        this.healPoints += points;
        System.out.println("Medic's heal points increased by " + points + " to: " + this.healPoints);
    }
}
