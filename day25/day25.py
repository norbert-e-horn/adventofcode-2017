import sys
s=0
a=""
n=0
d={}
c=[]
for l in sys.argv[1].split("\n"):
	if s==0:a=l.split()[-1][:-1]
	elif s==1:n=int(l.split()[-2])
	elif s in[5,9]:c+=[int(l.split()[-1][:-1])]
	elif s in[6,10]:c+=[1 if l.split()[-1][:-1][0]=="r"else-1]
	elif s in[3,7,11]:c+=[l.split()[-1][:-1]]
	if s==11:
		d[c[0]]=c[1:]
		s=1
		c=[]
	s+=1
b=[0for _ in range(n//4)]
p=n//8
for _ in range(n):
	o=0
	z=d[a]
	if b[p]==1:o=3
	b[p]=z[o]
	p+=z[o+1]
	a=z[o+2]
print(sum(b))
	
