import java.util.ArrayList;
/**
 * ArrayList Assignment 2 
 * Question 1
 * @author Jason Shi 
 */
public class Question1
{

    public ArrayList<Integer> Eratosthenes (int n) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int p = 2;
        int threshold = 0;
        for(int i = 0; i < n-1; i++){
            if(i <=n) ans.add(i,i+2); //creating the list of ordered 
            //sequence of numbers from 2 to n
        }

        for(int i = 0; i < n-threshold; i++){
            if(ans.get(i) % p == 0 && ans.get(i) > p ){
                ans.remove(i);
                threshold++;
            }
        }
        // p = ans.get(0);
        return ans;
    }

    public static void test(){
        int n = 20;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int p = 2;

        for(int i = 0; i < n-1; i++){
            if(i <=n) 
                ans.add(i,i+2);
        }
        System.out.println(ans);
    }

    public static void main(String args[]){
        Question1.test();
    }
}