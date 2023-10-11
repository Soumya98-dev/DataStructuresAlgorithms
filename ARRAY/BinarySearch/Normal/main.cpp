#include <iostream>
#include <cmath>
using namespace std;

int *arrCreation(int length)
{
    int *arr = new int[length];
    for (int i = 0; i < length; i++)
    {
        arr[i] = i + 1;
    }
    return arr;
}

void display(int arr[], int length)
{
    for (int i = 0; i < length; i++)
    {
        cout << arr[i] << " ";
    }
}

int nBinarySearch(int low, int high, int key, int arr[])
{
    while (low <= high)
    {
        int mid = floor((low + high) / 2);
        if (key == arr[mid])
        {
            return mid;
        }
        else if (key < arr[mid])
        {
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return -1;
}

int main()
{
    int length = 8;
    int *arr = arrCreation(length);
    cout << nBinarySearch(1, length, 4, arr) << endl;
    display(arr, length);
    return 0;
}