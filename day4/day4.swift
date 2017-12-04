let a = CommandLine.arguments[1].split(separator: "\n")
var sum = 0;
out: for l in a {
    let cols = l.split(separator: " ")
    for i in 0..<cols.count {
        for j in (i+1)..<cols.count {
            if cols[i] == cols[j] {
                continue out
            }
        }
    }
    sum += 1
}
print(sum)
sum = 0;
out: for l in a {
    let cols = l.split(separator: " ")
    for i in 0..<cols.count {
        for j in (i+1)..<cols.count {
            if cols[i].sorted() == cols[j].sorted() {
                continue out
            }
        }
    }
    sum += 1
}
print(sum)
