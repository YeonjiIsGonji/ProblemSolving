# year = int(input())
# if  year % 4 == 0 :
# 	if year % 100 != 0 or year % 400 == 0:	
# 		print(1)
# else:
# 	print(0)
# 이 코드가 틀린 이유: 4의 배수이면서 100의 배수인 경우에 출력되는 값이 없다! 4의 배수인경우 무조건 첫번째 if절로 가기 때문
# 따라서 이 코드를 맞게 수정하려면 첫번째 4의 배수인 조건문 안에 else: print(0)을 입력해줘야 한다.

year = int(input())
if year%4 == 0 and year%100 != 0 or year%400 == 0:
	print(1)
else:
	print(0)