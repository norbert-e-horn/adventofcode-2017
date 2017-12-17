r=range
def d(w):
	n=256
	l=list(r(n))
	p=0
	s=0
	for _ in r(64):
		for i in map(ord,w+'\x11\x1fI/\x17'):
			l=l[p:]+l[:p]
			l=list(reversed(l[:i]))+l[i:]
			l=l[-p:]+l[:-p]
			p=(p+s+i)%n
			s+=1
	z=[]
	k=0
	for i in r(n):
		k^=l[i]
		if i%16==15:
			z+=[f"{k:08b}"]
			k=0
	return z
n=128
z=""
for j in r(n):z+="".join(d("hxtvlmkl-"+str(j)))
q=list(map(int,z))
print(sum(q))
s=0
for i in r(n*n):
	if q[i]:s+=1
	v=[i]
	while v:
		x=v.pop()
		if n*n>x>=0and q[x]:
			q[x]=0
			v+=[x+l for l in[-n,n]]
			if x%n:v+=[x-1]
			if (x+1)%n:v+=[x+1]
print(s)
