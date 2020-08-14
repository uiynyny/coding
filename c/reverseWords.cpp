#include <string>

class Solution
{
private:
    void cleanSpace(std::string &s)
    {
        int i=0,j=0;
        while(j<s.length()){
            while(j<s.length() && s[j]==' ')j++; //skip space
            while(j<s.length() && s[j]!=' ')s[i++]=s[j++]; //copy s[j] to s[i] 
            while(j<s.length() && s[j]==' ')j++; //skip space again
            if(j<s.length())s[i++]=' '; //keep one space
        }
        s.erase(i,s.size());
    }

    void reverseWord(std::string &s)
    {
        int i = 0, j = 0;
        while (i < s.length())
        {
            while(i<j || (i<s.length() && s[i]==' '))i++;
            while(j<i || (j<s.length() && s[j]!=' '))j++;
            reverse(s,i,j-1);
        }
    }

    void reverse(std::string &s, int l, int r)
    {
        while (l < r)
        {
            char t = s[l];
            s[l++] = s[r];
            s[r--] = t;
        }
    }

public:
    std::string reverseWords(std::string s)
    {
        cleanSpace(s);
        if (s.empty()) return s;
        reverse(s, 0, s.length() - 1);
        reverseWord(s);
        return s;
    }
};

int main(int argc, char const *argv[])
{
    Solution s;
    s.reverseWords(" ");
    s.reverseWords("   a   b  c d   e  ");
    s.reverseWords("the sky is blue");
    s.reverseWords("  hello world!  ");
    return 0;
}
