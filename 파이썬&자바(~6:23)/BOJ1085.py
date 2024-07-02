x, y, w, h = map(int, input().split())

sub_1 = w - x
sub_2 = x - 0
sub_3 = h - y
sub_4 = y - 0
result = [sub_1,sub_2,sub_3,sub_4]

print(min(result))