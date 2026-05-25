#include <stdlib.h>
#include <stdbool.h>

int parent[100005];

int find(int x) {
    if (parent[x] != x)
        parent[x] = find(parent[x]);
    return parent[x];
}

void unite(int x, int y) {
    int px = find(x);
    int py = find(y);
    if (px != py)
        parent[py] = px;
}

int cmp(const void* a, const void* b) {
    int* m1 = *(int**)a;
    int* m2 = *(int**)b;
    return m1[2] - m2[2];
}

int* findAllPeople(int n, int** meetings, int meetingsSize,
                   int* meetingsColSize, int firstPerson,
                   int* returnSize) {

    for (int i = 0; i < n; i++)
        parent[i] = i;

    unite(0, firstPerson);

    qsort(meetings, meetingsSize, sizeof(int*), cmp);

    bool used[100005] = {false};
    int people[100005];

    int i = 0;
    while (i < meetingsSize) {
        int time = meetings[i][2];
        int cnt = 0;

        // Union meetings at same time
        while (i < meetingsSize && meetings[i][2] == time) {
            int x = meetings[i][0];
            int y = meetings[i][1];

            unite(x, y);

            if (!used[x]) {
                used[x] = true;
                people[cnt++] = x;
            }
            if (!used[y]) {
                used[y] = true;
                people[cnt++] = y;
            }
            i++;
        }

        // Reset people not connected to 0
        for (int j = 0; j < cnt; j++) {
            int p = people[j];
            if (find(p) != find(0))
                parent[p] = p;
            used[p] = false;   // reset for next time
        }
    }

    int* ans = (int*)malloc(n * sizeof(int));
    int idx = 0;

    for (int i = 0; i < n; i++) {
        if (find(i) == find(0))
            ans[idx++] = i;
    }

    *returnSize = idx;
    return ans;
}