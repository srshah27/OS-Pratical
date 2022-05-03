echo Enter a number
read num

for(( i=1;i<=10;i++ ))
do
echo -n "$i * $num = "
echo $(($i*$num))
done

