package us.hgmtrebing.Effectual.cli;

import org.apache.commons.cli.Options;

import java.util.Scanner;

public class InteractiveCommandLine {
    private boolean isRunning = false;
    private Options options;


    private void generateCommandLineOptions () {
        this.options = new Options();
        for (MainCommand command : MainCommand.values()) {
            options.addOption(command.getShortName(), command.getLongName(), command.isHasArg(), command.getDescription());
        }
    }

    public void start() {
        printMessage("Welcome to the Effectual Command Line Application!");
        this.isRunning = true;
        while(this.isRunning) {
            String input = promptUser(">>");
            processInput(input);
        }
    }

    public void processInput(String input) {
        switch (input) {
            case "exit":
                this.exit();
                break;

            case "quit":
                this.exit();
                break;

            default:
                printMessage("Unrecognized command received: " + input);
                break;
        }
    }

    public void exit() {
        printMessage("Exiting Effectual Command Line Application. Thank you for visiting!");
        this.isRunning = false;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String promptUser(String promptMessage) {
        System.out.print(promptMessage);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
