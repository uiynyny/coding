#include <stdio.h>
int check(int a[],int b[]){
    for(int i=0;i<26;i++){
        if(a[i]>0 ^ b[i]>0){
            return 0;
        }
    }
    return 1;
}
int shortestBalancedSubString(char *str)
{
    int up[26]={0};
    int lo[26]={0};

    int left = 0;
    for (int r = 0; str[r] != '\0'; r++)
    {
        if(str[r]>='A'&&str[r]<='Z'){
            up[str[r]-'A']++;
        }else if(str[r]>='a'&&str[r]<='z'){
            lo[str[r]-'a']++;
        }
        printf("check is %d\n",check(up,lo));
    }
    return 0;
}

int main()
{
    char *test = "azABaabza";
    int a = shortestBalancedSubString(test);
    return 0;
}