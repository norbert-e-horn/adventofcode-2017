p ARGV[0].chars.tap{|a|a<<a[0]}.inject([[],nil]){|(a,l),c|c==l ?[a<<l,c]:[a,c]}.first.map(&:to_i).inject(&:+)
p ARGV[0].chars.zip(ARGV[0].chars.rotate ARGV[0].length/2).select{|(a,b)|a==b}.inject(0){|s,x|s+=x[0].to_i}
