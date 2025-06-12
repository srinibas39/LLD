
import LLD.ZomatoDesign_10.models.Restaurant;
import java.util.List;

public class Cart{
    private Restaurant restaurant;
    private List<MenuItem> items;

    public Cart(){
        this.restaurant = null;
    }

    public void addItem(MenuItem item){
        if(this.restaurant == null){
            System.out.println("No restuarant added");
            return;
        }
        this.items.add(item);
    }

    public double getTotalCost(){
        double sum = 0;
        for(MenuItem item : this.items){
            sum += item.getPrice();
        }
        return sum;
    }

    public boolean isEmpty(){
        return this.restaurant == null || items.isEmpty();
    }

    public void clear(){
        this.items.clear();
        this.restaurant = null;
    }

    public void setRestaurant(Restaurant r){
        this.restaurant = r;
    }

    public Restaurant getRestaurant(){
        return this.restaurant;
    }

    public List<MenuItem> getItems(){
        return this.items;
    }




}