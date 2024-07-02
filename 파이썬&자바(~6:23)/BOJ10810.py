
# for t in range (N):
# 	t = list()
# 	t.append(0)
# 	i, j = map(int, input().split())
N, M = map(int, input().split())
result = []
for t in range (N+1):
	result.append(0)

for a in range(M):
	number = list(map(int, input().split()))
	i = number[0]
	j = number[1]
	k = number[2]
	for t in range(i,j+1):
		result[t] = k
	
print(' '.join(map(str,result[1:])))