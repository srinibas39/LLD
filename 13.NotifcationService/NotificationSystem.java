
import java.util.ArrayList;
import java.util.List;



//De 

interface INotification{
    String getMessage();
}

class SimpleNotification implements INotification{
    private String message;

    public SimpleNotification(String message){
        this.message = message;
    }

    @Override
    public String getMessage(){
        return this.message;
    }

}

abstract class INotificationDecorator implements INotification{
    protected INotification notification;

    public INotificationDecorator(INotification n){
        this.notification = n ;
    }
}

class TimestampDecorator extends INotificationDecorator{
    public TimestampDecorator(INotification n){
        super(n);
    }

    public String getMessage(){
       return "[2025-04-13 14:22:00] " + this.notification.getMessage();
    }
}

class SignatureDecorator extends  INotificationDecorator{
    private String signature;

    public SignatureDecorator(INotification n,String sig){
        super(n);
        this.signature = sig;

    }
    
    public String getMessage(){
        return this.notification.getMessage() + "\n--" + this.signature + "\n\n";
    }
}

//Delivery System for notification --> Observer Design pattern

interface IObservable{

    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notifyObservers();
    String getNotificationMessage(); 

}

interface IObserver{
    void update();
}

class Observable implements  IObservable{
    private List<IObserver> notifyList = new ArrayList<>();
    private INotification currentNotification;

    @Override
    public void addObserver(IObserver observer){
        this.notifyList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer){
        this.notifyList.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for(IObserver o : this.notifyList){
            o.update();
        }
    }

    public INotification getNotification(){
         return this.currentNotification;
    }

    public void setNotification(INotification notification){
        this.currentNotification = notification;
        this.notifyObservers();
    }
    @Override
    public String getNotificationMessage(){
        return this.currentNotification.getMessage();
    }

}

//one of the observer class 
class Logger implements IObserver{
    private IObservable observable;

    public Logger(IObservable observable){
        this.observable = observable;
    }

    @Override
    public void update(){
        System.out.println("Logging : "+ this.observable.getNotificationMessage());
    }


}

// sanother obeserver is notifcation engine which we will implement through strategic design pattern



interface NotificationStretegy{
    void sendNotification(String content);
}

class EmailStrategy implements NotificationStretegy{
    private String emailId;

    public EmailStrategy (String emailId){
        this.emailId = emailId;
    }

    @Override
    public void sendNotification(String content){
        System.err.println("Sending email notifcation to "+ this.emailId +" "+ content);
    }

}

class SMSStrategy implements NotificationStretegy{
    private String phoneNo;

    public SMSStrategy(String phoneNo){
        this.phoneNo = phoneNo;
    }

    @Override
    public void sendNotification(String content){
        System.err.println("Sending SMS notifcation to "+ this.phoneNo +" "+ content);
    }

}

class PopupStrategy implements NotificationStretegy{
    @Override
    public void sendNotification(String content){
        System.err.println("Sending SMS notifcation to "+ content);
    }
}

class NotificationEngine implements IObserver{
    private IObservable observable;
    private List<NotificationStretegy> notificationStrategyList = new ArrayList<>();

    public NotificationEngine(IObservable observable){
        this.observable = observable;
    }

    public void addStrategy(NotificationStretegy notificationStrategy){
        this.notificationStrategyList.add(notificationStrategy);
    }

    public void update(){
        String notificationContent = this.observable.getNotificationMessage();

        //now send the message
        for(NotificationStretegy notificationStrategy : this.notificationStrategyList){
            notificationStrategy.sendNotification(notificationContent);
        }

    }

}

class NotificationService{
    private Observable observable;
    private static NotificationService instance;
    private List<INotification> notificationList = new ArrayList<>();

    private NotificationService(){
        observable = new Observable();
    }

    public static NotificationService getInstance(){
         if(instance == null){
            instance = new NotificationService();
         }
         return instance;
    }

    public Observable getObservable(){
        return this.observable;
    }

    public void sendNotification(INotification notification){
        this.notificationList.add(notification);
        observable.setNotification(notification);
    }



}

 class NotificationSystem{
    public static void main(String[] args) {
        
        NotificationService service =  NotificationService.getInstance();
        Observable obs = service.getObservable();
        
        Logger logger = new Logger(obs);

        NotificationEngine notificationEngine = new NotificationEngine(obs);
        
        notificationEngine.addStrategy(new EmailStrategy("srinibas39@gmail.com"));
        notificationEngine.addStrategy(new SMSStrategy("12345678"));
        notificationEngine.addStrategy(new PopupStrategy());

        //attach observers
        obs.addObserver(logger);
        obs.addObserver(notificationEngine);

        //create a notification with decorators
        INotification notification = new SimpleNotification("<First Notification>");
        notification = new TimestampDecorator(notification);
        notification = new SignatureDecorator(notification,"Customer care");


        service.sendNotification(notification);



    }
}




