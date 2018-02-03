package models;

public class Cutlery extends Good {
    private String volume;

    public Cutlery() {
    }

    public Cutlery(int id, String name, String producer, float price, String mem, String material, String volume) {
        super(id, name, producer, price, mem, material);
        this.volume = volume;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String getCategory() {
        return "cutlery";
    }
}
