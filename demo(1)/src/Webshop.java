import java.util.ArrayList;

public class Webshop {
    private ArrayList<Product> _products = new ArrayList<Product>();
    public ArrayList<Product> Products(){
        return _products;
    }
    public void AddProduct(String name, int price){
        _products.add(new Product(name, price));
    }

    public void RemoveProduct(Product product){
        _products.remove(product);
    }
}
