import java.util.Scanner;

import commands.Command;
import commands.CommandsDict;
import commands.History;
import worker.*;


public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        FileReader.readFile("output.csv");
//        FileReader.readFile(System.getenv("CollectionFile"));
        while (true) {
            System.out.print(">>");
            String[] commandName = cin.nextLine().trim().split(" ");
            if(commandName[0].equals(""))continue;
            if (new CommandsDict().getCommandsManger().containsKey(commandName[0])) {
                Command cmd = new CommandsDict().getCommandsManger().get(commandName[0]);
                if (commandName.length > 1) cmd.setArg(commandName[1]);
                if (cmd.getArg() != null) {
                    cmd.execute();
                    History.move(commandName[0]);
                } else {
                    System.out.println("Arg can't be null");
                }
            } else {
                System.out.println("The Command wasn't found");
            }

        }


    }


}
