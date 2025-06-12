

import java.util.List;

public interface OrderFactory{

    public Order createOrder(Restaurant restaurant , User user , PaymentStrategy paymentStrategy , double total , String scheduled , List<MenuItem> items , String orderType , Cart cart);
}