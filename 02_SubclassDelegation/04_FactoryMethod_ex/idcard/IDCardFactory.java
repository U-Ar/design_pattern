package idcard;

import framework.Factory;
import framework.Product;

public class IDCardFactory extends Factory {
    private int last;

    public IDCardFactory() {
        this.last = 0;
    }

    @Override 
    protected Product createProduct(String owner) {
        return new IDCard(owner, last++);
    }

    @Override 
    protected void registerProduct(Product product) {
        System.out.println(product + "を登録しました。");
    }
}
