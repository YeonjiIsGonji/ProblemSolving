board = []
for i in range(9):
	N = map(int, input().split())
	board.append(list(N))
M = max(map(max, board))	

for i in range(9):
	for j in range(9):
		if board[i][j] == M:
			print(M)
			print(str(i+1) + ' ' + str(j+1))
			break
		else:
			pass
