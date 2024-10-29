import sys

t = int(input())  # 테스트 케이스 수

for i in range(t):
    n = int(input())   # 옷의 가지 수
    dict1 = dict()

    for j in range(n):
        name, type = input().rstrip().split() # 옷 입력
        if type in dict1.keys():
            dict1[type] += 1
        else:
            dict1[type] = 1
            
    result = 1
    for k in dict1.values():
        result *= k+1
    print(result -1)