import Interfaces.ISellable;

public class Product implements ISellable {
    private int _price;
    private String _name;

    public String Name(){
        return _name;
    }
    public int Price(){
        return _price;
    }
    public Product(String name, int price){
        _name = name;
        _price = price;
    }

    @Override
    public String toString() {
        return "Name: " + this._name + ", Price: €" + this._price + ",-";
    }
}
