#2- sum
#nums = [2,7,11,15] target = 9 o/p: [0,1]

def twoSum(nums,target):
    #create an empty dictionary
    dict = {}
    output = []
    sum = 0

    for idx, val in enumerate(nums):
        dict[idx] = val

    if dict:
        for key, value in dict.items():
            if sum == target:



    return dict

print(twoSum([2,7,11,15], 9))
