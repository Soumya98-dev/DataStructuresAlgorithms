#include <iostream>
#include <cmath>
using namespace std;

int *arrCreate(int length)
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

int rBinarySearch(int low, int high, int key, int arr[], int length)
{
    int mid = floor((low + high) / 2);
    while (low <= high)
    {
        if (key == arr[mid])
        {
            return mid;
        }
        else if (key < arr[mid])
        {
            return rBinarySearch(low, mid - 1, key, arr, length);
        }
        else
        {
            return rBinarySearch(mid + 1, high, key, arr, length);
        }
    }
}

int main()
{
    int length = 10;
    int *arr = arrCreate(length);
    int low = 1;
    int high = length;
    display(arr, length);
    cout << endl;
    cout << rBinarySearch(low, high, 7, arr, length);
    return 0;
}