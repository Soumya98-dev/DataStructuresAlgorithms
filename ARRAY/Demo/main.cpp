#include <iostream>
using namespace std;

// CREATING AN NEW ARRAY & RETURNING IT
int *arr(int size)
{
    int *A;
    A = new int[size];
    for (int i = 0; i < size; i++)
    {
        A[i] = i + 1;
    }
    return A;
}

// DISPLAYING THE ARRAY
void display(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
}

// INSERTING AT THE END
void add(int x, int size, int arr[])
{
    arr[size] = x;
    size++;
}

// INSERTING AT A SPECIFIC LOCATION
void insert(int index, int x, int size, int A[])
{
    if (index <= size && index != -1)
    {
        for (int i = size; i > index; i--)
        {
            A[i] = A[i - 1];
        }
    }
    A[index] = x;
    size++;
}

// DELETION
void del(int A[], int ele, int size)
{
    int elementToBeDeleted = A[ele];
    for (int i = ele; i < size - 1; i++)
    {
        A[i] = A[i + 1];
    }
    size--;
}

int main()
{
    int size = 5;
    int *A = arr(size);

    add(6, size, A);
    size++;
    insert(4, 10, size, A);
    size++;

    del(A, 4, size);
    size--;
    display(A, size);
    return 0;
}
