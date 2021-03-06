package no.hvl.dat250.experiment2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.google.gson.Gson;
import lombok.Data;

@Data
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private String description;

    String toJson () {
        Gson gson = new Gson();
        String jsonInString = gson.toJson(this);
        return jsonInString;
    }
}
