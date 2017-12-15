import sys
l= sys.argv[1].split("\n")
a=int(l[0].split()[-1])
b=int(l[1].split()[-1])
c=a
d=b
k=2147483647
t=2**16
s=0
for i in range(40000000):
	c=c*16807%k
	d=d*48271%k
	if not(c%t)^(d%t):s+=1
print(s)
s=0
for i in range(5000000):
	a=a*16807%k
	while a%4:a=a*16807%k
	b=b*48271%k
	while b%8:b=b*48271%k
	if not(a%t)^(b%t):s+=1
print(s)
