import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); //공백으로 문자열 구분

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A[] = new int [N];

        //배열의 숫자 입력받기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st2.nextToken());
        }

        //M이 되는 경우의 수 구하기
        int start = 0;
        int end = 0;
        int preSum = 0;
        int cnt = 0;

        while(true) {
            if (preSum >= M) {
                if (preSum == M) cnt++;
                preSum -= A[start++];
            }
            else if (end == N) break;
            else preSum += A[end++];
        }
        System.out.println(cnt);
    }
}
