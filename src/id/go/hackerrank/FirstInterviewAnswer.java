/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.hackerrank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;

/**
 *
 * @author user
 */
public class FirstInterviewAnswer {

    static final int V=9; 
    static int minDistance(int dist[], Boolean sptSet[]) 
    { 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
    static void printSolution(int dist[], int n){ 
        System.out.println("Vertex Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i+" tt "+dist[i]); 
    } 
    static void dijkstra(int graph[][], int src) { 
        int dist[] = new int[V]; 
        Boolean sptSet[] = new Boolean[V]; 
  
        for (int i = 0; i < V; i++){ 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        dist[src] = 0; 
  
        for (int count = 0; count < V-1; count++){ 
            int u = minDistance(dist, sptSet); 
            sptSet[u] = true; 
            for (int v = 0; v < V; v++) 
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
        printSolution(dist, V); 
    } 
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        validasiSatu();
//        validasiDua(); 
        int vertices = 3;
        
        String a= "makan";
        System.out.println(a.substring(a.length()-1, a.length()));



        
        
//        String[][key] arr = {{"value1","value2"},{"valueA"}};
//        System.out.println(Arrays.deepToString(arr));
//        System.out.println(arr[0][1]);
        
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("key1", "value1");
//        map.put("key2", "value2");
//        map.put("keyA", "valueA");
//        map.put("keyB", "valueB");
//        
//        System.out.println(map);
        
    }
    private static void validasiSatu(){
        Scanner input = new Scanner(System.in);
        System.out.println("Soal 1");
        System.out.println("Masukkan kalimat yang ingin dicheck:");
        
        String readInput = input.nextLine();
        System.out.println("Jawaban:");
        
        //satuA
        char[] ch1 = readInput.toCharArray();
        System.out.println("Semua karakter (case insensitive)");
        operasiSatu(ch1);
        
        //satuB
        String[] split = readInput.split(" ");
        char[] ch2 = new char[split.length];
        for(int i=0; i<split.length; i++){
            ch2[i]=split[i].charAt(0);
        }
        System.out.println("Karakter pertama dari setiap kata ");
        operasiSatu(ch2);
    }
    
    private static void validasiDua() {
        Scanner input = new Scanner(System.in);
        System.out.println("Soal 2");
        System.out.println("Masukkan titik koordinat, ex: (3,4) satu titik");
        System.out.println("                              (3,4),(4,5),(5,6)... banyak titik");
        
        String readInput = input.nextLine();
        String[] dataIn = readInput.replace("(", "").replace(")", "").split(",");
        Integer[] dataInt = new Integer[dataIn.length];
        
        for (int i = 0; i < dataIn.length; i++) {
            dataInt[i]=new Integer(dataIn[i]);
        }
        
        if(dataInt.length%2 == 1){
            System.out.println("format data yang anda masukkan salah silahkan masukkan kembali..");
            validasiDua();
        }else{
            System.out.println("Jawaban:");
            operasiDua(dataInt);
        }
    }

    private static void operasiSatu(char[] ch) {
        int length = ch.length;
        int[] count = new int[256];
        String[] result = new String[length];
        
        //counting 
        for (int i = 0; i < length; i++) {
            count[ch[i]]++;
        }
        
        //compare
        for(int i=0; i<length; i++){
            int find = 0;
            for(int j=1; j<length;j++){
                if(ch[i]==ch[j])
                    find++;      
            }
            if(find>=0){
               result[i] = ch[i]+" "+count[ch[i]]; 
            }    
        }
        
        //print
        for(int i=0;i<result.length;i++){
            boolean isDistinct = false;
            for(int j=0;j<i;j++){
                if(result[i].equals(result[j])){
                    isDistinct = true;
                    break;
                }
            }
            if(!isDistinct && !result[i].contains("  ")){
                System.out.println(result[i]+" ");
            }
        }
        System.out.println("");
    }

    private static void operasiDua(Integer[] dataXY) {
        double jarak = 0D;
        List<Integer> xList = new ArrayList<>(); 
        List<Integer> yList = new ArrayList<>();
        for(int i=0; i<dataXY.length; i++){
            if(i==0 || i%2==0) xList.add(dataXY[i]);
            else yList.add(dataXY[i]);
        }
        jarak = Math.sqrt(xList.get(0)*xList.get(0) + yList.get(0)*yList.get(0));
        for(int i=0; i<xList.size(); i++){
            double temp = Math.sqrt(xList.get(i)*xList.get(i) + yList.get(i)*yList.get(i));
            if(jarak > temp || jarak == temp)
                jarak = temp;
            System.out.println("Titik ("+ xList.get(i)+","+yList.get(i)+") jarak "+String.format("%.2f", temp));
        }
        for(int i=0; i<xList.size(); i++){
            if(Math.sqrt(xList.get(i)*xList.get(i) + yList.get(i)*yList.get(i)) == jarak){
                System.out.println("Titik terdekat (x,y) adalah ("+ xList.get(i)+","+yList.get(i)+")");
                break;
            }  
        }
    }

    
    
}
