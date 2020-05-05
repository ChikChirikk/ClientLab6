package Commands;

import ClientSocket.App;
import ClientSocket.ClientReceiver;
import ClientSocket.ClientSender;
import FillCollection.HumanBeing;
import Utilites.CreateHuman;
import Utilites.ReaderFromFile;

import java.io.IOException;

/**
 * Removes all movies from collection
 *
 * @author Diana
 */
public class Execute_script implements Commandable {
    CreateHuman creater = new CreateHuman();
    String name = "execute_script";

    public String getName() {
        return name;
    }

    /**
     * @param arg of file
     */
    public Object execute(Object arg) throws IOException, ClassNotFoundException {
        try {
            ClientSender sender = App.getSender();
            ClientReceiver receiver = App.getReceiver();
            String data = ReaderFromFile.read((String) arg);
            Commands command = new Commands();
            String res = "";
            //System.out.println("data " + data);
            if (data != null) {
                String[] commands = data.split("\n|\r\n");
                //System.out.println("command.lenght " + commands.length);
                for (int i = 0; i < commands.length; i++) {
                    if (!(commands[i].equals("execute_script "+ arg))) {
                        command.setCommand(commands[i]);
                        if (command.getCommand() != null) {
                            String tempCommandName = commands[i];
                            String received = "";
                            sender.sendCommand(command);
                            String whyFailed = "";
                            if (sender.isCommandWithObject())
                                if (receiver.receive().equals("newHuman")) {
                                    String[] params = new String[11];
                                    for (int j = 0; j < 11; j++) {
                                        i++;
                                        params[j] = commands[i];
                                    }
                                    HumanBeing newHuman = creater.createFromFile(params);
                                    if (newHuman != null)
                                        sender.send(newHuman);
                                    else {
                                        whyFailed = creater.getWhyFailed();
                                        sender.send(new HumanBeing());
                                    }
                                }
                            receiver.receiveCollection();
                            received = receiver.receive();
                            if (received != null) {
                                res += "Выполнение команды \"" + tempCommandName + "\":\n" + received + whyFailed + "\n\n";
                                ;
                            }
                        }
                        if (command.getMessage() != (null)) {
                            String[] sentence = command.getMessage().split(",");
                            res += "Командa \"" + commands[i] + "\": " + sentence[0] + ".\n\n";
                    }
                    }else res += "Командa \"" + commands[i] + "\": невыполнима.\n";
                }
            }
            System.out.print(res);
            return "";
        } catch (NullPointerException e) {
            return null;
        }

    }
}


