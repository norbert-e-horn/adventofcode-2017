#!/usr/bin/perl

my @input = ();

my $counter = 0;
while(<>){
    chomp;
    my @line = split;
    push(@input,\@line);
    my $valid = 1;
    ILOOP:for(my $i = 0; $i < scalar@line; $i++){
	for(my $j = $i+1; $j < scalar@line; $j++){
	    if($line[$i] eq $line[$j]){
		$valid = 0;
		last ILOOP;
	    }
	}
    }
    if($valid == 1){
	$counter++;
    }
}

print "Result for Part I: $counter\n";

$counter = 0;
foreach my $line (@input){
    my @line = @{$line};
    for(my $i = 0; $i < scalar@line; $i++){
	my @temp = split(//,$line[$i]);
	@temp = sort@temp;
	$line[$i] = join("",@temp);
    }
    my $valid = 1;
    ILOOP:for(my $i = 0; $i < scalar@line; $i++){
	for(my $j = $i+1; $j < scalar@line; $j++){
	    if($line[$i] eq $line[$j]){
		$valid = 0;
		last ILOOP;
	    }
	}
    }
    if($valid == 1){
	$counter++;
    }
}

print "Result for Part II: $counter\n";
