package UI.teacher_table;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class homework {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleStringProperty date;
    private final SimpleStringProperty filename;
    private final SimpleStringProperty description;

    public homework(int id, String name, String date, String filename,String description) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
        this.filename = new SimpleStringProperty(filename);
        this.description = new SimpleStringProperty(description);
    }

    public int getId() {
        return id.get();
    }



    public String getName() {
        return name.get();
    }


    public String getDate() {
        return date.get();
    }

    public String getFilename() {
        return filename.get();
    }

    public String getDescription() {
        return description.get();
    }
}
