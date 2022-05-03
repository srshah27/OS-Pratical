echo enter no elements
read num

f0=0
f1=1
echo -n "$f0 $f1"
sum=$((f0+f1))
for(( i=1;i<=num;i++ ))
do
echo -n " $sum"
f0=$f1
f1=$sum
sum=$((f0+f1))
done
