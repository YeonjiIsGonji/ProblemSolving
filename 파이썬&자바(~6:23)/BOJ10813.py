N, M = map(int, input().split())
basket = []
for i in range(0,N+1):
	basket.append(i)

for t in range(M):
	i, j = map(int, input().split())
	basket[i], basket[j] = basket[j], basket[i]

print(' '.join(map(str,basket[1:])))