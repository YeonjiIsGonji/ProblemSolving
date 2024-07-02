N = int(input())
Bag = 0
while N >= 0:
	if N % 5 == 0:
		Bag += N //5
		print(Bag)
		break	
	N = N - 3
	Bag += 1

else:
	print(-1)