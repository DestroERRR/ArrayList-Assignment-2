import java.util.ArrayList;
/**
 * ArrayList Assignment 2 
 * Question 1-3
 * Q1: Sieve of Eratosthenes 
 * Q2: Goldbach Conjuncture
 * Q3: BigInts
 * @author Jason Shi 
 */
public class Assignment2
{
    /**
    @param n - any integer
    @return - returns all prime numbers < n
     */

    public static ArrayList<Integer> Eratosthenes (int n) { 
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int p = 2;
        for(int i = 0; i < n-1; i++){
            if(i <=n) ans.add(i,i+2); //creating the list of ordered 
            //sequence of numbers from 2 to n
        }

        for(int j = 1; j < n; j++){
            for(int i = 0; i < n; i++){ 
                if(i < ans.size()){ //so ArrayListOutOfBoundsException is 
                                    //not possible
                    if(ans.get(i) % p == 0 && ans.get(i) > p ){
                        ans.remove(i);
                    }
                }
            }
            if(j < ans.size()) p = ans.get(j);
        }
        return ans;
    }

    /**
     * @param n - any EVEN integer 
     * @return - n as the sum of 2 prime numbers 
     */
    public static void Goldbach(int n) {
        if(n % 2 == 1) System.out.println("This method can only take in EVEN INTEGERS");
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans = Eratosthenes(n);
        int j = 0;
        int ans1 = 0;
        int ans2 = 0;
        for(int i = 0; i < ans.size(); i++){
            if(ans.get(j) + ans.get(i) == n) {
                ans1 = ans.get(j);
                ans2 = ans.get(i);
                break;
            } else{
                j++;
                i = 0;
            }
        }

        System.out.println(n + " = " + ans1 + " + " + ans2);
    }

    public static ArrayList<Integer> add (ArrayList<Integer> x , ArrayList<Integer> y) {
        ArrayList<Integer> ans = new ArrayList<Integer>();

        //These 2 while loops will add 0's to the front of the list
        //for whichever list is smaller till it reaches the same size
        //as the bigger list so the column values match eachother
        while(x.size() > y.size()){
            y.add(0,0); 
        }
        while(x.size() < y.size()){
            x.add(0,0); 
        }

        for(int i = x.size()-1; i >= 0; i--){
            ans.add(0,x.get(i)+y.get(i));
            if(ans.get(0) >= 10){
                ans.set(0,x.get(i)+y.get(i)-10);
                if(x.size() == 1) ans.add(0,1);
                else if(i-1 >= 0) x.set(i-1,x.get(i-1)+1);
                else ans.add(0,1);
            }
        }

        return ans;
    }

    public static void main(String args[]){
        //For Testing the methods 
        /*ArrayList<Integer> test1 = new ArrayList<Integer>();
        ArrayList<Integer> test2 = new ArrayList<Integer>();

        test1.add(5);
        test1.add(0);
        test1.add(0);

        test2.add(1);
        test2.add(0);
        test2.add(0);
        test2.add(0);

        System.out.println(Assignment2.add(test1,test2));
         */
        System.out.println(Assignment2.Eratosthenes(100));

    }
}