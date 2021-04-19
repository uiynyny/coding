#include <stdio.h>
#include <string.h>

struct Node
{
    char *value;
    int len;
    Node *next;
};

void foo(char *a, int l)
{
    printf("%s\n",a);
    Node *t = new Node();
    t->value = a;
    char** b;
    *b=t->value;
    t->len=l;
    int c=t->len;
    a="abcs";
    printf("%s %d",*b,c);
    t->len = l;
    return;
}
int main(int argc, char const *argv[])
{
    char *a = "abcd";
    foo(a, 4);
    return 0;
}
