import sys,itertools
w=itertools.product
p={}
r=range
for q in sys.argv[1].split("\n"):
	i,o=q.split(" => ")
	p[i.replace("/","")]=o.split("/")
s=[".#.","..#","###"]
def b():print(sum(l.count("#")for l in s))
for x in r(18):
	n=len(s)
	v=3if n%2else 2
	z=n//v
	q=[""]*(n+z)
	f=[r(v-1,-1,-1),r(v)]
	for i,j,l in w(r(z),r(z),r(v+1)):q[i*v+i+l]+=[p[x]for x in["".join(s[i*v+h][j*v+ü]if d&4else s[i*v+ü][j*v+h]for ü,h in w(f[d%2],f[(d&2)>>1]))for d in r(8)]if x in p][0][l]
	s=q
	if x==4:b()
b()
