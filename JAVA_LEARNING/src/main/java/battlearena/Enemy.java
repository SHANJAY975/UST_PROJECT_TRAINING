package battlearena;

public class Enemy {
    private  int id;
    private int healthPoints ;
    private int attackDamage;
    private static  int numberOfEnemies;

    public Enemy(){
        System.out.println("Enemy is Created");
    }

    public Enemy( int healthPoints, int attackDamage){
        this.healthPoints = healthPoints;
        this.attackDamage = attackDamage;
        numberOfEnemies++;
        this.id = numberOfEnemies;
    }

    public void talk(){
        System.out.println("I am a enemy be prepared to flight!");
    }
    public void walkForward(){
        System.out.println("Enemy moves closer to you");
    }
    public void attack(){
        System.out.println( "Enemy attacks for "+attackDamage+" damage");
    }

    public int getId() {
        return id;
    }

    public static int getNumberOfEnemies() {
        return numberOfEnemies;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
