from typing import List

def countSort(arr) -> List[int]:
    res = [0] * len(arr)
    max = 0

    for i in arr:
        if i > max:
            max = i

    count = [0] * (max + 1)

    for i in arr:
        count[i] = count[i] + 1

    i = 0
    j = 0

    while i < max + 1:
        if count[i] > 0:
            res[j] = i
            j = j + 1
            count[i] = count[i] - 1
        else:
            i = i + 1

    return res

arr = [2,5,3,0,2,3,0,3]
print(countSort(arr))
