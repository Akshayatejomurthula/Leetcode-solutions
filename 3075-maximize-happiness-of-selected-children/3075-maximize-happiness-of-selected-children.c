#include <stdio.h>
#include <stdlib.h>

// Comparator for descending order
int compare(const void *a, const void *b) {
    return (*(int *)b - *(int *)a);
}

long long maximumHappinessSum(int* happiness, int n, int k) {
    // Sort happiness in descending order
    qsort(happiness, n, sizeof(int), compare);

    long long sum = 0;

    for (int i = 0; i < k; i++) {
        int value = happiness[i] - i;
        if (value > 0)
            sum += value;
        else
            break;  // further values will be <= 0
    }

    return sum;
}
