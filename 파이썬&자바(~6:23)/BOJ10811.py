N, M = map(int, input().split())
basket = []
for t in range(1,N+1):
	basket.append(t)

for t in range(M):
	i, j = map(int, input().split())
	new_1= basket[i-1:j]
	new_2= basket[j:]
	new_1.reverse()
	del basket[i-1:]
	basket.extend(new_1)
	basket.extend(new_2)

print(' '.join(map(str,basket)))