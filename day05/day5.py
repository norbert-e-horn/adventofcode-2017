import sys
i=[int(c)for c in sys.argv[1].split("\n")]
l=i[:]
def b(a):
	s=0
	r=0
	while s<len(l):
		n=l[s]
		l[s]+=a(n)
		s+=n
		r+=1
	print(r)
b(lambda x:1)
l=i
b(lambda x:(1if x<3else-1))
