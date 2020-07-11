#include <stdexcept>
#include <string>
#include <iostream>

class Node
{
public:
    Node(int value, Node *left, Node *right)
    {
        this->value = value;
        this->left = left;
        this->right = right;
    }

    int getValue() const
    {
        return value;
    }

    Node *getLeft() const
    {
        return left;
    }

    Node *getRight() const
    {
        return right;
    }

private:
    int value;
    Node *left;
    Node *right;
};

class BinarySearchTree
{
public:
    static bool contains(const Node &root, int value)
    {
        if (&root==nullptr){
            return false;
        }
        if (root.getValue() == value)
            return true;
        else if (value < root.getValue())
            return contains((*root.getLeft()), value);
        else
            return contains((*root.getRight()), value);
    }
};

#ifndef RunTests
int main()
{
    Node n1(1, NULL, NULL);
    Node n3(3, NULL, NULL);
    Node n2(2, &n1, &n3);
    Node *n=n1.getLeft();
    std::cout << BinarySearchTree::contains(*n, 5);
}
#endif