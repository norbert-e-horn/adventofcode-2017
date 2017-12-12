import sys
k=[[int(x.strip(",")) for x in i.split()if"<->"!=x]for i in sys.argv[1].split("\n")]
r=[]
while len(k):
	l=k[0]
	c=True
	while(c):
		c=False
		j=0
		while j<len(k):
			for g in k[j]:
				if g in l:break
			else:
				j+=1
				continue
			l+=k[j]
			del k[j]
			c=True
	r+=[l]
print(len([set(w)for w in r if 0in w][0]))
print(len(r))
