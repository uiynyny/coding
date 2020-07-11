#include <iostream>
#include <vector>
#include <unordered_set>
std::vector<std::string> unique_names(const std::vector<std::string> &names1, const std::vector<std::string> &names2)
{
    std::unordered_set<std::string> hs;
    std::vector<std::string> ret;
    for (std::string n : names1)
    {
        if (hs.find(n) == hs.end())
        {
            ret.push_back(n);
            hs.insert(n);
        }
    }
    for (std::string n : names2)
    {
        if (hs.find(n) == hs.end())
        {
            ret.push_back(n);
            hs.insert(n);
        }
    }
    return ret;
}

#ifndef RunTests
int main()
{
    std::vector<std::string> names1 = {"Ava", "Emma", "Olivia"};
    std::vector<std::string> names2 = {"Olivia", "Sophia", "Emma"};

    std::vector<std::string> result = unique_names(names1, names2);
    for (auto element : result)
    {
        std::cout << element << ' '; // should print Ava Emma Olivia Sophia
    }
}
#endif