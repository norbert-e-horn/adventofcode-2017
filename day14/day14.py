r=range
n=128
h=""
for j in r(n):
	u=256
	l=list(r(u))
	p=0
	s=0
	for i in map(ord,(f"hxtvlmkl-{j}\x11\x1fI/\x17")*64):
		l=l[p:]+l[:p]
		l[:i]=reversed(l[:i])
		l=l[-p:]+l[:-p]
		p=(p+s+i)%u
		s+=1
	k=0
	for i in r(u):
		k^=l[i]
		if i%16==15:
			h+=f"{k:08b}"
			k=0
q=list(map(int,h))
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
