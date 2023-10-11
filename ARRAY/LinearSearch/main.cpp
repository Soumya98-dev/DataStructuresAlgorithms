#include <iostream>
using namespace std;

int *arr(int length)
{
    int *A = new int[length];
    for (int i = 0; i < length; i++)
    {
        A[i] = i + 1;
    }
    return A;
}

void display(int arr[], int length)
{
    for (int i = 0; i < length; i++)
    {
        cout << arr[i] << " ";
    }
}

int linearSearch(int key, int arr[], int length)
{
    for (int i = 0; i < length; i++)
    {
        if (key == arr[i])
        {
            return i;
        }
    }
    return -1;
}

int main()
{
    int length = 6;
    int *A = arr(length);
    cout << linearSearch(4, A, length) << endl;
    display(A, length);
    return 0;
}
