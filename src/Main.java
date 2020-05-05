import ClientSocket.App;
import ClientSocket.ClientReceiver;
import ClientSocket.ClientSender;
import Commands.*;

import java.io.IOException;
import java.net.BindException;


public class Main {//Client

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        String filename = "";
        int clientPort = -10;
        int serverPort = 1347;
        if (args.length != 0) {
            try {
                clientPort = Integer.parseInt(args[0]);
            } catch (Exception e) {
                System.out.println("Неверно указаны данные. В дальнейшем при запуске программы обязательно указывайте порт(целое число) и имя файла.");
            }
            if (args.length > 1) filename = args[1];
        } else {
            System.out.println("Неверно указаны данные. В дальнейшем при запуске программы обязательно указывайте порт(целое число) и имя файла.");
        }
        if (clientPort < 0) clientPort = ClientReceiver.getClientPortFromClient();
        Help help = new Help();
        Show show = new Show();
        Remove_by_id remove_by_id = new Remove_by_id();
        Exit exit = new Exit();
        Clear clear = new Clear();
        Info info = new Info();
        Remove_first remove_first = new Remove_first();
        Remove_lower remove_lower = new Remove_lower();
        Add add = new Add();
        Update update = new Update();
        Count_less_than_impact_speed count_less_than_impact_speed = new Count_less_than_impact_speed();
        History history = new History();
        Execute_script execute_script = new Execute_script();
        Print_ascending print_ascending = new Print_ascending();
        Commands commands = new Commands();
        commands.regist(help, history, exit, show, remove_by_id, clear, info, remove_first, remove_lower, add, update, count_less_than_impact_speed, print_ascending, execute_script);
        try {
            ClientReceiver receiver = new ClientReceiver(clientPort);
            ClientSender sender = new ClientSender(serverPort, clientPort);
            App app = new App(sender, receiver);
            app.setFilename(filename);
            app.begin();
            app.run();
        } catch (BindException e) {
            System.out.println("Этот порт уже занят=(");

        }
    }
}

