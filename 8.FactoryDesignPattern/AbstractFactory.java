
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


interface Pizza{
    void prepare();
}

class BasicPizza implements  Pizza{

    @Override
    public void prepare(){
        System.out.println("Basic Pizza");
    }
}

class StandardPizza implements  Pizza{

    @Override
    public void prepare(){
        System.out.println("standard Pizza");
    }
}

class PremiumPizza implements  Pizza{
    @Override
    public void prepare(){
        System.out.println("Premium Pizza");
    }
}

class BasicWheatPizza implements  Pizza{

    @Override
    public void prepare(){
        System.out.println("Basic Wheat Pizza");
    }
}

class StandardWheatPizza implements  Pizza{

    @Override
    public void prepare(){
        System.out.println("Standard Wheat Pizza");
    }
}

class PremiumWheatPizza implements  Pizza{
    @Override
    public void prepare(){
        System.out.println("Premium Wheat Pizza");
    }
}

interface FactoryMeal{
    Burger createBurger(String type);
    Pizza createPizza(String type);
    
}

class BurgerKing implements FactoryMeal{

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

    @Override
    public Pizza createPizza(String type){
        if(type == "basic"){
            return new BasicPizza();
        }
        else if(type == "standard"){
            return new StandardPizza();
        }
        else if(type == "premium"){
            return new PremiumPizza();
        }
        else return null;
    }


}
class BurgerSingh implements FactoryMeal{

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

    @Override
    public Pizza createPizza(String type){
        if(type == "basic"){
            return new BasicWheatPizza();
        }
        else if(type == "standard"){
            return new StandardWheatPizza();
        }
        else if(type == "premium"){
            return new PremiumWheatPizza();
        }
        else return null;
    }
}


class AbstractFactory{
    public static void main(String[] args) {
        String burgerType = "premium";
        String pizzaType = "premium";
        FactoryMeal burgerfactory = new BurgerSingh();
        Pizza pizza = burgerfactory.createPizza(pizzaType);
        Burger burger = burgerfactory.createBurger(burgerType);
        
        if(pizza != null){
            pizza.prepare();
        }

        if(burger != null){
            burger.prepare();
        }
        
    }
}