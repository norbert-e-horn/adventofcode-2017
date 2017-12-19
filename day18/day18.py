import sys
d={'i':0,'a':0,'p':0,'b':0,'f':0,'1':1}
k=[x.split()for x in sys.argv[1].split("\n")]
r=[d,dict(d)]
r[1]["p"]=1
def n(x,y,z=0):
	m=r[p]
	try:v=m[z]
	except:v=int(z)
	def u():m[y]*=v
	def d():m[y]+=v
	def o():m[y]%=v
	def e():m[y]=v
	def g():
		if m[y]>0:i[p]+=v-1
	def n():
		a[1-p]+=[m[y]]
		a[4+p]+=1
	def c():
		if a[p]:
			if a[3]<1:a[3]=a[1][-1]
			m[y]=a[p].pop(0)
		else:a[2]=0
	eval(x[1])()
	if a[2]:i[p]+=1
i=[0,0]
p=1
a=[[],[],1,0,0,0]
while a[0]+a[1]or p:
	p=1-p
	a[2]=1
	while a[2]:n(*k[i[p]])
print(a[3:5])
