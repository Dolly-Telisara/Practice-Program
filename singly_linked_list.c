// Linked list in C =>

#include<stdio.h>
#include<stdlib.h>

typedef int BOOL;
#define TRUE 1
#define FALSE 0

struct node
{
    int data;
    struct node *next;
};
struct node *head=NULL;

struct node *createNode()
{
    struct node *new_node;
    new_node = (struct node *)malloc(sizeof(struct node));
    return new_node;
}

void insertLastNode()
{
    struct node *temp, *t;
    temp = createNode();

    printf("\n Enter a number(data) : ");
    scanf("%d",&temp->data);

    temp->next = NULL;

    if(head==NULL)
    {
        head = temp;
    }

    else
    {
        t = head;

        while(t->next!= NULL)
        {
            t = t->next;
        }
        t->next = temp;
    }
    printf("\n Head's value : %d",head);
}

void displayList()
{
    struct node *traverse;
    
    if(head == NULL)
    {
        printf("Linked List is Empty!");
    }
    else
    {
         traverse = head;
          while(traverse!=NULL)
          {
              printf(" %d -> \t",traverse->data);
              traverse = traverse->next;
          }
    }
    

}

int main()
{
    int n;
    int i=0;
   
    printf("\n Create a Linked List =>\n");

    printf("\n How many nodes do you want to insert in a Linked List : ");
    scanf("%d",&n);

    for(i=1;i<=n;i++)
    {
        printf("\n Node %d :  ",i);
        
        insertLastNode();       
    }
    displayList();
}