public class Arena {
    private Wizard Snape;
    private DummyTarget Dummy;

    //overloaded constructors//
    
    public Arena(Wizard Snape, DummyTarget Dummy) {
        this.Snape = Snape;
        this.Dummy = Dummy;
    }

    //startFight method

    public void startFight() {
        while (Snape.getMana() >= 0 && Dummy.getHealth() > 0) {
            int damage = Snape.fireball();
            Dummy.setHealth(Dummy.getHealth() - damage);
            System.out.println("Snape casts fireball, Dummy took " + damage + " damage!");
            Dummy.cry();
            System.out.println(Dummy);//line 20 and 21 shows us//
            System.out.println(Snape);//the current mana and health levels//
        

            if (Dummy.getHealth() <= 0) {
                endFight(Snape, Dummy);
                break;
            }

            if (Snape.getMana() <= 0){
                endFight(Snape, Dummy);
                break;
            }

        }

    }

    //endFight method//

    public void endFight(Wizard Snape, DummyTarget Dummy) {
            if (Snape.getMana() <= 0) {
                System.out.println("Dummy is the winner" );
        
        }

         else if (Dummy.getHealth() <= 0) {
             System.out.println("Snape is the winner");
    }
}

    //main method//

    public static void main(String[] args){
        Wizard Snape = new Wizard(500,20,500);
        DummyTarget Dummy = new DummyTarget("Dummy", 20);

        Arena Arena = new Arena(Snape, Dummy);

        Arena.startFight();
    }
}