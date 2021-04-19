#include <iostream>
#include <vector>

int alienEncode(std::vector<int> &A)
{
    int up = 0, down = 0, violation = 0;
    for (int i = 1; i < A.size(); ++i)
    {
        if (A[i] > A[i - 1])
        {
            up += 1;
            down = 0;
        }
        else
        {
            down += 1;
            up = 0;
        }
        if (up > 3 || down > 3)
        {
            violation++;
            up = down = 0;
        }
    }
    return violation;
}


int main(int argc, char const *argv[])
{
    int n;
    std::cin >> n;
    for (int i = 0; i < n; ++i)
    {
        int size;
        std::cin >> size;
        std::vector<int> arr(size);
        for (int j = 0; j < size; ++j)
        {
            std::cin >> arr[j];
        }

        int ans = solve(arr);
        std::cout << "Case #" << i + 1 << ": " << ans << std::endl;
    }

    return 0;
}
