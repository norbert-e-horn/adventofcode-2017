import sys
d={}
z={">":lambda x,y:x>y,"<":lambda x,y:x<y,">=":lambda x,y:x>=y,"<=":lambda x,y:x<=y,"==":lambda x,y:x==y,"!=":lambda x,y:x!=y}
m=0
for n in sys.argv[1].split("\n"):
	c=n.split()
	if not c[0]in d:d[c[0]]=0
	if not c[4]in d:d[c[4]]=0
	if z[c[5]](d[c[4]],int(c[6])):
		if c[1]=="inc":d[c[0]]+=int(c[2])
		else:d[c[0]]-=int(c[2])
		if d[c[0]]>m:m=d[c[0]]
print(max(d.values()))
print(m)
