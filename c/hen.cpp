#include <iostream>
#include <string>

class Egg;

enum class Type
{
    Chicken,
    Duck
};

class IBird
{
public:
    static IBird *create_type(Type t);
    virtual Egg *Lay() = 0;
    virtual void Speak() = 0;
};

class Egg
{
private:
    Type t;

public:
    Egg(Type t)
    {
        this->t = t;
    }
    IBird *Hatch()
    {
        return IBird::create_type(t);
    }
};

class Chicken : public IBird
{
public:
    Chicken() { std::cout << "chicken produced" << std::endl; }
    void Speak() { std::cout << "chicken speak" << std::endl; }
    Egg *Lay()
    {
        std::cout << "chicken laying\n";
        return new Egg(Type::Chicken);
    }
};

class Duck : public IBird
{
public:
    Duck() { std::cout << "duck produced" << std::endl; }
    void Speak() { std::cout << "duck speak" << std::endl; }
    Egg *Lay()
    {
        std::cout << "duck laying\n";
        return new Egg(Type::Duck);
    }
};

IBird *IBird::create_type(Type t)
{
    switch (t)
    {
    case Type::Chicken:
        return new Chicken();
    case Type::Duck:
        return new Duck();
    default:
        return nullptr;
    }
}

int main()
{
    Chicken *chicken1 = new Chicken();
    Egg *egg = chicken1->Lay();
    Chicken *childChicken = dynamic_cast<Chicken *>(egg->Hatch());
    childChicken->Speak();
    delete chicken1;
    delete childChicken;

    Duck *duck1 = new Duck();
    Egg *egg1 = duck1->Lay();
    Duck *duckChildren = dynamic_cast<Duck *>(egg1->Hatch());
    duckChildren->Speak();
}