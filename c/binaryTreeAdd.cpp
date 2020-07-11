#include <stdexcept>
#include <string>
#include <iostream>

// The Node class is provided to you.
// NOTE: you **MAY** alter this class if you wish
class Node
{
public:
    Node(int value, Node* left, Node* right)
    {
        this->value = value;
        this->left = left;
        this->right = right;
    }

    int getValue() const
    {
        return value;
    }

    Node* getLC() const
    {
        return left;
    }

    Node* getRC() const
    {
        return right;
    }
    void setValue(int value){
        this->value = value;
    }
    void setLC(Node* left){
        this->left = left;
    }
    void setRC(Node* right){
        this->right = right;
    }

private:
    int value;
    Node* left;
    Node* right;
};

class BinaryTreeAdd
{
public:
    
    //OPTIONAL -- see the description for cpNode in the Notes section
    static Node* cpNode(Node* t) {
        if(t == NULL) {
            return NULL;
        }
        //OPTIONAL -- Implement your deep copy here
        //deep copy of the tree by recursion
        Node* root=new Node(t->getValue(),nullptr,nullptr);
        root->setLC(cpNode(t->getLC()));
        root->setRC(cpNode(t->getRC()));
        return root;
    }
    
    static Node* add(Node* t1, Node* t2)
    {
        //
        // Implement your solution here
        //
        if(t1==NULL&&t2==NULL)return NULL;
        
        //creating new node as sum
        int value=0;
        if(t1!=NULL)value+=t1->getValue();
        if(t2!=NULL)value+=t2->getValue();
        Node *root=new Node(value,NULL,NULL);

        //recurse on the children with null checking
        Node* t1_left = t1==NULL? NULL:t1->getLC();
        Node* t2_left = t2==NULL? NULL:t2->getLC();
        Node* t1_right = t1==NULL? NULL:t1->getRC();
        Node* t2_right = t2==NULL? NULL:t2->getRC();
        
        root->setLC(add(t1_left,t2_left));
        root->setRC(add(t1_right,t2_right));
        return root;
    }
};

#ifndef RunTests
int main()
{
    // Add print debugging or tests here if you wish
    // Add print debugging or tests here if you wish
    Node n1(1, NULL, NULL);
    Node n3(3, NULL, NULL);
    Node n2(2, &n1, &n3);

    Node t1(1,NULL,NULL);
    Node t2(2,NULL,NULL);
    Node t3(3,&t1,&t2);

    Node * r1=BinaryTreeAdd::cpNode(&t3);
    Node * r2=BinaryTreeAdd::cpNode(&n2);
    Node * res=BinaryTreeAdd::add(r1,r2);
    return 0;
}
#endif