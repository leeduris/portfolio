/////////////////////////////////////////////
// WebBrowserModel.java
// ================
// M in MVC Classes.
//
// AUTHOR: Sung Woo Lee (leeduris@gmail.com)
// CREATED: 2016-03-14
// UPDATED: 2016-03-23
/////////////////////////////////////////////

package woo;

import java.util.ArrayList;

public class WebBrowserModel 
{
    // local variables
    ArrayList stack;
    int currentIndex;

    public WebBrowserModel() 
    {
        // container of URL history
        stack = new ArrayList();
        
        // no item by default
        currentIndex = -1;
        
    }
    
    public String prev()
    {
        // decrease index number and return previous url
        if(currentIndex > 0)
            return stack.get(--currentIndex).toString();
        else 
            return null;
    }
    
    public String next()
    {
        // increase index number and return next url
        if(currentIndex < stack.size()-1)
            return stack.get(++currentIndex).toString();
        else
            return null;
    }
    
    public void push(String url)
    {
        // add a new value of URL 
        stack.add(url);
        
        // increase index number
        currentIndex++;        
    }    
    
    
    public ArrayList getStack()  // getter
    {
        return stack;
    }

    public int getCurrentIndex()  // getter
    {
        return currentIndex;
    }
    
    
    
    
    
    
    
    
    
    
}
