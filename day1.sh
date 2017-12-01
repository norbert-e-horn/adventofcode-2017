#!/bin/sh

#script expects input on stdin

#read captcha input
read captcha

##### PART I #####

sum=0
#iterate over digits
for (( i=1; i<${#captcha}; i++ )); do
    #get previous and current digit
    digit1=${captcha:$i-1:1}
    digit2=${captcha:$i:1}
    #add to sum if equals
    if [ "$digit1" == "$digit2" ]; then
	sum=$(($sum+$digit1))
    fi
done

#compare last and first digit
firstdigit=${captcha:0:1}
if [ "$firstdigit" == "$digit2" ]; then
    sum=$(($sum+$digit2))
fi

#print anser
echo "answer to first part: $sum"

##### PART II #####

sum=0
#get length and  halflength
length=${#captcha}
halflength=$(($length/2))
#iterate over digits
for (( i=0; i<${#captcha}; i++ )); do
    #get current digit
    digit1=${captcha:$i:1}
    #calculate position of digit half way around
    pos=$(($i+$halflength))
    if [ "$pos" -ge "$length" ]; then
	pos=$(($pos-$length))
    fi
    #get second digit
    digit2=${captcha:$pos:1}
    #add to sum if equals
    if [ "$digit1" == "$digit2" ]; then
	sum=$(($sum+$digit1))
    fi
done

#print answer
echo "answer to second part: $sum"
