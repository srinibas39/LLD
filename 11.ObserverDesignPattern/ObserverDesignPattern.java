
import java.util.*;


interface IChannel{
    void subscribe(ISubsriber subsriber);
    void unsubcribe(ISubsriber subsriber);
    void notifySubs();
}

interface ISubsriber{
    void update();
}

class Channel implements IChannel{

    private List<ISubsriber> subscriberList;
    private String channelName;
    private String latestVideo;

    public Channel(String name){
        this.subscriberList = new ArrayList<>();
        this.channelName = name;
    }

    @Override
    public void subscribe(ISubsriber subsriber){
       if(!this.subscriberList.contains(subsriber)){
           return;
       }
       this.subscriberList.add(subsriber);
    }
    @Override
    public void unsubcribe(ISubsriber subsriber){
       this.subscriberList.remove(subsriber);
    }

    @Override
    public void notifySubs(){
       for(ISubsriber subsriber : this.subscriberList){
           subsriber.update();
       }
    }

    public void uploadVideo(String title){
        System.out.println("Video uploaded"+" "+ title);
        notifySubs();
    }

    public String getVideoData(){
        return "Your new video is"+this.latestVideo;
    }

}

class Subscriber implements ISubsriber{
    private String name;
    private Channel channel;

    public Subscriber(String name , Channel channel){
        this.name = name;
        this.channel = channel;
    }

    @Override
    public void update(){
        System.out.println("Hey "+this.name+" "+this.channel.getVideoData()+" has been uploaded");
    }
}





public class ObserverDesignPattern{
    public static void main(String[] args) {
        Channel channel = new Channel("3blue1brown");
        
        Subscriber sub1 = new Subscriber("mitu",channel);
        Subscriber sub2 = new Subscriber("arpita", channel);

        channel.subscribe(sub1);
        channel.subscribe(sub2);

        channel.uploadVideo("Neural netwok");

        channel.unsubcribe(sub2);

        channel.uploadVideo("Quantam Computing");
    }

}