package ejd;

import java.io.PrintWriter;

public final class HtmlUtil { 
    
    // ctor: prevent from creating instance of it 
    private HtmlUtil() {        
    } 
    
    // print html header part: <html> ...</head><body> 
    public static void printHeader(PrintWriter out, String title, String css) 
    {
        // validate args
        if(out == null)
            return;
        if(title == null)
            title = "";
        if(css == null)
            css = "";
        
        out.println("<!DOCTYPE html>\n" + 
                "<html lang=\"en\">\n" + 
                "    <head>\n" +
                "        <title>" + title + "</title>\n" +
                         css + "\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "    </head>\n" +
                "    <body>\n");
    }
    
    // method overloading with 2 params
    public static void printHeader(PrintWriter out, String title)
    {
        printHeader(out, title, "");        
    }
    
    // print html footer part: </body></html> 
    public static void printFooter(PrintWriter out) {
        out.println("</body>\n</html>");
    }        
   
    
}

