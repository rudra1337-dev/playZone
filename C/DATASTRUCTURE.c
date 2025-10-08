/*
//STACK
#include <stdio.h>
#define MAXSIZE 10
int stack[2],top=-1,choice;
int push(){
				if(top+1==sizeof(stack)){
							printf	("STACK IS FULL");
				}else{
								int n;
								printf("ENTER A NUMBER:-");
								scanf("%d",&n);
								top++;
								stack[top]=n;
				}
}

int display(){
		for(int i=top; i>=0; i--){
						printf("%d\n",stack[i]);
		}		
}

int pop(){

				if(top==-1){

								printf("STACK IS EMPTY");
				}else{
								int n=stack[top];
								top--;
								printf("THE POPED ELEMENT IS %d",n);
				}
}

int main() {
				do{
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				printf("~~~~~~~~~~~~~~~~~~~~STACK~~~~~~~~~~~~~~~~~~\n");
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				printf("PRESS FOR\n1.push()\n2.pop()\n3.display()\n4.EXIT\n");
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				printf("ENTER YOUR CHOICE HERE:-");
				scanf("%d",&choice);
				switch(choice){
								case 1 : push();
								      break;
								case 2 : pop();
								      break;
								case 3 : display();
								      break;
								case 4 : printf("SYSTE TERMINATED SUCCESSFULLY\n");
								      break;
								default : printf("YOU HAVE ENTERED AN INVALID OPTION");
				}
				} while(choice!=4);
				printf("%d",sizeof(stack));
				return 0;
}

*/






/*

#include <stdio.h>
#define max 2
int queue[max],choice,rearer=-1,front=0;

int insert(){
			if(rearer==max-1){
						printf("QUEUE IS FULL");
			}else{
						int n;
						printf("ENTER AN ELEMENT:-");
						scanf("%d",&n);
						rearer++;
						queue[rearer]=n;
			}
}

int delete(){
			if(rearer<front){
						printf("QUEUE IS EMPTY");
			}else{
						int n=queue[front];
						front++;
						printf("THE DELETED ELEMENT IS:-%d",n);
			}
}

int display(){
			if(rearer<front){
						printf("QUEUE IS EMPTY");
			}else{
						printf("QUEUE EEMENTS ARE:-\n");
						for(int i=front; i<=rearer; i++){
									printf("%d\n",queue[i]);
						}
			}
}


int main() {
			
				do{
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				printf("~~~~~~~~~~~~~~~~~~~~LINEAR QUEUE~~~~~~~~~~~~~~~~~~\n");
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				printf("PRESS FOR\n1.insert()\n2.delete()\n3.display()\n4.EXIT\n");
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							printf("R=%d ,F=%d\n",rearer,front);
				printf("ENTER YOUR CHOICE HERE:-");
				scanf("%d",&choice);
				switch(choice){
								case 1 : insert();
								      break;
								case 2 : delete();
								      break;
								case 3 : display();
								      break;
								case 4 : printf("SYSTE TERMINATED SUCCESSFULLY\n");
								      break;
								default : printf("YOU HAVE ENTERED AN INVALID OPTION");
				}
				} while(choice!=4);
				printf("%lu",sizeof(queue));
			
				return 0;
}

*/



/*

#include <stdio.h>
#define max 5
int queue[max],choice,rear=-1,front=-1;

int insert(){
				if((rear+1)%max==front){
								printf("QUEUE IS OVERFLOW");
				}else{
								printf("ENTER A NUMBER HERE:-");
								if(rear==-1 && front==-1){
												front=0;
												rear=0;
								}else{
								rear=(rear+1)%max;
								}
								scanf("%d",&queue[rear]);
				}
}

int delete(){
				if(front==-1 && rear==-1){
								printf("QUEUE IS EMPTY");
				}else{
								int n=queue[front];
								printf("DELETED ELEMENT IS:-");
								if(front==rear){
												front=-1;
												rear=-1;
								}else{
												front=(front+1)%max;
								}
								printf("%d",n);
				}
}

int display(){
				if(front==-1 && rear==-1){
								printf("QUEUE IS EMPTY");
				}else{
								int i;
								printf("QUEUE ELEMENTS ARE:-");
								for(i=front; i!=rear; i=(i+1)%max){
												printf("%d,",queue[i]);
								}
								printf("%d",queue[i]);
				}
}

int main() {
			
				do{
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				printf("~~~~~~~~~~~~~~~~~~~CIRCULAR QUEUE~~~~~~~~~~~~~~~~~~~\n");
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				printf("PRESS FOR\n1.insert()\n2.delete()\n3.display()\n4.EXIT\n");
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							printf("R=%d ,F=%d\n",rear,front);
				printf("ENTER YOUR CHOICE HERE:-");
				scanf("%d",&choice);
				switch(choice){
								case 1 : insert();
								      break;
								case 2 : delete();
								      break;
								case 3 : display();
								      break;
								case 4 : `printf("SYSTE TERMINATED SUCCESSFULLY\n");
								      break;
								default : printf("YOU HAVE ENTERED AN INVALID OPTION");
				}
				} while(choice!=4);
				printf("%lu",sizeof(queue));
				
				return 0;
}

*/

#include<stdio.h>
#include<stdlib.h>

typedef struct node{
				int data;
				struct node *add;
}link;
link *pre,*next,*start=NULL,*temp,*_new;

