/*

#include <stdio.h>
#include<string.h>

typedef struct employ{
    char name[20];
    int code;
    int age;
    double salary;
}emp;

int main() {
    emp emp1[100];
    printf("WELCOME TO EMPLOY RECORD\n");
    
    //Input
    printf("ENTER EMPLOY NAME:");
    fgets(emp1[0].name,21,stdin);
    printf("ENTER EMPLOY CODE:");
    scanf("%d",&emp1[0].code);
    printf("ENTER EMPLOY AGE:");
    scanf("%d",&emp1[0].age);
    printf("ENTER EMPLOY SALARY:");
    scanf("%lf",&emp1[0].salary);
    
    //Output
    printf("\nEMPLOY NAME is %s",emp1[0].name);
    printf("EMPLOY CODE is %d\n",emp1[0].code);
    printf("EMPLOY AGE is %d\n",emp1[0].age);
    printf("EMPLOY SALARY is %2lf\n",emp1[0].salary);
    
    return 0;
}

*/

#include<stdio.h>
#include<string.h>

typedef struct book{
    char name[20];
    int page_no;
}book;

int main(){
    book book1[10];
    printf("WELCOME TO BOOK RECORD\n");
    
    //Input
    printf("ENTER BOOK NAME:");
    fgets(book1[0].name,21,stdin);
    printf("ENTER BOOK PAGE NO:");
    scanf("%d",&book1[0].page_no);
    getchar(); //Used for clear the next line created by scanf
    printf("ENTER BOOK NAME:");
    fgets(book1[1].name,21,stdin);
    printf("ENTER BOOK PAGE NO:");
    scanf("%d",&book1[1].page_no);
    
    //Output
    if(book1[0].page_no > book1[1].page_no){
        printf("BOOK OF HIGHEST NO PAGE:-");
        printf("\nBOOK NAME is %s",book1[0].name);
        printf("BOOK PAGE is %d\n",book1[0].page_no);
    }else if(book1[0].page_no < book1[1].page_no){
        printf("BOOK OF HIGHEST NO PAGE:-");
        printf("\nBOOK NAME is %s",book1[1].name);
        printf("BOOK PAGE is %d\n",book1[1].page_no);
    }else{
        printf("THE PAGE NO OF TWO BOOKS ARE EQUAL\nWHICH IS %d",book1[1].page_no);
    }
    return 0;
}
