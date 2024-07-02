N = int(input())
list = list(map(int, input().split()))
print(min(list),max(list))

# 추가 응용
def my_min():
	result = list[0]
	for i in list:
		if result <= i:
			pass
		else:
			result = i
	return result

def my_max():
	result = list[0]
	for i in list:
		if result >= i:
			pass
		else:
			result = i
	return result

N = int(input())
list = list(map(int, input().split()))

print(my_min(), my_max())