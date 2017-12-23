import sys
d={'1':1}
for c in"abcdefgh":d[c]=0
k=[x.split()for x in sys.argv[1].split("\n")]
i=[0]
s=[0]
while i[0]<len(k):
	x,y,z=k[i[0]]
	if z in d:z=d[z]
	v=int(z)
	def l():
		d[y]*=v
		s[0]+=1
	def b():d[y]-=v
	def t():d[y]=v
	def z():
		if d[y]!=0:i[0]+=v-1
	eval(x[2])()
	i[0]+=1
print(s[0])
print(sum([1for b in range(108100,125101,17)if [1for d in range(2,b//2) if b%d==0]]))
