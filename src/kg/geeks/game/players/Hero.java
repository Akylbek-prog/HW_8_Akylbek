package kg.geeks.game.players;

public abstract class Hero extends GameEntity {
    private SuperAbility ability;

    public Hero(String name, int health, int damage, SuperAbility ability) {
        super(name, health, damage);
        this.ability = ability;
    }

    public SuperAbility getAbility() {
        return ability;
    }

    public void attack(Boss boss) {
        if (this.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - this.getDamage());
        }
    }

    // Обновим метод атаки, чтобы учитывать "мертвое" состояние
    public abstract void applySuperPower(Boss boss, Hero[] heroes);

    // Проверка, чтобы герой не мог быть атакован, если он притворяется мертвым
    public boolean canAttack() {
        return !(this instanceof TrickyBastard && ((TrickyBastard) this).isFakedDeath());
    }
}
