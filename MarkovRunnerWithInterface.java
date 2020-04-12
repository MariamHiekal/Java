
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 
import java.util.*;
public class MarkovRunnerWithInterface {
    public void testHashMap()
    {
        //EfficientMarkovModel m = new EfficientMarkovModel(2);
        //String s = "yes-this-is-a-thin-pretty-pink-thistle";
        //runModel(m , s , 20 , 42);
        
        //EfficientMarkovModel m = new EfficientMarkovModel(3);
        //String s = "yes-this-is-a-thin-pretty-pink-thistle";
        //runModel(m , s , 50 , 25);
    }
    void compareMethods(){}
    public void runModel(IMarkovModel markov, String text, int size,int seed) {
        markov.setTraining(text);       
        markov.setRandom(seed);
        System.out.println("running with " + markov.toString());
        for(int k=0; k < 3; k++){
            String st= markov.getRandomText(size);
            printOut(st);
        }
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        int size = 200;
        
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size,25);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size,25);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size,25);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size,25);

    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println();
                psize = 0;
            }
        }
        System.out.println("\n----------------------------------");
    }
    
}
