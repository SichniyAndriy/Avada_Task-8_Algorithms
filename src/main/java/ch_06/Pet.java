package ch_06;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Pet {
    protected String breed;
    protected String name;
    protected int age;
}
