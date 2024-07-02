T = int(input())
li_s = (input().split())
R = int(li_s[0])
S = list(li_s[1])
print(S)

p = []
for i in range(len(S)):
	for j in S:
		p.append(list[j]*R)