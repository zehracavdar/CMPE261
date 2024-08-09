#include <iostream>
#include <algorithm>

void reverseArray(int arr[], int size) {
    int start = 0;
    int end = size - 1;

    while (start < end) {
        
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        start++;
        end--;
    }
}

bool areConsecutive(int arr[], int size) {
    std::sort(arr, arr + size);

    // checking if the difference between consecutive elements is 1
    for (int i = 0; i < size - 1; i++) {
        if (arr[i + 1] - arr[i] != 1) {
            return false;
        }
    }

    return true;
}

void findIntersection(int arr1[], int size1, int arr2[], int size2) {
    std::sort(arr1, arr1 + size1);
    std::sort(arr2, arr2 + size2);

    int i = 0, j = 0;

    std::cout << "Intersection: ";
    while (i < size1 && j < size2) {
        if (arr1[i] == arr2[j]) {
            std::cout << arr1[i] << " ";
            i++;
            j++;
        } else if (arr1[i] < arr2[j]) {
            i++;
        } else {
            j++;
        }
    }
    std::cout << std::endl;
}

void findUnion(int arr1[], int size1, int arr2[], int size2) {
    std::sort(arr1, arr1 + size1);
    std::sort(arr2, arr2 + size2);

    int i = 0, j = 0;

    std::cout << "Union: ";
    while (i < size1 && j < size2) {
        if (arr1[i] < arr2[j]) {
            std::cout << arr1[i] << " ";
            i++;
        } else if (arr1[i] > arr2[j]) {
            std::cout << arr2[j] << " ";
            j++;
        } else {
            std::cout << arr1[i] << " ";
            i++;
            j++;
        }
    }

    while (i < size1) {
        std::cout << arr1[i] << " ";
        i++;
    }

    while (j < size2) {
        std::cout << arr2[j] << " ";
        j++;
    }

    std::cout << std::endl;
}


//------------MAIN


int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int size = sizeof(arr) / sizeof(arr[0]);

    // Function to reverse the array
    reverseArray(arr, size);

    // Print the reversed array
    std::cout << "Reversed Array: ";
    for (int i = 0; i < size; i++) {
        std::cout << arr[i] << " ";
    }



int arr1[] = {4, 2, 1, 3, 5};
    int size1 = sizeof(arr1) / sizeof(arr1[0]);

    if (areConsecutive(arr1, size1)) {
        std::cout << "\nThe array does notconsists of consecutive numbers." << std::endl;
    } else {
        std::cout << "\nThe array consist of consecutive numbers." << std::endl;
    }


 int arr2[] = {1, 3, 5, 6, 2,  11};
    int size2 = sizeof(arr2) / sizeof(arr2[0]);

    int arr3[] = {2, 4, 5, 6, 8, 10};
    int size3 = sizeof(arr) / sizeof(arr3[0]);

    findIntersection(arr2, size2, arr3, size3);

    findUnion(arr2, size2, arr3, size3);

    return 0;
}