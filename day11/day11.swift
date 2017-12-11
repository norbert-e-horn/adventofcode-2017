let a=CommandLine.arguments[1]
let k = a.split(separator: ",").map{String($0)}
var d = ["n":0,"ne":0,"se":0,"s":0,"sw":0,"nw":0]
let c=["n":["s","sw","nw","se","ne"],"s":["n","nw","sw","ne","se"],"se":["nw","n","ne","sw","s"],"sw":["ne","n","nw","se","s"],"nw":["se","s","sw","ne","n"],"ne":["sw","s","se","nw","n"]]
var m = 0
for i in k {
    let n = c[i]!
    if d[n[0]]!>0{
        d[n[0]]!-=1
    }
    else if d[n[1]]!>0 && d[n[2]]!>0 {
        d[n[1]]!-=1
        d[n[2]]!+=1
    }
    else if d[n[3]]!>0 && d[n[4]]!>0 {
        d[n[3]]!-=1
        d[n[4]]!+=1
    }
    else {
        d[i]!+=1
    }
    m = max(d.values.reduce(0, +),m)
}
print(d.values.reduce(0, +))
print(m)
