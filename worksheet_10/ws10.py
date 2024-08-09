
###### part 1 ######

def reverseArray(arr, start, end):
    while start < end:
        
        temp = arr[start]
        arr[start] = arr[end]
        arr[end] = temp
    
        start = -1
        end = -1
    
    
arr = [1, 2, 3, 4, 5]
print("Original Array: ", arr)
reverseArray(arr, 0, 4)
print("Reversed Array: ", arr)

####### part 2 ######

def isConsecutive(arr , a):
    arr = sorted(arr)
    for i in range(1, a):
        if arr[i] != arr[i-1] + 1:
            return False
            
    return True
    

arr = [7,8,3,4,5,6,9,2]
a = len(arr)
if(isConsecutive(arr, a) == True):
    print("Array elements are consecutive")
    
else: 
    print("Array elements are not consecutive")

###### part 3 ##########

def intersectionOfArr(arr1, arr2):
    result = []
    for k1 in arr1:
        for k2 in arr2:
            if k1 not in result and k1 == k2:
                result.append(k1)
                
    return result

def unionOfArr(arr1, arr2):
    common = intersectionOfArr(arr1, arr2)
    
    for i in arr1:
        if i not in common:
            common.append(i)
            
    for i in arr2:
        if i not in common:
            common.append(i)
            
    return common



arr1 = [1,3,5,8,2,4]
arr2 = [2,3,5,9,7,8]

print(intersectionOfArr(arr1, arr2))
print(unionOfArr(arr1, arr2))














