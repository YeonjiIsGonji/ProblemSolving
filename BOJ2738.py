N, M = map(int, input().split())
result_A = [[0 for j in range(M)] for i in range(N)]
result_B = [[0 for j in range(M)] for i in range(N)]

for i in range(N):
	num_list = list(map(int, input().split()))
	for j in range(M):
		result_A[i][j] = num_list[j]

for i in range(N):
	num_list = list(map(int, input().split()))
	for j in range(M):
		result_B[i][j] = num_list[j]

for i in range(N):
	for j in range(M):
		if (j == M - 1):
			print(result_A[i][j] + result_B[i][j], end="")
		else:
			print(result_A[i][j] + result_B[i][j], end=" ")
	print()

# result = []
# for i in range(N):
# 	for j in range(M):
# 		Add = result_A[i][j] + result_B[i][j]
# 		result.append(Add)
# print(result_A)
# print(result_B)



# result_A = [int(a) for a in result_A]
# result_B = [int(b) for b in result_B]
# total = [x + y for x, y  in zip(result_A,result_B)]

# total = []
# for a, b in zip(result_A,result_B):
# 	add = sum(int(x) for x in a)  + sum(int(y) for y in b)
# 	total.append(add)
	
	
# print(total)