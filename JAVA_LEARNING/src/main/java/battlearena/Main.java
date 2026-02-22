package battlearena;

public class Main {
    static void main() {
        Zombie zombie = new Zombie(10, 1);
        Orge orge = new Orge( 20, 3);

        battle(zombie);
        battle(orge);


//        System.out.println(zombie.getNumberOfEnemies());
//        System.out.println(orge.getNumberOfEnemies());
//        System.out.println(zombie.getId());
//        System.out.println(orge.getId());
    }

    public  static  void battle(Enemy e){
        e.talk();
        e.attack();
        // In this we cannot use the methods of child class. But when we call the methods which are overridden will be executed
    }
}
