N = int(input())

def divideAndSum(i):
	result = i
	while(i > 0):
		result += i % 10
		i = i // 10
	return result

result = 0
for i in range(1, N + 1):
	if (divideAndSum(i) == N):
		result = i
		break

print(result)