#include <stdio.h>

#define MOD 1000000007

int numOfWays(int n) {
    long long same = 6;  // patterns like RGR
    long long diff = 6;  // patterns like RGB

    for (int i = 2; i <= n; i++) {
        long long new_same = (same * 3 + diff * 2) % MOD;
        long long new_diff = (same * 2 + diff * 2) % MOD;

        same = new_same;
        diff = new_diff;
    }

    return (same + diff) % MOD;
}
