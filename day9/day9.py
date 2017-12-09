import sys
c=0
o=1
x=0
y=0
s=0
for i in sys.argv[1]:
	if i=="!":c+=1
	elif i=="<"and o and c%2==0:
		o=0
		c=0
	elif i==">"and c%2==0:o=1
	elif i=="{"and o:s+=1
	elif i=="}"and o:
		y+=s
		s-=1
	else:
		if o==0and c%2==0:x+=1
		c=0
print(y)
print(x)
