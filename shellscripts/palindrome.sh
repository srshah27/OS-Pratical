echo enter string
read s

echo $s>temp

rvs="$(rev temp)"

if [ $s=$rvs ]
then
echo palindrome
else
echo not palindrome
fi

