package models;

public abstract class Good {
    protected int id;
    protected String name;
    protected String producer;
    protected float price;
    protected String mem;
    protected String material;

    public Good() {
    }

    public Good(int id, String name, String producer, float price, String mem, String material) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.mem = mem;
        this.material = material;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
