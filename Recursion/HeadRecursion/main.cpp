//HEAD RECURSION BECAUSE RECURSIVE CALL IS THE 1ST STATEMENT IN THE FUNCTION

#include <iostream>
using namespace std;

void fun(int n)
{
	if(n > 0)
	{
		fun(n-1);
		printf("%d\n", n);
	}
}

int main()
{
	int x = 3;
	fun(3);
}