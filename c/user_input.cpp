#include <iostream>
#include <string>

class TextInput
{
private:
    std::string value;
public:
    ~TextInput(){}
    virtual void add(char c) { value.push_back(c); }
    
    std::string getValue() { return value; }
};

class NumericInput : public TextInput
{
public:
    void add(char c)
    {
        if (c>='0'&&c<='9')
            TextInput::add(c);
    }
};

#ifndef RunTests
int main()
{
    TextInput *input = new NumericInput();
    input->add('1');
    input->add('a');
    input->add('0');
    std::cout << input->getValue();
}
#endif