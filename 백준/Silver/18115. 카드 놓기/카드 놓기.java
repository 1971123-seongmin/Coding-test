import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        int N;
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> A = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N -> 카드 장수, 1부터 N까지 카드 중복 없이 있음, 기술 N번 사용
        N = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i ++) {
            A.add(Integer.parseInt(st2.nextToken()));
        }

        Collections.reverse(A); //기술 순서를 뒤집기 -> 처음 상태가 나옴
        for(int i=1; i<=N; i++) {
            int num = A.get(i-1);

            if (num == 1) {  //1번 기술 -> 제일 위의 카드 1장을 바닥에 내려놓는다.
                deque.addFirst(i);
            }
            else if (num == 2) { //2번 기술 -> 위에서 두 번째 카드를 바닥에 내려놓는다. 카드가 2장 이상
                int k = deque.removeFirst(); //맨 위의 카드 제거 -> 2 1 3 4 5 이면 1 3 4 5 만들고
                deque.addFirst(i); //두 번째 카드 삽입 -> 1삽입
                deque.addFirst(k); //위에서 제거한 카드 다시 맨 처음에 삽입 -> 다시 2 삽입 , 2 3 4 5
            }
            else { //3번 기술 -> 제일 밑에 있는 카드를 바닥에 내려놓는다. 카드가 2장 이상
                deque.addLast(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst() + " ");
        }
        System.out.println(sb);
    }
}
