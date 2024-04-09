package ch_06;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age ;
    private Address address;
    private Cat cat;
    private Dog dog;
}
