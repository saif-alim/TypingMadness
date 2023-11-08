// class to hold colour variables of the two themes
public class HexColours {
    
    protected String background;
    protected String foreground;
    protected String altBackground;
    protected String altForeground;

    private FileInfo fileInfo;

    public HexColours(){
        fileInfo = new FileInfo();
        String theme = fileInfo.getTheme();
        
        if (theme.equals("light")){
            background = "#ccb7ae";
            foreground = "#565264";
            altBackground = "#d6cfcb";
            altForeground = "#a6808c";
        }
        else{
            background = "#565264";
            foreground = "#ccb7ae";
            altBackground = "#706677";
            altForeground = "#a6808c";
        }
    }

    public HexColours(String theme){
        if (theme.equals("light")){
            background = "#ccb7ae";
            foreground = "#565264";
            altBackground = "#d6cfcb";
            altForeground = "#a6808c";
        }
        else{
            background = "#565264";
            foreground = "#ccb7ae";
            altBackground = "#706677";
            altForeground = "#a6808c";
        }
    }
}
