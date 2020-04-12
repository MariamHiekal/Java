
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel{
    public String toString()
    {
        return "This is EfficientMarkovModel";
    }
    private int N;
    public void setN(int n)
    {
        N = n;
    }
    public EfficientMarkovModel(int n)
    {
        N=n;
        map = new HashMap<String,Integer>();
    }
    
    public EfficientMarkovModel() 
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
    private HashMap<String,Integer> map;
    public void buildMap()
    {
        
    }
    public void printHashMapInfo(){
        //print hashMap
        
        //print number of keys
        
        //print the size of the largest ArrayList
        
        //print the keys that have maximum size value
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
