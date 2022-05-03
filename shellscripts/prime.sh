echo enter number
read num

for (( i=1;i<=num;i++ ))
do
if [ $((num%i))==0 ]
then
((c++))
fi
done
if [ $c == 2 ]
then
echo it is a prime number
else
echo not a prime number
fi
