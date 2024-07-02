N = int(input())

home = 1
r = 1

while N > home:
	home = home + 6 * r
	r = r + 1
print(r)