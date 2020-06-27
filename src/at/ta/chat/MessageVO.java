package at.ta.chat;

public class MessageVO {
    private int id;
    private String created_at;
    private String chat;
    private int fkName;

    public MessageVO(int id, String created_at, String chat, int fkName) {
        this.id = id;
        this.created_at = created_at;
        this.chat = chat;
        this.fkName = fkName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFkName() {
        return fkName;
    }

    public void setFkName(int fkName) {
        this.fkName = fkName;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
