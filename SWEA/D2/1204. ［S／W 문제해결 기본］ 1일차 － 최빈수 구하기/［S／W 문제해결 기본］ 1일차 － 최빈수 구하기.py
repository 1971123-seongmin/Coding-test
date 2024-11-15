T = int(input())
for test_case in range(1, T+1):
    tc = int(input())
    values = list(map(int, input().split()))
    freq = [0] * 101
    mode = 0
    
    for scores in values:
        freq[scores] += 1
        if freq[scores] >= freq[mode]:
            mode = scores
	
    print(f"#{tc} {mode}")