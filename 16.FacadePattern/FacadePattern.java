class PowerSupply{
    public void providePower(){
        System.out.println("Power supply on");
    }
}

class CoolingSystem{
    public void startFan(){
        System.out.println("Fan turned ON");
    }
}

class CPU{
    public void intialize(){
        System.out.println("CPU intialization started");
    }
}

class Memory{
    public void selfTest(){
        System.out.println("Memory self test passed");
    }
}

class HardDrive{
    public void spinup(){
        System.out.println("Hard drive , spinning up started");
    }
}

class BIOS{
    public void boot(CPU cpu , Memory memory){
        cpu.intialize();
        memory.selfTest();
        System.out.println("booting started");
    }
}

class OS{
    public void load(){
        System.out.println("OS loading in memory");
    }
}

class ComputerFacade{
    private PowerSupply ps = new PowerSupply();
    private CoolingSystem cs  = new CoolingSystem();
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hd = new HardDrive();
    private BIOS bios = new BIOS();
    private OS os = new OS();


    public void startComputer(){
        System.out.println("starting computer");
        ps.providePower();
        cs.startFan();
        cpu.intialize();
        memory.selfTest();
        hd.spinup();
        bios.boot(cpu, memory);
        os.load();
        System.out.println("Computer started successfully");
    }
}

public class FacadePattern{
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}


