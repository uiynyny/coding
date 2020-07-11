#include <stdlib.h>
#include <stdio.h>

int copy_bit(int src, int dst, int pos)
{
    int shift=pos;
    while(shift>0){
        src>>=1;
        shift--;
    }
    while(shift<pos){
        src<<=1;
        shift++;
    }
    return dst&=src;
}

#ifndef RunTests
int main()
{
    printf("%d", copy_bit(7, 12, 3));
}
#endif