n=304
def z(u):
	p=0
	for i in range(1,int(u)+1):
		p=(p+n)%i+1
		yield p,i
u=2017
l=[0]
for t in z(u):l.insert(*t)
print(l[l.index(u)+1])
print([i for p,i in z(5E7)if 1==p][-1])
