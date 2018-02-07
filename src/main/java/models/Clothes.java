package models;

public class Clothes extends Good {
    private String size;

    public Clothes() {
    }

    public Clothes(int id, String name, String producer, float price, String mem, String material, String size) {
        super(id, name, producer, price, mem, material);
        this.size = size;
    }

    public Clothes(String name, String producer, float price, String mem, String material, String size) {
        super(name, producer, price, mem, material);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String getCategory() {
        return "clothes";
    }
}
