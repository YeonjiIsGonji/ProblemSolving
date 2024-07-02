N, M = map(int, input().split())
card = list(map(int, input().split()))

from itertools import combinations
results = []
for i in combinations(card,3):
	result = sum(i)
	results.append(result)

results =sorted(results, reverse=True)
	
for t in results:
	if t <= M:
		print(t)
		break
