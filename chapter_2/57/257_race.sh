#!/bin/bash 
                                                                      
if test ! -f 257_numbers
then
    #create the numbers file                                                   
    echo 0 > 257_numbers
fi

#Repeat 100 times to see fun
for i in `seq 1 100`;
do
	#Read and increase last number
	LASTNUMBER=`tail -1 257_numbers`
	LASTNUMBER=$((LASTNUMBER+1))

	echo $LASTNUMBER >> 257_numbers
done
