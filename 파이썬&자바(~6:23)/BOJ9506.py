while True:
	n = int(input())
	if n != -1:
		result = 1
		div = []
		for i in range(2,n):
			if n % i == 0:				
				result += i
				div.append(' + ')
				div.append(str(i))

		if result == n:			
			total = ''.join(div)
			print(str(n) + " = 1" + total)
		else:
			print(str(n)+" is NOT perfect.")
	else:
		break