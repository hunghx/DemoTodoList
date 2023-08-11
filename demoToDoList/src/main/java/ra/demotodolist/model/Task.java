package ra.demotodolist.model;

public class Task {
    private  int id;
    private String imageUrl;
    private  String title;
    private String content;
    private  boolean status;

    public Task() {
    }

    public Task(int id, String imageUrl, String title, String content, boolean status) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public Task(String imageUrl, String title, String content) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
