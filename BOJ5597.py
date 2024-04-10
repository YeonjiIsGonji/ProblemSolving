list_T = list(range(1,31))
list_n = []
for i in range(28):
	n = int(input())
	list_n.append(n)

def X():
	for i, j in zip(list_n, list_T):
		if i != j:
			print(j)
			break
		else:
			pass
list_n.sort()
X()

list_n.sort(reverse=True)
list_T.sort(reverse=True)
X()