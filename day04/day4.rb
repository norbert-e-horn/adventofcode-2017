
p File.readlines("input.txt").select{|s|s.split(" ").group_by{|x|x}.map(&:last).map(&:count).max<2}.count
p File.readlines("input.txt").select{|s|s.split(" ").map{|s|s.split("").sort}.group_by{|x|x}.map(&:last).map(&:count).max<2}.count

