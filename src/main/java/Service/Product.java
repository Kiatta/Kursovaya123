package Service;


public class Product {
    protected String NameProduct;
    protected int Price;


    public Product(String NameProduct, int Price) {
        this.NameProduct = NameProduct;
        this.Price = Price;

    }

    public String getNameProduct() {
        return this.NameProduct;
    }



    public int getPrice() {
        return this.Price;
    }

}