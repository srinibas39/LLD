


public class DelhiveryOrder extends Order {

    private String addresses;

    @Override
    public String getType(){
        return "Delhivery";
    }

    public void setAddresses(String addresses){
        this.addresses = addresses;
    }

    public String getAddresses(){
        return this.addresses;
    }




}