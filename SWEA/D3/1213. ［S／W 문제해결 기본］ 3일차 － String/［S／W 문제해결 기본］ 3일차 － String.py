T = 11
for test_case in range(1, T):
    tc = int(input())
    search = input()
    word = input()
    answer = word.count(search)
    print(f"#{tc} {answer}")