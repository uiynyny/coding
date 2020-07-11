#include <vector>
#include <stdexcept>
#include <iostream>

int countNumbers(const std::vector<int> &sortedVector, int lessThan)
{
    if (sortedVector.back() == lessThan)
        return sortedVector.size() - 1;
    else if (sortedVector.back() < lessThan)
        return sortedVector.size();
    else if (sortedVector.front() > lessThan)
        return 0;
    else
    {
        int i = 0;
        int j = sortedVector.size() - 1;
        while (i < j)
        {
            int mid = i+(j-i) / 2;
            if (sortedVector[mid] < lessThan)
                i = mid + 1;
            else
                j = mid;
        }
        return i;
    }
}

#ifndef RunTests
int main()
{
    std::vector<int> v{1, 3, 5, 7};
    std::cout << countNumbers(v, 4);
}
#endif