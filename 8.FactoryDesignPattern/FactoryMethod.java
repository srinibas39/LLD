
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

class BasicWheatBurger implements  Burger{

    @Override
    public void prepare(){
        System.out.println("Basic Wheat Burger");
    }
}

class StandardWheatBurger implements  Burger{

    @Override
    public void prepare(){
        System.out.println("Standard Wheat Burger");
    }
}

class PremiumWheatBurger implements  Burger{
    @Override
    public void prepare(){
        System.out.println("Premium Wheat Burger");
    }
}

interface FactoryBurger{
    Burger createBurger(String type);
}

class BurgerKing implements FactoryBurger{

    @Override
    public Burger createBurger(String type){
        if(type == "basic"){
            return new BasicBurger();
        }
        else if(type == "standard"){
            return new StandardBurger();
        }
        else if(type == "premium"){
            return new PremiumBurger();
        }
        else return null;
    }
}

class BurgerSingh implements FactoryBurger{
   @Override
    public Burger createBurger(String type){
        if(type == "basic"){
            return new BasicWheatBurger();
        }
        else if(type == "standard"){
            return new StandardWheatBurger();
        }
        else if(type == "premium"){
            return new PremiumWheatBurger();
        }
        else return null;
    }
}


class FactoryMethod{
    public static void main(String[] args) {
        String type = "premium";
        FactoryBurger burgerfactory = new BurgerKing();
        Burger burger = burgerfactory.createBurger(type);

        if(burger != null){
            burger.prepare();
        }
        
    }
}