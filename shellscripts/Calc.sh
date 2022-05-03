echo enter num1
read a
echo enter num2
read b
echo -e "1.Add \n 2.Subtract \n 3.Multiply \n 4.Divide"
echo enter choice
read choice

if [ $choice -eq 1 ]
then
echo $((a+b))
echo $c

elif [ $choice -eq 2 ]
then
echo $((num1-num2))

elif [ $choice -eq 3 ]
then
echo $((num1*num2))

elif [ $choice -eq 4 ]
then
echo $((num1/num2))

else
echo invalid choice
fi
