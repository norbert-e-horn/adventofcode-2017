
p File.readlines("input.txt").map{|l|l.split("\t").map(&:to_i).tap{|a|break a.max-a.min}}.inject(&:+)
p File.readlines("input.txt").map{|l|l.split("\t").map(&:to_i).tap{|a|break a.map{|e|(a-[e]).map{|f|f%e<1?f/e:0}}}}.flatten.inject(&:+)

