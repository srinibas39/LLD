

interface Character{
    String getAbilities();
}

class Mario implements Character{

    @Override
    public String getAbilities(){
        return "mario ";
    }
}

class Luigi implements Character{
    @Override
    public String getAbilities(){
        return "Luigi ";
    }
}

//it has both is-a and has a relationship with character
abstract class CharacterDecorator implements Character{
    protected Character character;

    public CharacterDecorator(Character character){
        this.character = character;
    }

}

class Heightup extends CharacterDecorator{
    
    public Heightup(Character c){
        super(c);
    }

    public String getAbilities(){
         return this.character.getAbilities() + " height incresed ";
    }

}

class StarPower extends CharacterDecorator{
    public StarPower(Character c){
        super(c);
    }

    public String getAbilities(){
        return this.character.getAbilities() + " became invincible ";
    }
}

class Shooting extends CharacterDecorator{
    public Shooting(Character c){
        super(c);
    }

    public String getAbilities(){
        return this.character.getAbilities() + " shooting fireballs ";
    }
}

public class DecoratorDesignPattern{
    public static void main(String[] args) {
        Character mario = new Mario();
        System.out.println(mario.getAbilities());

        mario = new Heightup(mario);
        System.out.println(mario.getAbilities());

        mario = new StarPower(mario);
        System.out.println(mario.getAbilities());

        mario = new Shooting(mario);
        System.out.println(mario.getAbilities());

        System.out.println("------------------------------------------------");

        Character luigi = new Luigi();
        System.out.println(luigi.getAbilities());

        luigi = new Heightup(luigi);
        System.out.println(luigi.getAbilities());

        luigi = new StarPower(luigi);
        System.out.println(luigi.getAbilities());

        luigi = new Shooting(luigi);
        System.out.println(luigi.getAbilities());
        
    }
}