#include <stdio.h>
#include <stdlib.h>
#include <iostream>

struct Node {
  int key;
  Node* left;
  Node* right;
  // we start from the root to the child so there is no need
  // to store a pointer to the parent
};


Node* newNode(int data);
void inorderPrint( Node* root);

int main(){
  Node* root = newNode(1);
  root->left = newNode(2);
  root->right = newNode(3);
  root->left->left = newNode(4);
  root->left->right = newNode(5);

  inorderPrint(root);
  
  return 0;
}


Node* newNode(int data){
  
  Node* node = new Node;
  node->key = data;
  node->left = NULL;
  node->right = NULL;

  return node;
}


void inorderPrint( Node* root){

  Node *current, *pre;
  if (root == NULL)
    return;

  current = root;
  while (current != NULL) {

    if (current->left == NULL) {
      std::cout<< current->key<< " ";
      current = current->right;
    }
    else {
      pre = current->left;
      while (pre->right != NULL && pre->right != current)
	pre = pre->right;
      if (pre->right == NULL) {
	pre->right = current;
	current = current->left;
      }
      else {
	pre->right = NULL;
	std::cout<< current->key<< " ";
	current = current->right;
      }
    }
  }
}