void create(){
				int n;
				printf("ENTER AN ELEMENT:-");
				scanf("%d",&n);
				temp=(link*)calloc(1,sizeof(link));
				temp->data=n;
				temp->add=NULL;
				start=temp;
				char ch;
				printf("WANT TO CONTINUE(Y/N):-");
				scanf("%s",&ch);
				while(ch=='Y'||ch=='y'){
								printf("ENTER AN ELEMENT:-");
								scanf("%d",&n);
								_new=(link*)calloc(1,sizeof(link));
								_new->data=n;
								_new->add=NULL;
								temp->add=_new;
								temp=temp->add;
								
								printf("WANY TO CONTINUE(Y/N):-");
				scanf("%s",&ch);
				}
}

void display(){
				if(start==NULL){
								printf("LIST NOT FOUND");
				}else{
								printf("THE LINK-LIST DATA ARE:-");
				int length=0;
				link *counter=start;
				while(counter!=NULL){
								printf("%u,",*counter);
								counter=counter->add;
								length++;
				}
				printf("\nLINK-LIST length is:-%d",length);
				}
}

void insert_first(){
				int n;
				printf("ENTER ELEMENT TO INSERT IN FIRST:-");
				scanf("%d",&n);
				_new=(link*)calloc(1,sizeof(link));
				_new->data=n;
				_new->add=start;
				start=_new;
}

void insert_last(){
				int n;
				printf("ENTER ELEMENT TO INSERT IN LAST:-");
				scanf("%d",&n);
				_new=(link*)calloc(1,sizeof(link));
				temp=start;
				_new->data=n;
				_new->add=NULL;
				while(temp->add!=NULL){
								temp=temp->add;
				}
				temp->add=_new;
}

void insert_middle(){
				int pos,n,length;
				printf("ENTER ELEMENT TO INSERT IN MIDDLE:-");
				scanf("%d",&n);
				printf("ENTER THE POSITION:-");
				scanf("%d",&pos);
				link *counter=start;
				while(counter!=NULL){
								counter=counter->add;
								length++;
				}
				while(pos>=length||pos==1){
								if(pos==1){
											insert_first();
												break;
								}else{
								printf("\nLINK-LIST length is:-%d",length);
								printf("\nYOUR POSITION IS OUT OF RANGE PLEASE REENTER < %d:-",length);
												scanf("%d",&pos);
								}
				}
				_new=(link*)calloc(1,sizeof(link));
				_new->data=n;
				pre=start;
				for(int i=1;i <pos;i++){
								pre=pre->add;
				}
				next=pre->add;
				pre->add=_new;
				_new->add=next;
}

void delete_first(){
				if(start==NULL){
								printf("LIST NOT FOUND");
				}{
						temp=start;
				start=start->add;
				printf("THE DELETED NODE IS %d",temp->data);
				free(temp);		
				}
}

void delete_last(){
				if(start==NULL){
								printf("LIST NOT FOUND");
				}else{
												temp=start;
												while(temp->add==NULL){
																pre=temp;
																temp=temp->add;
												}
												pre->add=NULL;
												printf("THE DELETED ELEMENT IS %d",temp->data);
												free(temp);
				}
}

void delete_middle(){
				int pos;
				printf("ENTER THE POSITION:-");
				scanf("%d",&pos);
				
				//COUNTER FUNCTION
				link *counter=start;
				int length;
				while(counter!=NULL){
								counter=counter->add;
								length++;
				}
				
				while(pos>=length||pos==1){
								if(pos==1){
											insert_first();
												break;
								}else{
								printf("\nLINK-LIST length is:-%d",length);
								printf("\nYOUR POSITION IS OUT OF RANGE PLEASE REENTER < %d:-",length);
												scanf("%d",&pos);
								}
				}
				temp=start;
				for(int i=1;i <pos;i++){
								pre=temp;
								temp=temp->add;
				}
				next=temp->add;
				pre->add=next;
				printf("THE DELETED NODE IS %d",temp->add);
				free(temp);
}

int main(){
				int choice;
				do{
								printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				printf("~~~~~~~~~~~~~~~~~~~LINKED LIST MENUE~~~~~~~~~~~~~~~~~~~\n");
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				printf("PRESS FOR\n1.create()\n2.insert_first()\n3.insert_middle()\n4.insert_last\n5.delete_first()\n6.delete_middle()\n7.delete_last()\n8.display()\n9.EXIT\n");
				printf("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				printf("ENTER YOUR CHOICE HERE:-");
				scanf("%d",&choice);
			
				switch(choice){
								case 1:create();
								    break;
								case 2:insert_first();
								    break;
								case 3:insert_middle();
								    break;
								case 4:insert_last();
								    break;
								case 5:delete_first();
								    break;
								case 6:delete_middle();
								    break;
								case 7:delete_last();
								    break;
								case 8:display();
								    break;
								case 9:printf("SYSTE TERMINATED SUCCESSFULLY\n");
								      break;
								default : printf("YOU HAVE ENTERED AN INVALID OPTION");
				}
				}while(choice!=9);
		 return 0;
				}
















































































































/*

// Online C compiler to run C program online
#include <stdio.h>

int main() {
    // Write C code here
   int arr[10]={1,2,3,4,5,6,7,8,9,10};
    char a[]="uuuuuu";
   int *ptr=&arr[10];
    printf("%s",a);
for(int i=0;i<=9;i++){
    
    printf("%d,",*ptr);
    ptr--;
}
    return 0;
}

*/