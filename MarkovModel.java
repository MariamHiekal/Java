
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovModel extends AbstractMarkovModel{
    private int N;
    public String toString()
    {
        return "Markov Model of order "+N;
    }
    public void setN(int n)
    {
        N = n;
    }
    public MarkovModel(int n)
    {
        N=n;
    }
    //private String myText;
    //private Random myRandom;
    
    public MarkovModel() 
    {
        myRandom = new Random();
    }
    
    public void setRandom(int seed)
    {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s)
    {
        myText = s.trim();
    }
    
    public String getRandomText(int numChars)
    {
        if (myText == null)
        {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - N);
        String key = myText.substring(index , index + N);
        sb.append(key);
        
        for(int k = 0 ; k < numChars - N ; k++)
        {
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0 )
            {
                break;
            }           
            //find most accur charater then add to sb
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = next;
        }            
        return sb.toString();
    }
    //working regardless the length of the key
    

}
