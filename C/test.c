/*


1------a


#include <stdio.h>
 

int a,b,c;

int main() {
    
    printf("To calculet the Perimeter of the Rectangle \n");
    
    printf("Enter the side a:- ");
   scanf("%d", &a);
    printf("Enter the side b:-");
    scanf("%d", &b);

    c = 2* (a+b);
    
  printf("The Perimeter of the rectangle is :- %d", c);
     
    
    return 0;
}

*/




/*

1-----b

#include<stdio.h>


int n;

int main(){
    
    
    printf("Put The Number 'n' :-");
    
    scanf("%d",&n);
    
    printf("The Cube of the Number 'n' is :- %d",n*n*n);

return 0;
}



*/



/*

1------3


#include<stdio.h>


int a,b;

int main(){
    
    //This is a=3
    a=3;
    
    //This is b=5
     b=5;
    
    printf("%d %d",a,b);
    
}


*/




/*

2-------a


#include<stdio.h>

int a,b,c;


int main(){
    
    printf("Please enter the three numbers to xalculate the avarage \n");
    
    printf("Entet the value of 'a':-");
    scanf("%d",&a);
    
    printf("Enter the value of  'b':-");
    scanf("%d",&b);
    
    printf("Enter the value of 'c':-");
    scanf("%d",&c);
    
    printf("The avarage of a,b&c is:- %f",(a+b+c)/3.0);
}


*/


/*


2---------b

#include<stdio.h>

char n;


int main(){
    
    printf("Write the characetr to know it is digit or not \n");
    
    printf("Enter the character:-");
    scanf("%c", &n);
    
    if(n >= '0' & n <= '9'){
        printf("It is a digit");
    }
        else{
            printf("It is not a Digit");
        }
    
    
    return 0;
    
}


*/


/*



//3--------b

#include<stdio.h>


int  x,y,z,n;

int main(){
    
    printf("Write a number to check it is  NATURAL  number or not \n");
    scanf("%d",&x);
    
    if(x > 0){
        printf("You have entered a NATURAL number");
    }else{
        printf("It is not a NATURAL number");
    }
}


*/



/*

//3-------a


#include<stdio.h>


char str[100];

int main(){
    
    printf("Enter the character  to print in matrix form :-");
    
    scanf("%s",str);
    
    for(int i = 0; i <= 3;i++){        // Here 'i'ßtands for columns
        
        for(int j= 0;j <= 5;j++){      //Here  'j' stands for rows
            printf("%s",str);
        }
        printf("\n");
    }
    printf("End");

return 0;
}


*/



/*


// 5--------a

#include<stdio.h>

int sum,remander,number;

int add(int number);

int main(){
    
    printf("Enter a number to add the digits:-");
    
    scanf("%d",&number);
    
    printf("You have enter:- %d \n",number);
    sum=0;
    
    
    
    printf("The sum of the digits of the number is:- %d",add(number));
    
    return 0;
    
}


int add(int number){
for( number  ; number != 0 ; number /= 10  ){
        remander = (number % 10);
        sum+=remander;
      }
        return sum;
    }


*/



/*

// 5---------b

#include<stdio.h>
#include<math.h>

int num,rootover;

 int root_over( int num);

int main(){
    
    printf("Enter a number to find it's square  a =");
    scanf("%d",&num);
    
    printf("%f",root_over(num));
    
}

int root_over( int num){
    
        rootover = sqrt(num);
   
    printf("a½ = %.4f",rootover);
    return 0;
    
}

*/


/* 
 
// 5-------c

#include<stdio.h>

int temp;
void _temp(int temp);

int main(){
				
			printf("Please Enter the temprature here to know it's state:-");
				scanf("%d",&temp);
				
				_temp(temp);
				
				return 0;
}

void _temp(int temp){
				if(temp <= 20){
								printf("The temprature is COLD");
				}else if(temp > 20 && temp < 50){
								printf("The temprature is NORMAL");
				}else if(temp >= 50 ){
								printf("The temprature is HOT");
				}
}


*/


/*

// 5-----d

#include<stdio.h>

int num,power,pows;
int _pow(int power);

int main(){
				printf("Ente the following details to get the result\n");
				
				printf("Number = ");
				scanf("%d",&num);
				printf("Power = ");
				scanf("%d",&power);
				pows = 1;
				
				printf("Result = %d",_pow(power));
				
}

int _pow(int power){
				for(int i = 0;i < power;i++){
								pows = (pows*num);
								
				}
				return pows; //It is used to print the result
}

*/


