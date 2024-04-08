T = int(input())
result = []
for i in range(T):
	C = int(input())
	Q = C // 25
	D = (C % 25) // 10
	N = ((C % 25) % 10) // 5
	P = (((C % 25) % 10) % 5) // 1
	result.append((Q,D,N,P))

for t in result:
	print(*t)