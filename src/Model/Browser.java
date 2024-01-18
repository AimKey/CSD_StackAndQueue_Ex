package Model;

public class Browser {
    String title, description;

    public Browser(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Browser title(String title) {
        setTitle(title);
        return this;
    }

    public Browser description(String description) {
        setDescription(description);
        return this;
    }

    @Override
    public String toString() {
        return
            "Title='" + getTitle() + "'" +
            ", description='" + getDescription() + "'";
    }
    
}
