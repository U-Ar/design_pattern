package idcard;

import framework.Product;

public class IDCard extends Product {
    private String owner;
    private int id;

    IDCard(String owner, int id) {
        System.out.println("所有者:"+owner+" ID:"+id+ "のカードを作ります。");
        this.owner = owner;
        this.id = id;
    }

    @Override 
    public void use() {
        System.out.println(this + "を使います。");
    }

    @Override 
    public String toString() {
        return "[IDCard "+this.id+" owned by " + owner + "]";
    }

    public String getOwner() {
        return owner;
    }

    public int getId() {
        return id;
    }
}
