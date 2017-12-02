let a = CommandLine.arguments[1].split(separator: "\n")
var sum = 0;
for l in a {
    var max = 0;
    var min = Int.max
    for z in l.split(separator:"\t") {
        let i = Int(z)!
        if i > max {
            max = i
        }
        if i < min {
            min = i
        }
    }
    sum += max-min
}
print(sum)

sum = 0;
for l in a {
    let s = l.split(separator:"\t")
    outerLoop:  for z in s {
        let i = Int(z)!
        for y in s {
            let j = Int(y)!
            if i==j {
                continue
            }
            if i%j == 0 {
                sum += i/j
                break outerLoop
            }
        }
    }
}
print(sum)