/*

// 6------a

#include<stdio.h>

int num1, num2;
int *ptr1 = &num1 ,*ptr2 = &num2; //pointer declaratiin

int main(){
				
				
				
				printf("Enter two numbers to find the maximum number  ");
				printf("Number1 = ");
				scanf("%d",&num1);
				printf(", Number2 = ");
				scanf("%d",&num2);
				
				if(*ptr1 > *ptr2 || *ptr1 < *ptr2){
								if(*ptr1 > *ptr2){
												printf("Maximum number is :-%d",*ptr1);
								}
								if(*ptr1 < *ptr2){
												printf("Maximum number is :-%d",*ptr2);
								}
				}
				return 0;
				
}

*/



/*
// 6-----b

#include<stdio.h>

int a;
char arr[100];

int main(){
				
				char arr[5];
				
				char *ptr =&arr;
				
		 for(int j = 0; j <= 5; j++){
		 				scanf("%c",(ptr+j));
		 }
				
				for(int i = 5;i >= 0; i-- ){
					printf("%c",*(ptr+i));
				}
return 0;
}
*/
				

/*
//6-------c
#include<stdio.h>

char arr[] ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

int main(){
				char *ptr = &arr;
				
				for(int i = 0; i <= 25; i++){
								printf(" %c ,",*(ptr+i));
				}
				printf("%d",sizeof(arr));
				return 0;
}

*/


/*
//7-------a
#include<stdio.h>

int x,n=0,arr[];
int main(){
				printf("Enter some numbers:");
				 for(int i = 0; i <=10; i++){
				 				scanf("%d",&arr[i]);
				 }
				printf("Enter the number that you want to count repeatation:-");
				scanf("%d",&x);
			for(int j=0; j<=10; j++){
							if(arr[j]==x){
											n++;
							}
			}
				printf("The repeate time of '%d' is '%d' times",x,n);
				return 0;
}
*/


/*
//7-------c
#include<stdio.h>

char arr[]={'R','a','h','u','l'},x;
int main(){
				printf("%s\n",arr);
				printf("Enter the element to insert at the end");
				scanf("%c",&x);
				for(int i=0; i<90 ; i++){
								if(arr[i]=='\0'){
												arr[i]=x;
												break;
								}
								
				}
								printf("%s\n",arr);
				return 0;
}

*/


/*
//8-------a
#include<stdio.h>
#include<string.h>
int main(){
				char vowels[] = "aeiou";
				int i=0;
				while(i < strlen(vowels)){
								vowels[i]=toupper(vowels[i]);
								i++;
}
				printf("%s",vowels);
				return 0;
}

*/


/*
//8--------d
#include<stdio.h>
#include<string.h>
int main(){
				char string[]="Hii dear how are tou.";
				int condition=0;
				printf("Press '1' for UPPERCASE & '2' for LOWERCASE\n");
				scanf("%d",&condition);
				switch(condition){
								case 1:
								for(int i=0; i < strlen(string); i++){
												string[i]=toupper(string[i]);
								}
								printf("%s",string);
								break;
								case 2:
								for(int i=0; i < strlen(string); i++){
												string[i]=tolower(string[i]);
								}
								printf("%s",string);
								break;
								default:
								printf("You have entered a invalid key");
				}
				return 0;
}

*/

/*

//9
#include<stdio.h>
#include<string.h>

struct student{
				char name[100];
				int roll;
				char sec;
				int cgpa;
}stu;

struct teacher{
				char name[100];
				int id;
				char branch[50];
}te;

struct staf{
				char name[100];
				int id;
				char branch[50];
};

int main(){
				struct student s[50];
				struct teacher t[20];
				struct staf sf[20];
				
				
				
				return 0;
}


*/
/*
#include<stdio.h>

int main(){
				int arr[3][3]={{1,2,3,4,},{5,6,7,8,9,}};
				printf("%d",arr[3][3]);
				return 0;
}

*/
































/*


// 5-------a

#include<stdio.h>

int a,b;

int add(int a,int b);

int main(){
    
    printf("Enter two numbers to add:-");
    
    scanf("%d%d",&a,&b);
    
    add(a,b);
    
    return 0;
}

int add(int a, int b){
    
    printf("The addition is :-%d",a+b);
    
}


*/