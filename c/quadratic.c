#include <stdlib.h>
#include <stdio.h>

double sqrt(double n)
{
    if (n <= 0)
        return 0;
    double guess = 1;
    double prev = 0;
    double diff=0;
    double eps = 1e-10;
    do
    {
        prev = guess;
        guess = (n / guess + guess) / 2;
        diff = guess - prev;
    } while (diff > eps || diff < -eps);

    return guess;
}

int main()
{
    double a = sqrt(8.0);
}