// GET, SET, MAX, MIN, ADD, AVG

#include <iostream>
using namespace std;

int *arrCreate(int length)
{
    int *A = new int[length];
    for (int i = 0; i < length; i++)
    {
        // cin >> A[i];
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

int get(int index, int arr[], int length)
{
    if (index >= 0 && index < length)
    {
        return arr[index];
    }
}

void set(int index, int val, int arr[], int length)
{
    if (index >= 0 && index < length)
    {
        arr[index] = val;
    }
}

int maximum(int *arr, int length)
{
    int maxVal = arr[0];
    for (int i = 0; i < length; i++)
    {
        if (arr[i] > maxVal)
        {
            maxVal = arr[i];
        }
    }
    return maxVal;
}

int minimum(int *arr, int length)
{
    int minVal = arr[0];
    for (int i = 0; i < length; i++)
    {
        if (arr[i] < minVal)
        {
            minVal = arr[i];
        }
    }
    return minVal;
}

int sum(int arr[], int length)
{
    int sum = 0;
    for (int i = 0; i < length; i++)
    {
        sum = sum + arr[i];
    }
    return sum;
}

int average(int arr[], int length)
{
    return sum(arr, length) / length;
}

int main()
{
    int length = 10;
    int *arr = arrCreate(length);
    display(arr, length);
    cout << endl;
    cout << get(4, arr, length);
    cout << endl;
    set(4, 15, arr, length);
    display(arr, length);
    cout << endl;
    cout << "Maximum: " << maximum(arr, length);
    cout << endl;
    cout << "Minimum: " << minimum(arr, length);
    cout << endl;
    int sumRes = sum(arr, length);
    cout << sumRes << endl;
    cout << average(arr, length);
    return 0;
}
