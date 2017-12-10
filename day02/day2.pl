#!/usr/bin/perl

my @input = ();

my $sum = 0;

while(<>){
    chomp;
    my @line = split();
    push(@input,\@line);
    my $min = $line[0];
    my $max = $line[0];
    for(my $i = 1; $i < scalar@line; $i++){
	if($line[$i] < $min){
	    $min = $line[$i];
	}
	if($line[$i] > $max){
	    $max = $line[$i];
	}
    }
    $sum += $max - $min;
}

print "Result for Part I: $sum\n";


$sum = 0;
foreach my $line (@input){
    LINE:for(my $i = 0; $i < scalar@{$line}; $i++){
	for(my $j = $i+1; $j < scalar@{$line}; $j++){
	    my $number1 = $line->[$i];
	    my $number2 = $line->[$j];
	    if($number1 % $number2 == 0){
		$sum += $number1/$number2;
		last LINE;
	    }
	    if($number2 % $number1 == 0){
		$sum += $number2/$number1;
		last LINE;
	    }
	}
    }
}

print "Result for Part II: $sum\n";
