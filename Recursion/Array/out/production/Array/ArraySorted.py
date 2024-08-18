def ifArraySortedIterative(list):
    if len(list) <= 1:
        return True;

    checker = list[0]

    for i in range(1,len(list)):
        if checker < list[i]:
            checker = checker + 1
        else:
            return False
    return True

def isArraySortedRecursion(list,index):
    if index == len(list) - 1:
        return True;

    return list[index] < list[index+1] and isArraySortedRecursion(list, index = index + 1)

nums = [1,2,4,8,9,12]
print(ifArraySortedIterative(nums))
print(isArraySortedRecursion(nums, 0))
