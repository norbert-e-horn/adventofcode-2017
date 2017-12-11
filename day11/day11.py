import sys
d={"n":0,"ne":0,"se":0,"s":0,"sw":0,"nw":0}
c={"n":["s","sw","nw","se","ne"],"s":["n","nw","sw","ne","se"],"se":["nw","n","ne","sw","s"],"sw":["ne","n","nw","se","s"],"nw":["se","s","sw","ne","n"],"ne":["sw","s","se","nw","n"]}
m=0
for i in sys.argv[1].split(","):
	n=c[i]
	if d[n[0]]>0:d[n[0]]-=1
	elif d[n[1]]>0and d[n[2]]>0:
		d[n[1]]-=1
		d[n[2]]+=1
	elif d[n[3]]>0and d[n[4]]>0:
		d[n[3]]-=1
		d[n[4]]+=1
	else:d[i]+=1
	m=max(sum(d.values()),m)
print(sum(d.values()))
print(m)
