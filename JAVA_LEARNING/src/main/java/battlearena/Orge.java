package battlearena;

public class Orge extends Enemy{
    public Orge(int healthPoints, int attackDamage){
        super( healthPoints, attackDamage);
    }

    @Override
    public void talk(){
        System.out.println("Orge is slamming hands all around");
    }
}
