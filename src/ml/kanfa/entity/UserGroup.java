package ml.kanfa.entity;

import javafx.beans.property.SimpleStringProperty;
import ml.kanfa.api.Entity;

import java.util.Objects;

/**
 * @author Ibrahim Maïga.
 */
public class UserGroup extends Entity{

    private int id;
    private SimpleStringProperty name;
    private SimpleStringProperty description;

    public UserGroup(){
        super();
    }

    @Override
    public void initialise() {
        this.id = 0;
        this.name = new SimpleStringProperty("");
        this.description = new SimpleStringProperty("");
    }

    public int getId() {
        return id;
    }

    public UserGroup setId(int newId) {
        if (newId > 0){
            this.id = newId;
        }
        return this;
    }

    public String getName() {
        return name.get();
    }

    public UserGroup setName(String newName) {
        Objects.requireNonNull(newName);
        this.name.set(newName);
        return this;
    }

    public String getDescription(){
        return this.description.get();
    }

    public UserGroup setDescription(String newDescription){
        Objects.requireNonNull(newDescription);
        this.description.set(newDescription);
        return this;
    }

    @Override
    public String toString() {
        return "[Name : " + getName()  + ")] [Description : " + getDescription() + ")]";
    }
}
