T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다
def dfs(start, score, cal):
	global result
	
	if cal > L: 
		return  
	if cal <= L: 
		if result < score:
			result = score
	for j in range(start, N):
		dfs(j+1, score + food[j][0] ,cal+food[j][1])
        
for test_case in range(1, T + 1):
	result = 0
	N, L = map(int, input().split())
	food = [list(map(int, input().split())) for _ in range(N)]
	dfs(0, 0, 0) # 시작, 점수, 칼로리
	print(f"#{test_case} {result}")