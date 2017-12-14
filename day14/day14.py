def d(w,o="{:02x}"):
	n=256
	l=range(n)
	p=0
	s=0
	for _ in range(64):
		for i in map(ord,w)+[17,31,73,47,23]:
			l=l[p:]+l[:p]
			l=list(reversed(l[:i]))+l[i:]
			l=l[-p:]+l[:-p]
			p=(p+s+i)%n
			s+=1
	return [o.format(reduce(lambda x,y:x^y,l[i:i+16]))for i in range(0,n,16)]
w="hxtvlmkl"
r=range(128)
q=[map(int,"".join(d(w+"-"+str(j),"{:08b}")))for j in r]
print(sum(map(sum,q)))
s=0
for i in r:
	for j in r:
		if q[i][j]:
			s+=1
			v=[(i,j)]
			while v!=[]:
				x,y=v.pop()
				if not (x in r and y in r and q[x][y]):continue
				q[x][y]=0
				for l in[-1,1]:v+=[(x+l,y),(x,y+l)]
print(s)
