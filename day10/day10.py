import sys
n=256
q=sys.argv[1]
k=[int(x) for x in q.split(",")]
l=range(n)
p=0
s=0
def d():
	global l,p,s
	for i in k:
		l=l[p:]+l[:p]
		l=list(reversed(l[:i]))+l[i:]
		l=l[-p:]+l[:-p]
		p=(p+s+i)%n
		s+=1
d()
print(l[0]*l[1])
k=[ord(x)for x in q]+[17,31,73,47,23]
l=range(n)
p=0
s=0
while s/len(k)<64:d()
print("".join(["{:02x}".format(reduce((lambda x,y:x^y),l[i:i+16])) for i in range(0,n,16)]))
