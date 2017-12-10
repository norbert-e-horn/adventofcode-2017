p (0..1.0/0).find{|x|((2*x+1)**2)>=ARGV[0].to_i}.tap{|l|break l+(((l*2+1)**2-ARGV[0].to_i)%(2*(l==0?1:l))-l).abs}
p class C ; attr :v, :n
  def initialize n=[];@v=((@n=n)==[])?1: n.map{|e|e ? e.v: 0}.inject(&:+);end
  def +@
    (n[2]=C.new([n[1],nil,n[2]&.n&.[](2),n[3]&.n&.[](2),n[3],n[4],self,n[0]]);(n[4].n[1]=n[2]if@n[4]);(n[3].n[0]=n[2]if@n[3]);return @n[2])if !n[2]&&n[4]
    (n[4]=C.new([self,n[2],n[3],nil,n[4]&.n&.[](4),n[5]&.n&.[](4),n[5],n[6]]);(n[6].n[3]=n[4]if@n[6]);(n[5].n[2]=n[4]if@n[5]);return @n[4])if !n[4]&&n[6]
    (n[6]=C.new([n[7],n[0],self,n[4],n[5],nil,n[6]&.n&.[](6),n[7]&.n&.[](6)]);(n[0].n[5]=n[6]if@n[0]);(n[7].n[4]=n[6]if@n[7]);return @n[6])if !n[6]&&n[0]
    (n[0]=C.new([n[0]&.n&.[](0),n[1]&.n&.[](0),n[1],n[2],self,n[6],n[7]]);(n[2].n[7]=n[0]if@n[2]);(n[1].n[6]=n[0]if@n[1]);return @n[0])
  end
  c=C.new; (c= +c while c.v<ARGV[0].to_i); c.v
end
