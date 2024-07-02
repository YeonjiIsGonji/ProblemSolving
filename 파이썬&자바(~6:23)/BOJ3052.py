result = []
for i in range(10):
	A = int(input())
	result.append(A % 42)

set_1 = set(result)
sum = list(set_1)
print(len(sum))