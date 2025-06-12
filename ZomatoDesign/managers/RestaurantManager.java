
import java.util.ArrayList;
import java.util.List;
import ZomatoDesign_10.models.*;




//singleton
public class RestaurantManager{
    private List<Restaurant> restaurants = new ArrayList<>();

    private static RestaurantManager instance;

    private RestaurantManager(){

    }

    public static RestaurantManager getInstance(){
            if(instance == null){
                instance = new RestaurantManager();
            }
            return instance;
    }

    public void addRestaurant(Restaurant r){
        this.restaurants.add(r);
    }

    public List<Restaurant> getRestaurant(){
        return this.restaurants;
    }

    public List<Restaurant> searchLocation(String loc){
        List<Restaurant> res = new ArrayList<>();
        loc = loc.toLowerCase();
        for(Restaurant r : List<Restaurant>){
            if(r.getLocation().toLowerCase().equals(loc)){
                res.add(r);
            }
        }

        return res;
    }



}