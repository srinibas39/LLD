
interface ICommand{
    void execute(); // turn on
    void undo(); // turn off
}

//receivers
class Light {

    public void on(){
        System.out.println("Light ON");
    }

    public void off(){
        System.out.println("Light OFF");
    }
}

class Fan{

    public void on(){
        System.out.println("Fan ON");
    }


    public void off(){
        System.out.println("FAN OFF");
    }

}

//Concrete Command for light
class LightCommand implements ICommand{

    private Light light;

    public LightCommand(Light light){
       this.light = light;
    }

    @Override
    public void execute(){
        this.light.on();
    }

    @Override
    public void undo(){
        this.light.off();
    }
}

//Concrete Command for fan
class FanCommand implements ICommand{

    private Fan fan;

    public FanCommand(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute(){
        this.fan.on();
    }

    @Override
    public void undo(){
        this.fan.off();
    }
}

//concrete remote class 
class RemoteController{
    private static final int numButton = 4;
    private ICommand[] buttons;
    private boolean[] buttonPressed;

    public RemoteController(){
        this.buttons = new ICommand[numButton];
        this.buttonPressed = new boolean[numButton];

        for(int i = 0 ; i < numButton ; i++){
            this.buttons[i] = null;
            this.buttonPressed[i] = false;
        }
    }

    public void setCommand(ICommand command , int index){
        //check for valid index
        if(index >= 0 && index<=numButton){
            this.buttons[index] = command;
            this.buttonPressed[index] = false;
        }
        else{
            System.out.println("Invalid index");
        }
    }

    public void handleButtonPressed(int index){
        if(index>=0 && index<= numButton){
            if(!this.buttonPressed[index]){
                this.buttons[index].execute(); // turn on
            }
            else{
                this.buttons[index].undo(); // turn off;
            }
            this.buttonPressed[index] = !this.buttonPressed[index];
        }
        else{
            System.out.println("Invalid index");
        }
    }
}

public class CommandPattern{
    public static void main(String[] args) {
        
        Light light = new Light();
        Fan fan = new Fan();

        RemoteController remote = new RemoteController();

        remote.setCommand(new LightCommand(light), 0);
        remote.setCommand(new FanCommand(fan), 1);

        System.out.println("Toggling light");
        //toggling light
        remote.handleButtonPressed(0);
        remote.handleButtonPressed(0);

        System.out.println("Toggling fan");
        //toggling fan
        remote.handleButtonPressed(1);
        remote.handleButtonPressed(1);

        System.out.println("Toggling something that does not exist");
        remote.handleButtonPressed(2);

    }
}




