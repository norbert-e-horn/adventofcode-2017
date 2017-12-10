let a=CommandLine.arguments[1]
var c=0
var o=true
var x=0
var y=0
var s=0
for i in a {
    if i=="!" {
        c+=1
    }
    else if i=="<" && o && c%2==0 {
        o=false
        c=0
    }
    else if i==">" && c%2==0 {
        o=true
    }
    else if i=="{" && o {
        s+=1
    }
    else if i=="}" && o {
        y+=s
        s-=1
    }
    else {
        if !o && c%2==0 {
            x+=1
        }
        c=0
    }
}
print(y)
print(x)
