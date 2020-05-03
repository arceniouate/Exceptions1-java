package entites;

public class Account {
    private Integer number;
    private String  holder;
    private double balance;
    private double wthidrawLim;


    public Account() {
    }

    public Account(Integer number, String holder, double balance, double wthidrawLim) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.wthidrawLim = wthidrawLim;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }



    public double getWthidrawLim() {
        return wthidrawLim;
    }

   // public void setWthidrawLim(double wthidrawLim) {
     //   this.wthidrawLim = wthidrawLim;
    //}

    /**
     * metodo para fazer o deposito da conta
     * @param amout montante
     */
    public void deposit( double amout){
        this.balance+=amout;
    }

    /**
     * metodo para fazer o sack do dinheiro na conta
     * @param amout montante para fazer sake
     */
    public void Wthidraw( double amout)throws Exception{
        if(wthidrawLim<amout){
            throw new Exception("The amount exceeds withdraw limit");
        }
        if(balance==0.0){
            throw new Exception("Not enough balance");
        }

        this.balance-=amout;
    }
}
