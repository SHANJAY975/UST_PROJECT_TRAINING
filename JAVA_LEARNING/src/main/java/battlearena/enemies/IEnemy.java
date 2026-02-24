package battlearena.enemies;

public interface IEnemy {

    void talk();
    void attack();
    void specialAttack();
    int getHealthPoints();
    int getHealthPointsRemaining();
    void setHealthPointsRemaining(int healthPointsRemaining);
    int getAttackDamage();
    void setAttackDamage(int attackDamage);
    int getId();
}
