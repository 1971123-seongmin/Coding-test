import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static char candy[][];
	public static int size;
	public static int max = 0;
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        StringTokenizer st = new StringTokenizer(n);
        size = Integer.parseInt(n);
        candy = new char[size][size];
        
        //사탕 입력
        for (int i = 0; i < size; i++) {
            String s = br.readLine();
            for (int j = 0; j < size; j++) {
                candy[i][j] = s.charAt(j);
            }
        }
        //행 탐색
        for(int i=0; i<size; i++) {
        	for(int j=0; j<size - 1; j++) { 
        		char swap = candy[i][j];
        		candy[i][j] = candy[i][j+1];
        		candy[i][j+1] = swap;
        		max = search(); //최대값 확인
        		
        		//원상복구
        		swap = candy[i][j];
        		candy[i][j] = candy[i][j+1];
        		candy[i][j+1] = swap;
        	}
        }
        //열 탐색
        for(int i=0; i<size; i++) {
        	for(int j=0; j<size - 1; j++) { 
        		char swap = candy[j][i];
        		candy[j][i] = candy[j+1][i];
        		candy[j+1][i] = swap;

        		max = search();
        		
        		//원상복구
        		swap = candy[j][i];
        		candy[j][i] = candy[j+1][i];
        		candy[j+1][i] = swap;
        	}
        }
        
        System.out.println(max);
    }
    private static int search() {
    	
    	for (int i=0; i < size; i++) {
    		int cnt = 1;
    		for(int j=0; j < size-1; j++) {
    			if(candy[i][j] == candy[i][j+1]) cnt++;
    			else cnt = 1;
    			max = Math.max(max, cnt);
    		}
    	}
    	
    	for (int i=0; i<size; i++) {
    		int cnt = 1;
    		for(int j=0; j<size-1; j++) {
    			if(candy[j][i] == candy[j+1][i]) cnt++;
    			else cnt = 1;
    			max = Math.max(max, cnt);
    		}
    	}
    	
    	return max;
    }
}
