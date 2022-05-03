echo enter a number
read num
c=$((num%2))
if [ $c -eq 0 ]
then
echo it is an even number
else
echo it is an odd number
fi
