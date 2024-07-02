import sys
T = int(input())
for i in range(1,T+1):
	A, B = map(int, sys.stdin.readline().split())
	C = 'Case #{}:'.format(i)
	D = '{0} + {1} ='.format(A, B)
	print(C,D,A+B)
