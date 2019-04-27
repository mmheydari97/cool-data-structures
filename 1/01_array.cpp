#include <iostream>
#include <sstream>
#include <string>

int main(){
  int max_size;
  int a;
  std::cin >> a;

  max_size = a%2==0?a+1:a;
  
  int* arr = new int[max_size]{};

  std::string str;
  std::getline(std::cin, str);
  std::getline(std::cin, str);
  std::stringstream ss;
  ss << str;
  
  for(int i{}; i < a; i++){
    ss >> arr[i];
  }
  
  if(a != max_size){
    arr[max_size-1] = arr[max_size-2];
  }
    
  bool flag = 1;

  for(int i{}; i < max_size/2; i++){
    if(arr[i] < arr[2*i+1] or arr[i] < arr[2*i+2]){
	flag = 0;
	break;
      }
  }

    if(flag){
      std::cout<<"YES"<<std::endl;
    }
    else{
      std::cout<<"NO"<<std::endl;
    }
  
  return 0;
}
