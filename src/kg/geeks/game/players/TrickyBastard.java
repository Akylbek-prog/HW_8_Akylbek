package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class TrickyBastard extends Hero {
    private boolean fakedDeath = false;

    public TrickyBastard(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!fakedDeath && RPG_Game.random.nextInt(3) == 0) {
            fakedDeath = true;
            System.out.println("TrickyBastard faked his death!");
            this.setHealth(0); // Притворяется мертвым
        } else if (fakedDeath) {
            // Возвращение к жизни с восстановлением части здоровья
            fakedDeath = false;
            int restoredHealth = this.getHealth() / 2; // Восстановление половины здоровья
            this.setHealth(this.getHealth() + restoredHealth);
            System.out.println("TrickyBastard returned to the fight with " + restoredHealth + " health restored!");
        }
    }

    public boolean isFakedDeath() {
        return fakedDeath;
    }

    @Override
    public void attack(Boss boss) {
        if (!fakedDeath) {  // Он не может атаковать, когда притворяется мертвым
            super.attack(boss);
        } else {
            System.out.println("TrickyBastard is pretending to be dead and cannot attack.");
        }
    }
}
