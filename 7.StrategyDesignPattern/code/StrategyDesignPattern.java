//strategy Design --> main abstract base class , different interfaces(stragies) , concrete classes


interface Walkable{
    void walk();
}

class NormaWalk implements  Walkable{
    @Override
    public void walk(){
        System.out.println("Robot can walk");
    }
}

class NonWalk implements  Walkable{
    @Override
    public void walk(){
        System.out.println("Robot can't walk");
    }
}

interface Talkable{
    void talk();
}

class NormalTalk implements  Talkable{
    @Override
    public void talk(){
        System.out.println("Robot can talk");
    }
}

class NonTalk implements  Talkable{
    @Override
    public void talk(){
        System.out.println("Robot can't talk");
    }
}


interface Flyable{
    void fly();
}

class NormalFly implements  Flyable{

    @Override
    public void fly(){
        System.out.println("Robot can fly");
    }
}

class NonFly implements  Flyable{
    @Override
    public void fly(){
        System.out.println("Robot can't fly");
    }
}

class JetFly implements  Flyable{
    @Override
    public void fly(){
        System.out.println("Robot can jet fly");
    }
}


abstract class Robot{
    protected Walkable walkable;
    protected Talkable talkable;
    protected Flyable flyable;

    public Robot(Walkable w , Talkable t , Flyable f){
        this.walkable = w;
        this.talkable = t;
        this.flyable = f;
    }

    
    public void walk(){
        this.walkable.walk();
    }

    public void talk(){
        this.talkable.talk();
    }

    public void fly(){
        this.flyable.fly();
    }
        
    public abstract void projection();

}


class CompanionRobot extends Robot{
    public CompanionRobot(Walkable w,Talkable t,Flyable f){
        super(w,t,f);
    }

    @Override
    public void projection(){
        System.out.println("Projection for companion Robot");
    }
}

class SparrowRobot extends Robot{
    public SparrowRobot(Walkable w,Talkable t,Flyable f){
        super(w,t,f);
    }

    @Override
    public void projection(){
        System.out.println("Projection for sparroe robot");
    }
}

public class StrategyDesignPattern{
    public static void main(String[] args) {
        
        SparrowRobot sparrowRobot = new SparrowRobot(
            new NormaWalk(),
            new NormalTalk(),
            new NormalFly()
        );

        sparrowRobot.projection();
        sparrowRobot.walk();
        sparrowRobot.talk();
        sparrowRobot.fly();

        System.out.println("--------------------------------");

        CompanionRobot companionRobot = new CompanionRobot(
            new NormaWalk(),
            new NormalTalk(),
            new NonFly()
        );
        companionRobot.projection();
        companionRobot.walk();
        companionRobot.talk();
        companionRobot.fly();

    }
}