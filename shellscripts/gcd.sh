echo enter num1
read num1
echo enter num2
read num2

if [ $num1 -gt $num2 ]
then
m=$num2
else
m=$num1
fi

while [ $m -ne 0 ]
do
x=$((num1%m))
y=$((num2%m))

if [ $x == 0 ] && [ $y == 0 ]
then
echo $m
break
fi
m=$((m-1))
done
