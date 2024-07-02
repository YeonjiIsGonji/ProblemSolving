list = input().split()
A = int(list[0])
B = int(list[1])
if A > B:
	print('>')
elif A < B:
	print("<")
else :
	print("==")