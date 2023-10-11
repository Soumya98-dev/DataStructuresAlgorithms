#include <iostream>
#include <cmath>
using namespace std;

int sum(int n)
{
    if(n == 0)
    {
        return 1;
    }
    else
    {
        return sum(n - 1) + n;
    }
}

int fact(int n)
{
    if(n == 0)
        return 1;
    else
        return fact(n - 1) * n;
}

int pow(int m, int n)
{
    if(n == 0)
        return 1;
    else    
        return pow(m, n - 1) * n;
}

int taylor(int m, int n)
{
    if(n == 0)
    {
        return 1;
    }
    else
    {
        return pow(sum(n), pow(m, n))/fact(n);
    }
}

int main()
{   
    int m = 2;
    int n = 9;
    cout << taylor(2,9);
    return 0;
}