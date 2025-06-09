public class MenuItem{
    private String name;
    private String code;
    private int price;

    public MenuItem(String name , String code , int price){
            this.name = name;
            this.code = code;
            this.price = price;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }



}