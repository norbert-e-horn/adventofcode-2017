r=277678
def w(t):
	p=t[3]*2+1
	a=t[5]%2
	b=t[5]//2
	c=1if t[4]==1else 0
	t[0]+=(1-2*(a))*(1-b)
	t[1]+=(1-2*(a))*(b)
	t[2]+=1
	t[3]+=c*(b)*(1-a)
	t[4]+=c*((p-1)*(a)+(1-a)*((1-b)*(p//2+t[3]-1)+(b)*p))-1
	t[5]+=c*((-2)*(b)+(1-b)*(3-2*(a)))
t=[0,0,1,1,1,0]
while t[2]!=r:w(t)
print(t[0]+t[1])
q=12
m=[0for y in range(q*q)]
t=[q//2,q//2,1,1,1,0]
p=lambda :t[0]*q+t[1]
m[p()]=1
while m[p()]<r:
	w(t)
	m[p()]=sum([sum([m[p()-i*q-j]for i in range(-1,2)])for j in range(-1,2)])
print(m[p()])
