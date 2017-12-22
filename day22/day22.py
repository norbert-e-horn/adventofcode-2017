import sys
c=[[2if a=="#"else 0for a in i]for i in sys.argv[1].split("\n")]
n=len(c)
def m(x):
	d[0]=(d[0]+a[d[1]]+3)%4
	a[d[1]]=(x+a[d[1]])%4
	if a[d[1]]==2:d[2]+=1
	d[1]+=(s+(1-s)*(d[0]&1))*(-1+2*(d[0]&1^(d[0]&2)>>1))
s=1001
a=[]
k=(s-n)//2
for i in range(s):a+=[0]*k+c[i-k]+k*[0]if k<=i<(s+n)/2else[0]*s
b=list(a)
d=[0,s**2//2,0]
for i in range(10000):m(2)
print(d[2])
a=b
d=[0,s**2//2,0]
for i in range(10000000):m(1)
print(d[2])
