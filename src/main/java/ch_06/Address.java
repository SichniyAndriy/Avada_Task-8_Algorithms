package ch_06;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    private String city;
    private String street;
    private Integer number;
}
