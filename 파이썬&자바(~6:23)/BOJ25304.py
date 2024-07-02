X = int(input())
N = int(input())
total = 0
for i in range(N):
	A, B = map(int, input().split())
	total = A * B + total
	

if X == total:
	print("Yes")
else:
	print("No")