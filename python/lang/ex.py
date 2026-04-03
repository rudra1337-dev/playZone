"""a = 13
b = 14

if a==13:
  print(a+b);
  
//this was the use of two variable
print(Name: Rudra \n Learning: Python Foundations)
"""

""" name = input("Enter name:")
age = int(input("Enter age:"))

print("Hello",name,"You are ",age,"Years old.")

print(type(name))
print(type(age)) """

""" 
age = int(input("Enter your age"));
if age>=18:
  print("You are eligible for the vote");
else:
  print("You are not eligible for the vote") """





# """C lang"""

# #include<Stdio.h>

# int main(){
#   printf("Enter your age: ");
#   int age;
#   scanf("%d", &age);

#   if(age < 18){
#     printf("Not Eligible for vote");
#   }else{
#     printf("Eligible for vote");
#   }
#   return 0;
# }


# """Java lang"""

# import java.util.Scanner;

# public class Main{
#   public static void main(String[] args){
#     System.out.print("Enter your name: ")

#     Scanner sc = new Scanner(System.in);

#     int age = sc.nextInt();

#     if(age < 18){
#       System.out.print("Not Eligible for vote");
#     }else{
#       System.out.print("Eligible for vote");
#     }

#   }
# }


# """JavaScript lang"""

# let age = prompt("Enter your age")

# if(age < 18){
#   console.log("Not Eligible for vote");
# }else{
#   console.log("Eligible for vote");
# }


# """Python lang"""

# print("Not Eligible for vote" if int(input("Enter your age:")) < 18 else "Eligible for vote")


# for i in range(1, 10, 1):
#   print(i)

# for i in range(0, 20, 2):
#   print(i)

# i = 10
# while i>=0:
#   print(i)
#   i -= 1



# for i in range(1, 6, 1):
#   for j in range(1, i, 1):
#     print(j, end="")
#   print()


# for i in range(1, 4, 1):
#   for j in range(1, 4, 1):
#     print(j, end="");
#   print()


# num = 10

# for i in range(2, num, 1):
#   if num%i == 0:
#     print("Not a prime num")
#     break
# else:
#   print("This is a prime num")


# def printName():
#   print("RUDRA")

# def add(num1, num2):
#   print(num1+num2)

# def is_even(num):
#   if num%2 == 0: return True
#   return False

# printName()
# add(1, 2)
# print(is_even(4))


# def square(num): return num*num

# def max(num1, num2): return num1 if num1 > num2 else num2

# def calc(num1, num2): return num1+num2, (num1+num2)/2

# print(square(8))
# print(max(8, -4))
# print(calc(1, 2))


# def mark(num = 0): print("You got ",num," marks")

# def total(*nums): return sum(nums)

# def info(**kwargs): print(kwargs)

# mark()
# mark(99)

# print(total(2, 3))

# info(name = "Rudra", id = 2401304058)

g = 90

def change(num):
  global g
  g *= num

def fact(num):
  if num == 1: return num
  return num * fact(num-1)

def sum_from_1_to(num):
  if num == 1: return 1
  return num + sum_from_1_to(num-1)


change(2)
print(g)

print(fact(5))
print(sum_from_1_to(10))

