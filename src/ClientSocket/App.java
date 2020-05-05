package ClientSocket;

import Commands.Commands;
import Utilites.CreateHuman;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class App {
    private static ClientReceiver receiver;
    private static ClientSender sender;
    boolean was = false;
    private Commands command = new Commands();
    private Scanner in = new Scanner(System.in);
    private CreateHuman creater = new CreateHuman();
    private CommandsToSend commandsToSend = new CommandsToSend();
    String filename = "";

    public App(ClientSender sender, ClientReceiver receiver) {
        this.receiver = receiver;
        this.sender = sender;
        System.out.println("Работа приложения запущена.");
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public static ClientReceiver getReceiver() {
        return receiver;
    }

    public static ClientSender getSender() {
        return sender;
    }

    public void begin() throws IOException {
        sender.send("-1");
        try {
            Scanner in = new Scanner(System.in);
            while (filename.equals("")) {
                System.out.print("Укажите имя файла:\n$ ");
                filename = in.nextLine();
            }
            int tumb = 0;
            sender.sendClientPort();
            sender.send(filename);
            String received = receiver.receive();
            if (received != null) {
                System.out.print(received);
            }
            was = true;
        } catch (SocketTimeoutException e) {
            was = false;
        }
    }

    public void run() throws IOException {
        while (true) {
            System.out.print("$ ");
            String commandName = in.nextLine();
            command.setCommand(commandName);
            if (command.getMessage() != (null))
                System.out.println(command.getMessage());
            if (command.getCommand() != null) {
                try {
                    if (!was ) this.begin();
                    if (!(commandsToSend.getCommandsToSend().equals("")))
                        this.begin();
                    if (command.getCommand().getName().equals("execute_script"))
                        command.getCommand().execute(command.getArg());
                    else {
                        sender.sendCommand(command);
                        if (sender.isCommandWithObject())
                            if (receiver.receive().equals("newHuman"))
                                sender.send(creater.create());
                        receiver.receiveCollection();
                        String received = receiver.receive();
                        System.out.println(received);
                    }
                    if (!(commandsToSend.getCommandsToSend().equals(""))) {
                        System.out.println("\nКоманды ранее отправленные на сервер:");
                        commandsToSend.addCommandsToSend(commandName);
                        commandsToSend.sendCommands();
                        commandsToSend.removeCommandsToSend();
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();

                } catch (SocketTimeoutException e) {
                    System.out.println("Сервер недоступен =(");
                    commandsToSend.addCommandsToSend(commandName + "\n");
                    //if (was == false)
                    this.run();

                }
            }
        }
    }
}

