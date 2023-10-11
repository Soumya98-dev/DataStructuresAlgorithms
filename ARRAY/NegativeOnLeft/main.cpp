#include <iostream>
using namespace std;

void swap(int val1, int val2)
{
    int temp = val1;
    val1 = val2;
    val2 = temp;
}

void negativeonLeft(int arr[], int length)
{
    int i = 0;
    int j = length - 1;

    while (i < j)
    {
        while (arr[i] < 0)
        {
            i++;
        }
        while (arr[j] >= 0)
        {
            j--;
        }
        if (i < j)
        {
            swap(arr[i], arr[j]);
        }
    }
}

void display(int arr[], int length)
{
    for (int i = 0; i < length; i++)
    {
        cout << arr[i] << " ";
    }
}

int main()
{
    int length = 7;
    int *arr = new int[length]{-5, 2, -1, 3, -6, 4, 5};
    display(arr, length);
    negativeonLeft(arr, length);
    display(arr, length);
    return 0;
}