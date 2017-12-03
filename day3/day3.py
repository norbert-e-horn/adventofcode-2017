r=277678
z=2
def a(x,y):
	global z
	if z==r:print (x+y)
	z+=1
for i in range(1,400):
	a(-1+i,i)
	p = (i+1)*2-1
	for x in range(1,p/2+i):a(-1+i-x,i)
	x = p/2+i-1
	for y in range(1, p):a(-1+i-x,i-y)
	y = p-1
	for x2 in range(1,p):a(-1+i-x+x2,i-y)
	x2 = p-1
	for y2 in range(1,p):a(-1+i-x+x2,i-y+y2)
import sys
def a2(x,y):
	global m
	z = sum([sum([m[x-i][y-j]for i in range(-1,2)])for j in range(-1,2)])-m[x][y]
	if z>=r:
		print(z)
		sys.exit(0)
	m[x][y] = z
q=11
s=[q/2-1,q/2]
m=[[0 for i in range(0,q)] for y in range(0,q)]
m[s[0]+1][s[1]] = 1
for i in range(1,q/2):
	s[0]+=1
	a2(s[0],s[1]+i)
	p = (i+1)*2-1
	for x in range(1,p/2+i):a2(s[0]-x,s[1]+i)
	x = p/2+i-1
	for y in range(1, p):a2(s[0]-x,s[1]+i-y)
	y = p-1
	for k in range(1,p):a2(s[0]-x+k,s[1]+i-y)
	x -= p-1
	for k in range(1,p):a2(s[0]-x,s[1]+i-y+k)
