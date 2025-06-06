
interface Burger{
    void prepare();
}

class BasicBurger implements  Burger{

    @Override
    public void prepare(){
        System.out.println("Basic Burger");
    }
}

class StandardBurger implements  Burger{

    @Override
    public void prepare(){
        System.out.println("standard Burger");
    }
}

class PremiumBurger implements  Burger{
    @Override
    public void prepare(){
        System.out.println("Premium burger");
    }
}

class FactoryBurger{

    Burger burger;

    public Burger createBurger(String type){
        if(type == "basic"){
            this.burger = new BasicBurger();
        }
        else if(type == "standard"){
            this.burger = new StandardBurger();
        }
        else if(type == "premium"){
            this.burger = new PremiumBurger();
        }
        else this.burger = null;
        
        return this.burger;
    }

}

class SimpleFactory{
    public static void main(String[] args) {
        String type = "premium";
        FactoryBurger burgerfactory = new FactoryBurger();
        Burger burger = burgerfactory.createBurger(type);

        if(burger != null){
            burger.prepare();
        }
        
    }
}