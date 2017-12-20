import sys,re,itertools
l=sys.argv[1].split("\n")
k=[]
for  j in range(len(l)):
	i=l[j]
	s= re.findall("<(.*?)>",i)
	k.append([list(map(int,y.split(",")))for y in s]+[j])
d=lambda x:sum([abs(y)for y in x])
k.sort(key=lambda x:d(x[2]))
print(k[0][-1])
def s(i):
	for p in[1,0]:
		for j in [0,1,2]:i[p][j]+=i[p+1][j]
h=lambda x:x[0]
c=20
while c:
	for i in k:s(i)
	for _,j in itertools.groupby(sorted(k,key=h),h):
		v=list(j)
		if len(v)>1:
			for f in v:
				k.remove(f)
				c=20
	c-=1
print(len(k))
