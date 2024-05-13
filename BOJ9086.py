T = int(input())
for i in range(T):
	input_list = input().split()
	result = ','.join(input_list)
	rev_result = result[::-1]
	print(result[0]+rev_result[0])
