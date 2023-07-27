import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Camry {
    private String color;
    private Integer km;
    private Integer price;
    private String number;

}
