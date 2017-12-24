import sys
l=[list(map(int,x.split("/")))for x in sys.argv[1].split("\n")]
m=[0]*3
def r(l,i,s,d):
	global m
	for j in range(len(l)):
		if l[j][0]==i:f=1
		elif l[j][1]==i:f=0
		else:continue
		s+=sum(l[j])
		d+=1
		if d>m[0]:m=[d,s,m[2]]
		elif d==m[0] and s>m[1]:m[1]=s
		m[2]=max(m[2],s)
		r(l[:j]+l[j+1:],l[j][f],s,d)
		d-=1
		s-=sum(l[j])
r(l,0,0,0)
print(m[2])
print(m[1])
