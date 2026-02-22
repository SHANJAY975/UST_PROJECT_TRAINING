package battlearena;

public class Main {
    static void main() {
        Zombie zombie = new Zombie(10, 1);
        Orge orge = new Orge( 20, 3);


        System.out.println( zombie.getClass().getSimpleName()+" has "+ zombie.getHealthPoints() +" health points and can do an attack of "+ zombie.getAttackDamage());
        zombie.talk();
        zombie.spreadDisease();
        orge.talk();


    }
}
