#include <stdlib.h>
#include <stdio.h>

int are_strings_anagrams(char *a, char *b)
{
    int c[26]={0};
    int d[26]={0};
    
    for(int i=0;a[i]!='\0';++i){
        c[a[i]-'a']++;
    }
    for(int i=0;b[i]!='\0';++i){
        d[b[i]-'a']++;
    }
    for(int i=0;i<26;i++){
        if(c[i]!=d[i]){
            return 0;
        }
    }
    return 1;
}

#ifndef RunTests
int main()
{
    char a[] = "momdad";
    char b[] = "dadmom";
    printf("%d", are_strings_anagrams(a, b));
}
#endif