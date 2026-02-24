package battlearena;

import battlearena.enemies.Enemy;
import battlearena.enemies.individualenemy.Orge;
import battlearena.enemies.individualenemy.Zombie;
import battlearena.heros.Hero;
import battlearena.heros.weapons.Weapon;

import static battlearena.enemies.Enemy.getNumberOfEnemies;

public class Main {
    static void main() {
        Zombie zombie = new Zombie(10, 1);
        Orge orge = new Orge( 20, 3);
        System.out.println("There are "+getNumberOfEnemies() +" enemies ready to fight");


//
//        battle(zombie, orge);
        zombie.battleStance();
        orge.stareDown();

        Weapon weapon = new Weapon("Sword", 5);
        Hero hero = new Hero(25, 1);
        hero.setWeapon(weapon);
        hero.equipWeapon();
        heroBattle(hero, zombie);

//        System.out.println(zombie.getNumberOfEnemies());
//        System.out.println(orge.getNumberOfEnemies());
//        System.out.println(zombie.getId());
//        System.out.println(orge.getId());
    }

    public static void heroBattle(Hero hero, Enemy enemy){
        while (hero.getHealthPointsRemaining()>0 && enemy.getHealthPointsRemaining()>0){
            System.out.println("--------------");
            enemy.specialAttack();
            System.out.println("Hero: "+hero.getHealthPointsRemaining()+" HP left");
            System.out.println("Enemy: "+enemy.getHealthPointsRemaining()+" HP left");
            enemy.attack();
            hero.setHealthPointsRemaining(hero.getHealthPointsRemaining() - enemy.getAttackDamage());
            hero.attack();
            enemy.setHealthPointsRemaining(enemy.getHealthPointsRemaining() - hero.getAttackDamage());
        }

        System.out.println("---------------------");

        if(hero.getHealthPointsRemaining()>0){
            System.out.println("Hero wins");
        }
        else{
            System.out.println("Enemy Wins");
        }

    }

    public  static  void battle(Enemy e1, Enemy e2){
        e1.talk();
        e2.talk();

        while (e1.getHealthPointsRemaining()>0 && e2.getHealthPointsRemaining()>0){
            System.out.println("---------");
            e1.specialAttack();
            e2.specialAttack();
            System.out.println("Enemy 1: "+e1.getHealthPointsRemaining() +" HP left");
            System.out.println("Enemy 2: "+e2.getHealthPointsRemaining() +" HP left");
            e2.attack();
            e1.setHealthPointsRemaining(e1.getHealthPointsRemaining() - e2.getAttackDamage());
            e1.attack();
            e2.setHealthPointsRemaining(e2.getHealthPointsRemaining() - e1.getAttackDamage());
        }
        System.out.println("--------Final---------");
        if(e1.getHealthPointsRemaining()>0){
            System.out.println("Enemy 1 Wins");
        }
        else{
            System.out.println("Enemy 2 Wins");
        }


    }
}
