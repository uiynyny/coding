#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double binaryToDecimal(char *binary, int len)
{
    // Fetch the radix point
    int point = -1;
    // since a char * will end with special character '\0', we could find the end of char* by finding the '\0' in array
    for (int i = 0; i < len && binary[i] != '\0'; i++)
    {
        if (binary[i] == '.')
        {
            point = i;
            break;
        }
    }

    // Update point if not found
    if (point == -1)
        point = len;
    // printf("Debug point: %d\n", point);
    double intDecimal = 0, fracDecimal = 0, twos = 1;

    // Convert integral part of binary to decimal
    // equivalent
    for (int i = point - 1; i >= 0; --i)
    {
        // Subtract '0' to convert character
        // into integer
        intDecimal += (binary[i] - '0') * twos;
        twos *= 2;
    }
    // printf("Debug intDecimal : %f\n", intDecimal);
    // Convert fractional part of binary to
    // decimal equivalent
    twos = 2;
    for (int i = point + 1; i < len && binary[i] != '\0'; ++i)
    {
        fracDecimal += (binary[i] - '0') / twos;
        twos *= 2.0;
    }
    // printf("Debug fracDecimal : %f\n", fracDecimal);
    // Add both integral and fractional part
    return intDecimal + fracDecimal;
}
char *convert_tobinary(double num, int k_prec)
{
    char *binary = calloc(128, sizeof(char));
    //getting the integer part
    int Integral = num;
    //getting the fractional part
    double fractional = num - Integral;
    //converting integer to binary
    int digit = 0;
    while (Integral)
    {
        int rem = Integral % 2;
        binary[digit] = rem + '0';
        digit++;
        Integral /= 2;
    }
    //reversing the string to get the
    //required binary number
    //reverse(binary.begin(), binary.end());
    //binary.push_back('.');

    char *temp = calloc(128, sizeof(char));
    int i = 0;
    while (digit-- > 0)
    {
        temp[i] = binary[digit];
        i++;
    }
    temp[i++] = '.';
    //converting fraction to binary
    while (k_prec--)
    {
        fractional *= 2;
        int fract_bit = fractional;
        fractional -= fract_bit;
        temp[i] = fract_bit + '0';
        i++;
    }
    return temp;
}

int main()
{

    // printf("%f", binaryToDecimal("010101101.1", 11));
    // printf("%f", binaryToDecimal("0110101110.1", 22));
    // printf("%f", binaryToDecimal("11111111.1", 33));

    int k;
    printf("binary to decimal press1\n");
    printf("binary to decimal press2\n");
    scanf("%d", &k);
    if (k == 1)
    {
        int len = 0;
        printf("binary length\n");
        scanf("%d", &len);
        char *arr = malloc(sizeof(char) * len);
        printf("enter a binary number\n");
        scanf("%s", arr);
        printf("Debug output : %s\n", arr);
        double ret = binaryToDecimal(arr, len);
        printf("%f\n", ret);
        free(arr);
    }
    else
    {
        double n;
        int k;

        printf("enter n\n");
        scanf("%lf", &n);
        printf("enter k\n");
        scanf("%d", &k);
        char *res = convert_tobinary(n, k);
        printf("%s\n", res);
        free(res);
    }

    return 0;
}
