package ma.enset;

import jade.content.Concept;

public class Product implements Concept {
    private String name ;
    private float price ;

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
