#include <vector>
#include <unordered_map>
#include <string>
#include <sstream>

class Solution
{
public:
    std::vector<std::vector<std::string>> findDuplicate(std::vector<std::string> &paths)
    {
        std::unordered_map<std::string, std::vector<std::string>> m;
        std::vector<std::vector<std::string>> res;
        for (const auto &p : paths)
        {
            std::stringstream ss(p);
            std::string s;
            std::string dirName;
            std::getline(ss, dirName, ' ');
            while (ss >> s)
            {
                auto fileName = s.substr(0, s.find('('));
                auto fullName = dirName + '/' + fileName;
                auto content = s.substr(s.find('(') + 1, s.find(')') - s.find('(') - 1);
                m[content].push_back(fullName);
            }
        }

        for (const auto &e : m)
        {
            if (e.second.size() > 1)
                res.push_back(e.second);
        }

        return res;
    }
};