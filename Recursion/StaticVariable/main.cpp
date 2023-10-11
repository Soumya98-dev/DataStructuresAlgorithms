#include <iostream>
using namespace std;

int fun(int n)
{
	static int x = 0;
	if(n > 0)
	{	
		x++;
		return fun(n - 1) + x;
	}
}

int main()
{
	int x = 5;
	// fun(x);
	printf("%d\n",fun(x));

}