
import LLD.ZomatoDesign_10.models.Restaurant;
import java.util.List;



public abstract class Order{
    private static int nextOrderId = 0;
    private int orderid;
    private Restaurant restaurant; 
    private List<MenuItem> items;
    private User user;
    private PaymentStrategy paymentStrategy;
    private double total;
    private String scheduled;

    public Order(){
        this.restaurant = null;
        this.user = null;
        this.paymentStrategy = null;
        this.total = 0.0;
        this.scheduled = "";
        this.orderid = ++nextOrderId;
    }

    public boolean processPayment(){
        if(this.paymentStrategy != null){
            this.paymentStrategy.pay(this.total);
            return true;
        }
        else{
            System.out.println("Please choose your payment mode first");
            return false;
        }
    }

    public abstract String getType();

    //Getters ans setters

    public int getOrderId(){
        return this.orderid;
    }

    public void setUser(User u){
         this.user = u;
    }

    public void setRestaurant(Restaurant r){
        this.restaurant = r;
    }

    public Restaurant getRestaurant(){
        return this.restaurant;
    }

    public List<MenuItem> getMenuItem(){
        return this.items;
    }

    public void setItems(List<MenuItem> items){
        this.items = items;
        double total = 0;
        for(MenuItem item : this.items){
            this.total += item.getPrice();
        }

    }

    public List<MenuItem> getItems(){
        return this.items;
    }

    public void setPaymentStrategy(PaymentStrategy s){
        this.paymentStrategy = s;
    }

    public PaymentStrategy getPaymentStrategy(){
        return this.paymentStrategy;
    }

     public void setScheduled(String s) {
        this.scheduled = s;
    }

    public String getScheduled() {
        return this.scheduled;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}