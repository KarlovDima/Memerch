package models;

public class Trifle extends Good {
    private int amount;

    public Trifle() {
    }

    public Trifle(int id, String name, String producer, float price, String mem, String material, int amount) {
        super(id, name, producer, price, mem, material);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String getCategory() {
        return "trifle";
    }
}
