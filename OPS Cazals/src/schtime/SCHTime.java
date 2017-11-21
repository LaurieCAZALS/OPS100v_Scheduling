package schtime;
import java.util.Scanner;

public class SCHTime {
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int avgwt = 0;
        int avgtt = 0;
        int choice;
        boolean b = true;
        
        
        while (b)
        {
            System.out.println("\nChoose your scheduling algorithm ? \n\n1)FCFS (First come, First Served)\n2) SJF (Shortest Job First\n3)SRTN ()\n4)RR()\n5)Multilevel Queue()\n");
            choice = in.nextInt();
            System.out.println("Enter the number of processes : ");
            int a = in.nextInt();

            //int[]tab = new int[a];
            int[]burstTimes = new int[a];
            int[]arrivalTimes = new int[a];
            int[] processes = new int[a];         
            int[] exitTimes = new int[a];
            int[] TurnAroundTimes = new int[a];
            int[] waitingTimes = new int[a];

            
            switch (choice)
            {
                case 1:
                    
                    //read Arrival times
                    for (int i = 0; i < a; i++)
                    {
                        System.out.print("Enter Process  " + (i + 1) + "'s   Arrival Time : ");
                        arrivalTimes[i] = in.nextInt();
                        System.out.print("Enter Process   " + (i + 1) + "'s   Burst Time : ");
                        burstTimes[i] = in.nextInt();
                        processes[i] = i;
                        
                    }   
                    
                    System.out.println();
                 
                    // Sort by arrival Times
                    for (int i = 0; i <= a; i++){
                        for (int j = i + 1; j < a; j++)
                            if (arrivalTimes[i] > arrivalTimes[j])
                            {
                                // swap in arrival times
                                int tempAr = arrivalTimes[i];
                                arrivalTimes[i] = arrivalTimes[j];
                                arrivalTimes[j] = tempAr;

                                //swap in burst times too
                                int tempBr = burstTimes[i];
                                burstTimes[i] = burstTimes[j];
                                burstTimes[j] = tempBr;
                            }
                    }

                    // calculate exit times
                    exitTimes[0] = burstTimes[0];
                    for (int k = 1; k < a; k++){
                         exitTimes[k] = exitTimes[k - 1] + burstTimes[k];
                    }
                    
                    //calculate turnaround times for each process
                    for (int i = 0; i < a; i++){
                         TurnAroundTimes[i]= exitTimes[i] - arrivalTimes[i];
                    }
                    
                    //calculate waiting times for each process
                    for (int i = 0; i < a; i++){
                        waitingTimes[i]= TurnAroundTimes[i] - burstTimes[i];
                    }
                    
                    // Calculate Average WaitingTimes
                    for(int i = 0; i <a; i ++) { 
                        avgwt += waitingTimes[i];
                    }
                    
                    // Calculate Average TurnAroundTimes
                     for(int i = 0; i <a; i ++){
                        avgtt += TurnAroundTimes[i];
                    }
                     
                    // Displaying  Arrival, Burst, Exit, TurnAround and Waiting times : 
                    System.out.println("\nArrival Times:");
                    for (int k = 0; k < a; k++){
                        System.out.print(arrivalTimes[k] + "  |  ");
                    }
                    
                    System.out.println("\nBurst Times:");
                    for (int p = 0; p < a; p++){
                        System.out.print(burstTimes[p] + "  |  ");
                    }  

                    System.out.println("\nExit Times:");
                    for (int k = 0; k < a; k++){
                        System.out.print(exitTimes[k] + "  |  ");
                    }
                    
                    System.out.println("\nTurnAround Times:");
                    for (int i = 0; i < a; i++) {
                        System.out.print(TurnAroundTimes[i] + "  |  ");
                    }
                    
                    System.out.println("\nWaiting Times:");
                    for (int i = 0; i < a; i++){
                        System.out.print(waitingTimes[i] + "  |  ");
                    }
                    System.out.println("");
                    System.out.println("\nAverage Turnaround Time = " +avgtt/a);
                    System.out.println("Average  Waiting Time = "+ avgwt/a);
                 break;
                 
                 
                 
                 
                 
                case 2:
                                         
                    //read Arrival times
                    for (int i = 0; i < a; i++)
                    {
                        System.out.print("Enter Process  " + (i + 1) + "'s   Arrival Time : ");
                        arrivalTimes[i] = in.nextInt();
                        System.out.print("Enter Process   " + (i + 1) + "'s   Burst Time : ");
                        burstTimes[i] = in.nextInt();
                        processes[i] = i;
                        
                    }   
                    System.out.println();
                 
                    // Sort by arrival Times
                    for (int i = 0; i <= a; i++){
                        for (int j = i + 1; j < a; j++)
                            if (burstTimes[i] > burstTimes[j])
                            {                                                           
                                //swap in burst times                                
                                int tempBr = burstTimes[i];
                                burstTimes[i] = burstTimes[j];
                                burstTimes[j] = tempBr;

                                // swap in arrival times
                                int tempAr = arrivalTimes[i];
                                arrivalTimes[i] = arrivalTimes[j];
                                arrivalTimes[j] = tempAr;                               
                            }
                    }

                    // calculate exit times
                    exitTimes[0] = burstTimes[0];
                    for (int k = 1; k < a; k++){
                         exitTimes[k] = exitTimes[k - 1] + burstTimes[k];
                    }
                    
                    //calculate turnaround times for each process
                    for (int i = 0; i < a; i++){
                         TurnAroundTimes[i]= exitTimes[i] - arrivalTimes[i];
                    }
                    
                    //calculate waiting times for each process
                    for (int i = 0; i < a; i++){
                        waitingTimes[i]= TurnAroundTimes[i] - burstTimes[i];
                    }
                    
                    // Calculate Average WaitingTimes
                    for(int i = 0; i <a; i ++) { 
                        avgwt += waitingTimes[i];
                    }
                    
                    // Calculate Average TurnAroundTimes
                     for(int i = 0; i <a; i ++){
                        avgtt += TurnAroundTimes[i];
                    }
                     
                    // Displaying  Arrival, Burst, Exit, TurnAround and Waiting times : 
                    System.out.println("\nArrival Times:");
                    for (int k = 0; k < a; k++){
                        System.out.print(arrivalTimes[k] + "  |  ");
                    }
                    
                    System.out.println("\nBurst Times:");
                    for (int p = 0; p < a; p++){
                        System.out.print(burstTimes[p] + "  |  ");
                    }  

                    System.out.println("\nExit Times:");
                    for (int k = 0; k < a; k++){
                        System.out.print(exitTimes[k] + "  |  ");
                    }
                    
                    System.out.println("\nTurnAround Times:");
                    for (int i = 0; i < a; i++) {
                        System.out.print(TurnAroundTimes[i] + "  |  ");
                    }
                    
                    System.out.println("\nWaiting Times:");
                    for (int i = 0; i < a; i++){
                        System.out.print(waitingTimes[i] + "  |  ");
                    }
                    System.out.println("");
                    System.out.println("\nAverage Turnaround Time = " +avgtt/a);
                    System.out.println("Average  Waiting Time = "+ avgwt/a);
                    
                    break;
                    
                    
                case 3: 
                    //read Arrival times
                    for (int i = 0; i < a; i++)
                    {
                        System.out.print("Enter Process  " + (i + 1) + "'s   Arrival Time : ");
                        arrivalTimes[i] = in.nextInt();
                        System.out.print("Enter Process   " + (i + 1) + "'s   Burst Time : ");
                        burstTimes[i] = in.nextInt();
                        processes[i] = i;
                        
                    }   
                    System.out.println();
                 
                    // Sort by arrival Times and burst times 
                    for (int i = 0; i <= a; i++){
                        for (int j = i + 1; j < a; j++)
                            if (burstTimes[i] < burstTimes[j])
                            {                                                           
                                //swap in burst times                                
                                int tempBr = burstTimes[i];
                                burstTimes[i] = burstTimes[j];
                                burstTimes[j] = tempBr;

                                // swap in arrival times
                                int tempAr = arrivalTimes[i];
                                arrivalTimes[i] = arrivalTimes[j];
                                arrivalTimes[j] = tempAr;                               
                            }
                    }

                    // calculate exit times
                    exitTimes[0] = burstTimes[0];
                    for (int k = 1; k < a; k++){
                         exitTimes[k] = exitTimes[k - 1] + burstTimes[k];
                    }
                    
                    //calculate turnaround times for each process
                    for (int i = 0; i < a; i++){
                         TurnAroundTimes[i]= exitTimes[i] - arrivalTimes[i];
                    }
                    
                    //calculate waiting times for each process
                    for (int i = 0; i < a; i++){
                        waitingTimes[i]= TurnAroundTimes[i] - burstTimes[i];
                    }
                    
                    // Calculate Average WaitingTimes
                    for(int i = 0; i <a; i ++) { 
                        avgwt += waitingTimes[i];
                    }
                    
                    // Calculate Average TurnAroundTimes
                     for(int i = 0; i <a; i ++){
                        avgtt += TurnAroundTimes[i];
                    }
                     
                    // Displaying  Arrival, Burst, Exit, TurnAround and Waiting times : 
                    System.out.println("\nArrival Times:");
                    for (int k = 0; k < a; k++){
                        System.out.print(arrivalTimes[k] + "  |  ");
                    }
                    
                    System.out.println("\nBurst Times:");
                    for (int p = 0; p < a; p++){
                        System.out.print(burstTimes[p] + "  |  ");
                    }  

                    System.out.println("\nExit Times:");
                    for (int k = 0; k < a; k++){
                        System.out.print(exitTimes[k] + "  |  ");
                    }
                    
                    System.out.println("\nTurnAround Times:");
                    for (int i = 0; i < a; i++) {
                        System.out.print(TurnAroundTimes[i] + "  |  ");
                    }
                    
                    System.out.println("\nWaiting Times:");
                    for (int i = 0; i < a; i++){
                        System.out.print(waitingTimes[i] + "  |  ");
                    }
                    System.out.println("");
                    System.out.println("\nAverage Turnaround Time = " +avgtt/a);
                    System.out.println("Average  Waiting Time = "+ avgwt/a);
                    
                    break;
                    
            default:
                    System.out.println("You entered a wrong number");
            break;
        }
    }    
}
}
