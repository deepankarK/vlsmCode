import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    //global variables
    static Scanner input = new Scanner(System.in);
    static int subnetNumber;

    //taking user input for number of subnet
    public int numberOfSubnet(){
        System.out.print("Please enter number of subnet for which \nyou want to find vlsm: ");
        return subnetNumber = input.nextInt();
    }

    //taking user's hosts input
    public int[] inputSubnetHosts(){
        int[] subnetHosts = new int[subnetNumber];
        for(int i = 0; i < subnetHosts.length; i++){
            System.out.print((i+1) + " subnet's number of hosts: ");
            subnetHosts[i] = input.nextInt();
        }
        return subnetHosts;
    }

    //assigning subnet block to the hosts provided by the user
    public int[] calculateBlocks(int[] hosts){
        int[] blocks = new int[subnetNumber];
        for(int i = 0; i < hosts.length; i++){
            if(hosts[i] <= 126 || hosts[i] > 64){   //for 128 hosts
                blocks[i] = 128;
            } else if (hosts[i] <=62 || hosts[i] > 32) {  //for 64 hosts
                blocks[i] = 64;
            }else if (hosts[i] <=30 || hosts[i] > 16) {  //for 32 hosts
                blocks[i] = 32;
            } else if (hosts[i] <=14 || hosts[i] > 8) {  //for 16 hosts
                blocks[i] = 16;
            } else if (hosts[i] <=6 || hosts[i] > 4) {  //for 8 hosts
                blocks[i] = 8;
            } else if (hosts[i] <= 2 || hosts[i] > 1) {  //for 4 hosts
                blocks[i] = 4;
            } else if (hosts[i] <= 1 || hosts[i] >= 0) {  //for 2 hosts
                blocks[i] = 2;
            }else {
                blocks[i] = 0;
            }
        }
        Arrays.sort(blocks);
        reverse(blocks);
        return blocks;
    }

//    public int[] calculateNetworkAddress(){
//        int[] networkAddress = new int[subnetNumber];
//        networkAddress[0] = 0;
//
//    }

    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Welcome to VLSM Project");
        System.out.println("--------------------------");
        System.out.println();
        obj.numberOfSubnet();
        System.out.println(Arrays.toString(obj.calculateBlocks(obj.inputSubnetHosts())));


    }


    public static void reverse(int[] array)
    {

        // Length of the array
        int n = array.length;

        // Swaping the first half elements with last half
        // elements
        for (int i = 0; i < n / 2; i++) {

            // Storing the first half elements temporarily
            int temp = array[i];

            // Assigning the first half to the last half
            array[i] = array[n - i - 1];

            // Assigning the last half to the first half
            array[n - i - 1] = temp;
        }
    }
}
