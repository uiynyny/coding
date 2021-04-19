#include <stdio.h>

int main()
{
    char *s = "azABaabza";
    int uppercase[26] = {0};
    int freq[26] = {0};

    int l=-1;
    for(int r=0;s[r]!='\0';r++){
        char c=s[r];
        if(c>='a'&&c<='z'){
            c=c-'a'+'A';
        }
        if(c==s[r]){
            uppercase[c]
        }
    }
}