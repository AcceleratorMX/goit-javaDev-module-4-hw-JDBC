package converter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class ProjectPrice {
    private String id;
    private int price;

    @Override
    public String toString() {
        return "id='" + id + '\'' + " | price=" + price + "\n";
    }
}
