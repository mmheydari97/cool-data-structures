#ifndef RED_BLACK_TREE_RBTREE_H
#define RED_BLACK_TREE_RBTREE_H

enum Color {RED, BLACK, DOUBLE_BLACK};

struct Node
{
  int key;
  int color;
  Node *left, *right, *parent;

  // prevent unwanted cast
  explicit Node(int);
  
};

class RBTree
{
    private:
        Node *root;
	
    protected:
        void rotateLeft(Node *&);
        void rotateRight(Node *&);
	
        void rbTreeInsertFixup(Node *&);
        void rbTreeDeleteFixup(Node *&);

	void inorderBST(Node *&);

	int getColor(Node *&);
        void setColor(Node *&, int);

	Node *minValueNode(Node *&);
        Node *maxValueNode(Node *&);

	Node* insertBST(Node *&, Node *&);
        Node* deleteBST(Node *&, int);

	int getBlackHeight(Node *);
	
    public:
	
        RBTree(); // constructor
        void rbInsert(int);
        void rbDelete(int);
        void rbInorder();
};

#endif
