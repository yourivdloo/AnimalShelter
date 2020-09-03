import java.util.ArrayList;

public class Reservation
{
    private ArrayList<Animal> _animals = new ArrayList<Animal>();
    private int _dogsAdded;

    public ArrayList<Animal> Animals(){
        return _animals;
    }

    public int DogsAdded(){
        return _dogsAdded;
    }

    public void NewCat(String name, Gender gender, String badHabits)
    {
        this._animals.add(new Cat(name, gender, badHabits));
    }

    public void NewDog(String name, Gender gender)
    {
        this._animals.add(new Dog(name, gender, DogsAdded()));
        _dogsAdded++;
    }
}
