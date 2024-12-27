package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Avrora extends Hero {
    private boolean usedInvisibility = false;
    private int damageStoredDuringInvisibility = 0;

    public Avrora(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        // Вход в невидимость
        if (!usedInvisibility && RPG_Game.getRoundNumber() == 2) {
            usedInvisibility = true;
            damageStoredDuringInvisibility = 0; // Сбрасываем накопленный урон
            System.out.println(this.getName() + " entered invisibility mode!");
        }
        // Возвращение накопленного урона после выхода из невидимости
        else if (usedInvisibility && RPG_Game.getRoundNumber() == 3) {
            boss.setHealth(boss.getHealth() - damageStoredDuringInvisibility);
            System.out.println(this.getName() + " returned " + damageStoredDuringInvisibility + " damage to the boss!");
            damageStoredDuringInvisibility = 0; // Урон возвращён
        }
    }

    // Проверка, находится ли Аврора в режиме невидимости
    public boolean isInvisible() {
        return usedInvisibility && RPG_Game.getRoundNumber() == 2;
    }

    // Метод для накопления урона, полученного во время невидимости
    public void storeDamage(int damage) {
        damageStoredDuringInvisibility += damage;
    }
}
