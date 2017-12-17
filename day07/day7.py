import sys,itertools
d={}
m=[]
for l in sys.argv[1].split("\n"):
	c=l.split()
	r=[i.replace(",","")for i in c][3:]
	m+=r
	d[c[0]]=[int(c[1][1:-1]),r]
k=set(d)-set(m)
print(k.pop())
k={}
while 1:
	for l,v in d.items():
		p=v[1]
		if all([i in k for i in p]):
			k[l]=v[0]
			r=sorted([list(g)for _,g in itertools.groupby([(q,k[q])for q in p],lambda x:x[1])],key=lambda x:len(x[0]))
			for b in p:k[l]+=k[b]
			if len(r)>1:
				print(d[r[0][0][0]][0]+r[1][0][1]-r[0][0][1])
				sys.exit(0)
