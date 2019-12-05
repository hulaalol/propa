#include <stdio.h>


int fibonacci(int n) {
    int x = 1;
    int y = 2;
    
    if(n == 0){
        return x - 1;
    } else if(n == 1) {
        return y - x;
    } else {
        return (fibonacci(n-x) + fibonacci(n-y));
    }
}

int main() {
   int n = 5;
   int i;

   printf("Fibonacci of %d: " , n);

   for(i = 0;i<n;i++) {
      printf("%d ",fibonacci(i));
   }

   return 0;
}