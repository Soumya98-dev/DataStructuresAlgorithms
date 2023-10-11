#include <iostream>
using namespace std;

int power(int m, int n)
{
    if(n == 0)
    {
        return 1;
    }
    else
    {
        return power(m, n -1) * m;
    }
}


int main()
{
    int m = 2, n = 5;
    cout << power(2,5);
    return 0;
}