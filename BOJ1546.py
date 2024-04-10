N = int(input())
n = list(map(int, input().split()))
M = max(n)

result = 0
for i in n:
	result = result + (i/M * 100)

print(result/N)
