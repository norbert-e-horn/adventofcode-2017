import sys
d={}
for i in sys.argv[1].split("\n"):
	c=i.split(":")
	d[int(c[0])]=int(c[1])
print(sum([k*d[k]for k in d if float(k)/(d[k]-1)%2==0]))
i=0
while True:
	for k in d:
		if float(k+i)/(d[k]-1)%2==0:break
	else:
		print(i)
		break
	i+=1
