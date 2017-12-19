import sys
q={"-":1,"|":1,"+":2," ":0}
k=[[q[c] if c in q else c for c in l]for l in sys.argv[1].split("\n")]
p=[0,[i for i in range(len(k[0]))if k[0][i]==1][0]]
d=2
l=""
s=1
def r():
	p[0]-=a*z
	p[1]+=a*y
while d>=0:
	x=d//2
	y=d%2
	z=1-y
	a=1-2*x
	s+=1
	if k[p[0]][p[1]]==1:r()
	elif k[p[0]][p[1]]==2:
		if k[p[0]+y][p[1]+z]in(2,0):
			p[z]-=1
			d=3*z
		else:
			p[z]+=1
			d=2-z
	elif k[p[0]][p[1]]==0:d=-1
	else:
		l+=k[p[0]][p[1]]
		r()
print(l)
print(s)
