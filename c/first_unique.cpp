#include <stdexcept>
#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

std::string firstUniqueName(const std::vector<std::string> &names)
{
    //store value and index of the given element
    std::unordered_map<std::string, int> hash_map;
    
    //iterate and store appear time into hashmap
    for (int i = 0; i < names.size(); ++i)
    {
        hash_map[names[i]] += 1;
    }
    
    //iterate through hashmap by name appearance and return the first element with appearence with 1
    for (int i=0;i<names.size();++i)
    {
        if (hash_map[names[i]] == 1)
            return names[i];
    }
    return "";
}

#ifndef RunTests
int main()
{
    std::vector<std::string> names = {"Abbi", "Adeline", "Abbi", "Adeline","Adalia"};
    std::cout << firstUniqueName(names);
}
#endif