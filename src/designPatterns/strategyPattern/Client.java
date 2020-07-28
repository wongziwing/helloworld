package designPatterns.strategyPattern;

public class Client {

    private double money;

    public Client(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    public static void main(String[] args) {
        Client client = new Client(300);
        ContextPlus contextPlus;
        contextPlus = new ContextPlus("正常收费");
        System.out.println(contextPlus.getResult(client.getMoney()));

        contextPlus = new ContextPlus("打8折");
        System.out.println(contextPlus.getResult(client.getMoney()));

        contextPlus = new ContextPlus("满300返100");
        System.out.println(contextPlus.getResult(client.getMoney()));
    }
}











