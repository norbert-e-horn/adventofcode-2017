r=277678
def m(t):
	c=lambda x,y: x if t[4]==1else y
	p=t[3]*2+1
	if t[5]==0:return[t[0]+1,t[1],t[2]+1,t[3],c(p/2+t[3]-1,t[4]-1),c(1,0)]
	elif t[5]==1:return[t[0],t[1]-1,t[2]+1,t[3],c(p-1,t[4]-1),c(2,1)]
	elif t[5]==2:return[t[0]-1,t[1],t[2]+1,t[3],c(p-1,t[4]-1),c(3,2)]
	else:return[t[0],t[1]+1,t[2]+1,c(t[3]+1,t[3]),c(p,t[4]-1),c(0,3)]
t = [0,0,1,1,1,0]
while t[2] != 277678:
	t = m(t)
print(t[0]+t[1])
import sys
def a2(x,y):
	global m
	z=sum([sum([m[x-i][y-j]for i in range(-1,2)])for j in range(-1,2)])-m[x][y]
	if z>=r:
		print(z)
		sys.exit(0)
	m[x][y]=z
q=11
s=[q/2-1,q/2]
m=[[0 for i in range(0,q)] for y in range(0,q)]
m[s[0]+1][s[1]] = 1
for i in range(1,q/2):
	s[0]+=1
	a2(s[0],s[1]+i)
	p=(i+1)*2-1
	for x in range(1,p/2+i):a2(s[0]-x,s[1]+i)
	x=p/2+i-1
	for y in range(1, p):a2(s[0]-x,s[1]+i-y)
	y=p-1
	for k in range(1,p):a2(s[0]-x+k,s[1]+i-y)
	x-=p-1
	for k in range(1,p):a2(s[0]-x,s[1]+i-y+k)
