n = input().split()
n_1 = list(n[0])
r = int(n[1])

x = '10'
mapping = {}
for i in range(ord('A'),ord('Z')+1):
	mapping[chr(i)] = x
	x = str(int(x)+1)

N = []
for i in n_1:
	if i in mapping:
		N.append(int(mapping[i]))
	else:
		N.append(int(i))
N.reverse()

y = 0
for i in range(len(N)):
	y += N[i] * (r**i)

print(y)
