package at.ta.chat;

import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class TaskGUI {

    private Scanner scanner;
    private MessageDAO messageDAO;
    private UserVO userVO;
    private MessageVO messageVO;
    public String user;
    private int lastPrintedMessageID;


    public TaskGUI() {
        this.scanner = new Scanner(System.in);
        this.messageDAO = new MessageDAO();
        this.lastPrintedMessageID = 0;

    }

    public void control() {
        while (true) {

            System.out.println("Willkommen");
            System.out.println("a adduser, l liste von usern, c chat starten");
            String input = this.scanner.nextLine();

            if (input.equals("a")) {

                addUser();
            }

            if (input.equals("l")) {
                printAllUser();

            }

            if (input.equals("c")) {
                addMessage();

            }

        }
    }

    public void addMessage() {
        messageDAO.getChat();
        String input = this.scanner.nextLine();
        messageDAO.insertMessage(input, this.userVO);

    }

    public void addUser() {
        System.out.println("Bitte gib deine namen ein: ");
        String input = this.scanner.nextLine();
        this.userVO = new UserVO(0, input);
        UserVO taskVOUser = new UserVO(0, userVO.getUserName());
        messageDAO.insertUser(taskVOUser);

    }

    public void printAllUser() {
        List<UserVO> userVOS = this.messageDAO.getAllUser();
        for (UserVO userVO : userVOS) {
            System.out.println("User id: " + userVO.getId() + " User: " + userVO.getUserName());
        }
        System.out.println("Bitte Wähle deine id: ");
        String input = this.scanner.nextLine();
        int id = Integer.valueOf(input);
        this.userVO = userVOS.get(id - 1);

    }

}
