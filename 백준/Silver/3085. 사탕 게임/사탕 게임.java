import java.io.*;
import java.util.Arrays;

public class Main {
	public static char candy[][];
	public static int size;
	public static int max = 0;
	
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        size = Integer.parseInt(n);
        candy = new char[size][size];
        
        //사탕 입력
        for (int i = 0; i < size; i++) {
            String s = br.readLine();
            for (int j = 0; j < size; j++) {
                candy[i][j] = s.charAt(j);
            }
        }
        //행 탐색 => 행은 고정하고 열을 바꾸어가며 탐색
        for(int i=0; i<size; i++) {
        	for(int j=0; j<size - 1; j++) { 
                swap(i, j, i, j+1);
        		max = maxSearch(); //최대값 검색       		
                swap(i, j+1, i, j); //배열 원래대로 되돌리기
        	}
        }
        //열 탐색 => 열은 고정하고 행을 바꾸어 가면서 탐색
        for(int i=0; i<size; i++) {
        	for(int j=0; j<size - 1; j++) { 
                swap(j, i, j+1, i);
        		max = maxSearch(); //최대값 검색
        		//배열 원래대로 되돌리기
                swap(j+1, i, j, i);
        	}
        }
        System.out.println(max);
    }
    private static void swap(int row, int col, int row2, int col2) {
        char swap = candy[row][col];
        candy[row][col] = candy[row2][col2];
        candy[row2][col2] = swap;
    }
    
    private static int maxSearch() {
	    
        int cnt;    	
    	for (int i=0; i < size; i++) {
    		cnt = 1;
    		for(int j=0; j < size-1; j++) {
    			if(candy[i][j] == candy[i][j+1]) cnt++;
    			else cnt = 1;
    			max = Math.max(max, cnt);
    		}
    	}
    	
    	for (int i=0; i<size; i++) {
    		cnt = 1;
    		for(int j=0; j<size-1; j++) {
    			if(candy[j][i] == candy[j+1][i]) cnt++;
    			else cnt = 1;
    			max = Math.max(max, cnt);
    		}
    	}
    	return max;
    }
}
