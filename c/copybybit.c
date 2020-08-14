#include <stdlib.h>
#include <stdio.h>

int copy_bit(int src, int dst, int pos)
{
    int bit = ((src >> pos) & 1) << pos;
    dst &= ~(1 << pos);
    dst |= bit;
    return dst;
}

#ifndef RunTests
int main()
{
    printf("%d", copy_bit(7, 12, 3));
}
#endif