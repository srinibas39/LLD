
public class PickupOrder extends Order{
    private String restaurantAddress;

    @Override
    public String getType(){
        return "Pickup";
    }

    public void setRestaurantAddresses(String addr){
        this.restaurantAddress = addr;
    }

    public String getRestaurantAddresses(){
        return this.restaurantAddress;
    }
}