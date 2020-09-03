

public class Cat extends Animal
        {
private String _badHabits;
public String Badhabits(){
        return _badHabits;
}

public Cat(String name, Gender gender, String badHabits)
        {
            super(name, gender);
        this._badHabits = badHabits;
        super._price = 350 - badHabits.length() * 20;
        }

        @Override
public String toString()
        {
        return super.toString() +
        ", bad habits: "+this._badHabits.toLowerCase();
        }
        }
