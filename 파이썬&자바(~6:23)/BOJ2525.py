list = input().split()
C = int(input())

A = int(list[0])
B = int(list[1])

total = A * 60 + B + C
End_H = total // 60
End_m = total % 60

if End_H >= 24:
	print(End_H - 24,End_m)
else :
	print(End_H, End_m)
