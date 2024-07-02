N, B = map(int,input().split())

num_list = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
s = ""
while N:
	s += str(num_list[N%B])
	N = N//B

print(s[::-1])