package ch_06;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Dog {
    private String breed;
    private String name;
    private int age;
}
