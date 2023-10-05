import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int arr[][] = new int[N+1][M+1];
        //int arrsum[][] = new int [N+1][M+1];  //부분합 저장하는 2차원 배열

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                arr[i][j] = arr[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        //Integer.parseInt(st.nextToken()); 현재 위치한 값 (입력 값)
        //arr[i][j-1] -> 같은 행에 위치한 앞의 열 까지의 합

        //합을 구할 부분의 개수 K
        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++ ) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()); //행
            int j = Integer.parseInt(st.nextToken()); //열
            int y = Integer.parseInt(st.nextToken()); //행
            int l = Integer.parseInt(st.nextToken()); //열

            //(i, j)에서 (y, l)까지의 합
            for (int x = i; x <= y; x++ ) {            //행
                sum = sum + arr[x][l] - arr[x][j-1];   //l열 까지의 합 - j-1 까지의 합
            }
            System.out.println(sum);
        }
    }
}
