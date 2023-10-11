#include <iostream>
using namespace std;

void insert(int ele, int &length, int arr[])
{
    int i = length - 1;
    while (arr[i] > ele)
    {
        arr[i + 1] = arr[i];
        i--;
    }
    arr[i + 1] = ele;
    length++;
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
    int length = 8;
    int *arr = new int[length]{4, 8, 13, 16, 20, 25, 28, 33};
    // insert(18, length, arr);
    // length++;
    // display(arr, length);
    // insert(11, length, arr);
    // insert(34, length, arr);
    insert(1, length, arr);
    display(arr, length);
    return 0;
}

// USING VECTORS
// #include <iostream>
// #include <vector>
// using namespace std;

// void insert(vector<int> &vec, int newEle)
// {
//     int i = vec.size() - 1;

//     while (vec[i] > newEle)
//     {
//         cout << vec[i] << endl;
//         vec[i + 1] = vec[i];
//         i--;
//     }
//     vec[i + 1] = newEle;
// }

// void display(vector<int> &vec)
// {
//     for (int i = 0; i < vec.size(); i++)
//     {
//         cout << vec[i] << " ";
//     }
// }

// int main()
// {
//     vector<int> vect{4, 8, 13, 16, 20, 25, 28, 33};
//     insert(vect, 18);
//     display(vect);
//     cout << endl;
//     insert(vect, 11);
//     display(vect);
//     return 0;
// }