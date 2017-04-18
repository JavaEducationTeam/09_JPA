package hu.javagladiators.example.sport.viewmodel.framework;

/**
 * @author krisztian
 */
public class MenuPOJO {
    String text,url;

    public MenuPOJO() {
    }

    public MenuPOJO(String text, String url) {
        this.text = text;
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
    
}
