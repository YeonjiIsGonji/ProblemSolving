T = int(input())

for i in range(0,T):
	list = input().split()
	print( int(list[0]) + int(list[1]))

# 더 좋은 답
	A, B = map(int, input().split())
	# input() 함수는 호출될 때마다 입력 버퍼에서 한 줄씩 소비되며, 한 번 읽은 입력은 다시 읽지 않는다!
	# 따라서 주어지는 입력값이 여러 줄이면 한 줄씩만 input()에 들어가는 것!

