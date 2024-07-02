list=input().split()
H = int(list[0])
M = int(list[1])
total_minute = H * 60 + M
alarm_minute = total_minute - 45

if alarm_minute < 0:
	print(23, alarm_minute + 60)
else:
	print(alarm_minute // 60, alarm_minute % 60)



# total = H * 60 + M
# al = total - 45
# new_H = al // 60
# new_M = al % 60
# if new_H > 0 and new_M < 10:	
# 	print(new_H,"0" + str(new_M))
# elif new_H > 0 and new_M >= 10:
# 	print(new_H,new_M)
# elif new_H < 0 and new_M <10:	
# 	print(24+new_H,"0" + str(new_M))
# else:
# 	print(24+new_H,new_M)
# 틀린답

list=input().split()
H = int(list[0])
M = int(list[1])
if M >= 45:
	print(H, M - 45)
else:
	new_M = 60 + (M - 45)
	new_H = H - 1
	if new_H < 0 :
		print(new_H + 24, new_M)	
	else:
		print(new_H, new_M)