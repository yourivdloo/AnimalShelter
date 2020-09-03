import Interfaces.ISellable;

import java.time.LocalDateTime;

public abstract class Animal implements ISellable {
    private String _name;
    private Gender _gender;
    private Reservor _reservedBy;
    private Boolean _isReserved = false;
    protected int _price;

    public String Name(){ return _name; }

    public Gender Gender(){
        return _gender;
    }

    public Reservor ReservedBy(){
        return _reservedBy;
    }

    public Boolean IsReserved(){
        return _isReserved;
    }

    public int Price(){ return _price; }

    public Animal(String name, Gender gender) {
        this._name = name;
        this._gender = gender;
    }

    public Boolean Reserve(String reservedBy) {
        if (this._reservedBy == null) {
            this._reservedBy = new Reservor(reservedBy, LocalDateTime.now());
            this._isReserved = true;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reserved = "not reserved";
        if (this._reservedBy != null) {
            reserved = "reserved by " + this._reservedBy.Name;
        }
        return this._name + "," + this._gender + ",€" + this._price + "," + reserved;
    }
}
