import sys

n = int(input())
m = int(input())
a = list(map(int, sys.stdin.readline().split()))
a.sort()

cnt = 0
fir = 0
sec = n-1

while a[fir] < a[sec]:
    sum = a[fir] + a[sec]

    if sum > m:
        sec -= 1
    elif sum < m:
        fir += 1
    else:
        fir += 1
        sec -= 1
        cnt += 1
        
print(cnt)
    
