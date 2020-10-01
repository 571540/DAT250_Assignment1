package no.hvl.dat250.experiment2;

import com.google.gson.Gson;
import java.util.List;
import static spark.Spark.*;

public class App {
	static TodoDAO todoDAO = new TodoDAO();

    public static void main(String[] args) {

        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(8080);
        }

        after((req, res) -> {
            res.type("application/json");
        });

        get("/todos", (req, res) -> {
	    List<Todo> todo = todoDAO.read();
            Gson gson = new Gson();
            return gson.toJson(todo.toArray());
        });

        get("/todos/:id", (req, res) -> {
            Todo todo = todoDAO.read(Integer.parseInt(req.params(":id")));
            return todo.toJson();
        });

        put("/todos", (req, res) -> {
            Gson gson = new Gson();
            Todo todo = gson.fromJson(req.body(), Todo.class);
            todoDAO.update(todo);
            return "Updated: " + todo.toJson();
        });

        post("/todos", (req, res) -> {
            Gson gson = new Gson();
            Todo todo = gson.fromJson(req.body(), Todo.class);
            todoDAO.create(todo);
            return "Created: " + todo.toJson();
        });

        delete("/todos/:id", (req, res) -> {
            todoDAO.delete(Integer.parseInt(req.params(":id")));
            return "Delete successful";
        });
    }

}
