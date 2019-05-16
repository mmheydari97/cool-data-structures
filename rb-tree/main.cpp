#include <iostream>
#include <sstream>
#include <string>
#include <bits/stdc++.h>
#include "RBTree.h"


int main() {

  RBTree rbTree;
  int max_size;
  int data;
    
  std::cin >> max_size;

  std::string str;
  std::getline(std::cin, str);
  std::getline(std::cin, str);
  std::stringstream ss;
  ss << str;
  
  for(int i{}; i < max_size; i++){
    ss >> data;
    rbTree.rbInsert(data);
  }

  rbTree.rbInorder();

  return 0;
}

