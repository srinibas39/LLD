
public class ScheduledDelhivery implements OrderFactory{
    
    @Override
    public Order createOrder(Restaurant restaurant , User user , PaymentStrategy paymentStrategy , double total , String scheduled , List<MenuItem> items , String orderType , Cart cart){
        private Order order = null

        if(orderType == "Delhivery"){
            DelhiveryOrder delhiveryOrder = new delhiveryOrder();
            delhiveryOrder.setAddresses(user.getAddresses());
            this.order = delhiveryOrder;

        }
        else if(orderType == "Pickup"){
            PickupOrder PickupOrder = new PickupOrder();
            PickupOrder.setAddresses(restaurant.getAddresses());
            this.order = PickupOrder;
        }

        this.order.setUser(user);
        this.order.setRestaurant(restaurant);
        this.order.setItems(menuItems);
        this.order.setPaymentStrategy(paymentStrategy);
        this.order.setScheduled(TimeUtils.getCurrentTime());
        this.order.setTotal(totalCost);
    }
}