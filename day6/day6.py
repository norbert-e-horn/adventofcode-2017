import sys,itertools
l=[int(c) for c in sys.argv[1].split("\t")]
k={}
s=0
n=len(l)
while str(l)not in k:
	k[str(l[:])]=s
	m=-max([(l[i],-i)for i in range(n)])[1]
	v=l[m]
	l[m]=0
	for i in range(v):l[(m+i+1)%n]+=1
	s+=1
print(s)
print(s-k[str(l)])
