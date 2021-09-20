package com.main;

//Jesse loves cookies and wants the sweetness of some cookies to be greater than value K
//        Fetch the list of cookies and sort in ascending order.
//        Initialize a counter to zero
//        If the smallest cookie is less than K, then:
//        (a) Increment the counter and combine this cookie with the next smallest cookie (or return -1 if there are fewer than 2 cookies left)
//        (b) Remove the two smallest cookies from the list and add the new cookie to the list
//        (c) Sort the list in ascending order again
//        Otherwise, exit with the value of the counter
//        Go back to step 3
//pake linkedlist kena di java timeout exception dari test case 10 - 15

//sweetness  1x 1st Least sweet cookie   + 2 x 2nd least sweet cookie).

//6 7                 A[] size n = 6, k = 7
//1 2 3 9 10 12       A = [1, 2, 3, 9, 10, 12]

//6 7
//1 2 3 9 10 12

//k > 7
// remove 2 smallest = 1,2. 1+2x2 = 5 , [3,5,9,10,12]
// remove 2 smallest = 3,5. 3 + 2x5 = 13 [9,10,12,13]
// 2 iterations


import java.util.*;
public class Main {

    private static int getMinStepsToGetValueK(long k,PriorityQueue<Integer> newPq){
        //pakai priorityqueue karna lebih cepat eksekusi time nya dan tidak timeout pada test case yang mempunyai list data yang banyak
        // Dalam antrian berprioritas, setiap elemenn yang akan msuk dalam antrian sudah ditentukan lebih dahulu prioritasnya.
        // Dalam hal ini berlaku dua ketentuan, yaitu: 1. Elemen-elemen yang mempunyai prioritas lebih tinggi akan diproses lebih dahulu.
        // 2. Dua elemen yang mempunyai prioritas sama akan dikerjakan sesuai dengan urutan pada saat kedua elemen ini masuk dalam antrian.
        //priority queue using FIFO algorithm, unbounded queue (tidak terbatas)
        //
        int count=0;
        //Retrieves, but does not remove, the head of this queue, returning null if this queue is empty.
        while(newPq.peek()<k) {
            //return number of element
            if(newPq.size()>=2) {
                count++;
                //remove 2 smallest cookies from the list
                //Retrieves and removes the head of this queue, or null if this queue is empty.
                int removeFirst = newPq.poll();
                int removeSecond = newPq.poll();
                //add the new cookie to the list
                //kalau offer di pq akan mengembalikan false jika null, kalau di linkedlist akan throw exp
                newPq.offer(removeFirst+(removeSecond*2)); // 1 1st least sweet + (2x 2nd least sweet)
            }
            else {
                return -1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanObj = new Scanner(System.in);
        int totOfCookies = scanObj.nextInt();
        long k = scanObj.nextLong();
        PriorityQueue<Integer> newPq = new PriorityQueue<Integer>();
        //get all the cookies
        for(int i=0;i<totOfCookies;i++) {
            newPq.offer(scanObj.nextInt());
        }
        System.out.println(getMinStepsToGetValueK(k,newPq));
    }

}
