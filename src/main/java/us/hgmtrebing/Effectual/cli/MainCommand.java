package us.hgmtrebing.Effectual.cli;

public enum MainCommand {

    QUIT("quit", "q", false, "Exit the Effectual Command Line."),
    HELP("help", "h", false, "Displays the 'Help' Prompt for Effectual"),
    MAKE("make", "mk", true, "Creates an "),
    LIST("list", "ls", true, ""),
    REMOVE("remove", "rm", true, ""),
    MODIFY("modify", "md", true, "")
    ;
    private String longName;
    private String shortName;
    private boolean hasArg;
    private String description;

    MainCommand(String longName, String shortName, boolean hasArg, String description) {
        this.longName = longName;
        this.shortName = shortName;
        this.hasArg = hasArg;
        this.description = description;
    }

    public String getLongName() {
        return longName;
    }

    public String getShortName() {
        return shortName;
    }

    public boolean isHasArg() {
        return hasArg;
    }

    public String getDescription() {
        return description;
    }
}
