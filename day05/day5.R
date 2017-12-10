instructions = read.table("input.txt")[,1]
pos = 1;
counter = 0;
while(pos >0 & pos <= length(instructions)){
    counter = counter + 1
    jump = instructions[pos]
    instructions[pos] = instructions[pos] + 1;
    pos = pos+ jump;
}
print(counter)

instructions = read.table("input.txt")[,1]
pos = 1;
counter = 0;
while(pos >0 & pos <= length(instructions)){
    counter = counter + 1
    jump = instructions[pos]
    if(instructions[pos] > 2){
        instructions[pos] = instructions[pos] - 1;
    }else{
        instructions[pos] = instructions[pos] + 1;
    }
    pos = pos+ jump;
}
print(counter)
