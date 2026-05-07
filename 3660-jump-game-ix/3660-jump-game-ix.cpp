#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<int> maxValue(vector<int>& nums) {
        int n = nums.size();
        if (n == 0) return {};

        // st will store the indices of the "rightmost" elements of our current components
        vector<int> st;
        // componentMax[i] stores the maximum value reachable for the component ending at i
        vector<int> componentMax(n);

        for (int i = 0; i < n; i++) {
            int curMax = nums[i];
            
            /* 
               If the current value nums[i] is smaller than the maximum of the 
               previous component, they are connected. 
               Why? Because a forward jump is possible from the max element 
               (or whatever element reached that max) to this smaller nums[i].
            */
            while (!st.empty() && nums[i] < componentMax[st.back()]) {
                curMax = max(curMax, componentMax[st.back()]);
                st.pop_back();
            }
            
            st.push_back(i);
            componentMax[i] = curMax;
        }

        vector<int> ans(n);
        int current_st_idx = 0;
        
        // Map every index back to the maximum of the component it belongs to
        // Elements between st[k-1] and st[k] belong to the component ending at st[k]
        for (int i = 0; i < n; i++) {
            if (i > st[current_st_idx]) {
                current_st_idx++;
            }
            ans[i] = componentMax[st[current_st_idx]];
        }

        return ans;
    }
};