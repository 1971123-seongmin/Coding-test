class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int middle = total / num; //항상 포함 됨 (중간값, 시작값으로 설정)
        
        while(true){
            int sum = 0; //루프 돌때마다 항상 초기화
            
            for(int i=0; i<num; i++){ 
                sum += middle + i; //연속된 값을 더함 ex) 3 + 4 + 5
            }
            if(sum == total){ //같으면 루프 종료하고 정답 배열에 최초값 부터 순서대로 대입 후 정답 배열 리턴
                for(int i=0; i<num; i++)
                    answer[i] = middle+i; 
                return answer;
            }
            else if(sum > total) //만약 더한값이 목표로 주어진 값보다 작으면 middle - 1 해서 다시 루프 돌림
                middle--;
            else
                middle++; //만약 더한값이 목표로 주어진 값보다 크면 middle + 1 해서 다시 루프 돌림
        }
    }
}