import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Dog extends Animal
        {
private LocalDateTime _lastWalk;
public LocalDateTime LastWalk(){
        return _lastWalk;
}
public Boolean NeedsWalk()
        {
                return (Duration.between(LocalDateTime.now(), this._lastWalk).toDays()) > 0;
        }

public Dog(String name, Gender gender, int dogsAdded){
            super(name, gender);
        this._lastWalk = LocalDateTime.now();
        super._price = 500 - 50 * dogsAdded;
        if (super._price < 50){
                super._price = 50;
        }
        }

@Override
public String toString()
        {
        return super.toString() + ", price: " + super._price +
        ", last walk: "+this._lastWalk.toString();
        }
        }
