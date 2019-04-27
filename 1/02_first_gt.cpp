#include <iostream>
#include <sstream>
#include <string>

int main(){
  int max_size;
  std::cin >> max_size;
  
  int* arr = new int[max_size]{};

  std::string str;
  std::getline(std::cin, str);
  std::getline(std::cin, str);
  std::stringstream ss;
  ss << str;

  bool flag = 1;
  
  for(int i{}; i < max_size; i++){
    ss >> arr[i];
  }
  
  for(int i{}; i < max_size; i++){
    flag = 1;
    for(int j{i+1}; j<max_size; j++){
      if(arr[j] > arr[i]){
	flag = 0;
	std::cout << arr[j] << " ";
	break;
      }
    }
    if(flag){
      std::cout << "-1 ";
    }
    
  }

  std::cout << std::endl;
  
  return 0;
}
