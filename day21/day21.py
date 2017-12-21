import sys
p={}
r=range
for q in sys.argv[1].split("\n"):
	i,o=q.split(" => ")
	p[i.replace("/","")]=o.split("/")
s=[".#.","..#","###"]
def t(v,k):
	f=r(v)
	u=r(v-1,-1,-1)
	for i in r(8):
		q=""
		for j in u if i%2else f:
			for h in u if i&2else f:q+=k[h][j]if i&4else k[j][h]
		if q in p:return p[q]
def b():print(sum(l.count("#")for l in s))
for x in r(18):
	n=len(s)
	v=3if n%2else 2
	z=n//v
	q=[""]*(n+z)
	for i in r(z):
		for j in r(z):
			for l in r(v+1):q[i*v+i+l]+=t(v,[s[i*v+l][j*v:j*v+v]for l in r(v)])[l]
	s=q
	if x==4:b()
b()
