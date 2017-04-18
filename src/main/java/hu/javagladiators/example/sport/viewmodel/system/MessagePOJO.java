package hu.javagladiators.example.sport.viewmodel.system;

/**
 * @author krisztian
 */
public class MessagePOJO {
    protected String message;

    public MessagePOJO() {
    }

  

    public MessagePOJO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
