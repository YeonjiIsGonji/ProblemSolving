results = []
for i in range(9):
	result = int(input())
	results.append(result)

M = max(results)
print(M)
print(results.index(M) + 1)
