package ch_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age ;
    private Address address;
    private String[] card = new String[3];
    private List<Pet> pets = new ArrayList<>();
    private Map<String, String> languages = new HashMap<>();
}
