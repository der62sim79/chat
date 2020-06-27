package at.ta.chat;

import java.util.List;
import java.util.Scanner;

public class TaskGUI {

    private Scanner scanner;
    private MessageDAO messageDAO;
    private UserVO userVO;
    private MessageVO messageVO;


    public TaskGUI() {
        this.scanner = new Scanner(System.in);
        this.messageDAO = new MessageDAO();

    }


    public void output() {
        System.out.println("Willkommen");
        addUser();
        addMessage();
    }

    public void addMessage() {
        messageDAO.getChat();
        String input = this.scanner.nextLine();
        messageDAO.insertMessage(input, userVO);
    }

    public void addUser() {
        System.out.println("Bitte gib deine namen ein: ");
        String input = this.scanner.nextLine();
        UserVO taskVOUser = new UserVO(0, input);
        messageDAO.insertUser(taskVOUser);

    }

}
