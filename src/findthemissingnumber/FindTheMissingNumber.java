/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findthemissingnumber;

import static java.util.Arrays.sort;
import java.util.Scanner;

/**
 *
 * @author AMIT
 */
public class FindTheMissingNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size ");
        int size=sc.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        //method 1 sort and find
        int arr1[]=arr;
        sort(arr1);
        for(int i=0,j=1;i<size;i++,j++){
            if(arr1[i]!=j){
                System.out.println("Missing = "+j); 
                break;
            }
            else if(i==size-1){
                System.out.println("Method 1 Missing = "+(size+1));
            }
        }
        //method 2 math
        int sum=0;
        for(int i=0;i<size;i++)
            sum+=arr[i];
        int sum2 = (size+1)*(size+2)/2;
        System.out.println("method 2 missing = "+(sum2-sum));
        
        //Method 3 hashing
        int hash[] = new int[size+2];
        for(int i=0;i<=(size+1);i++)
            hash[i]=0;
        for(int i=0;i<size;i++)
            hash[arr[i]] = arr[i];
        for(int i=1;i<=(size+1);i++)
            if(hash[i]==0) System.out.println("method 3 missing = "+i);
        
        //Method 4 bit oprations
        int s=arr[0];
        int sn=1;
        for(int i=1;i<size;i++)
            s^=arr[i];
        for(int i=2;i<=size+1;i++)
            sn^=i;
        System.out.println("method 4 missing = "+(sn^s));
    }
    
    
    
}
