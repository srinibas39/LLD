public class User{
    int userId;
    String name;
    String addresses;
    Cart cart;

    public User(int userId,String name , String addresses){
        this.userId = userId;
        this.name = name;
        this.addresses = addresses;
        Cart cart = new Cart();
    }


    public void setUserId(int id){
        this.userId = id;
    }

    public int getUserId(){
        return this.userId;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAddresses(String a){
        this.addresses = a;
    }

    public String getAddresses(){
        return this.addresses;
    }

    public Cart getCart(){
        return this.cart;
    }


}