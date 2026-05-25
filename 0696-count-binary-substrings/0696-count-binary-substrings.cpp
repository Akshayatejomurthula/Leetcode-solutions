class Solution {
public:

    int countBinarySubstrings(string s) {

        vector<int> groups;

        int count = 1;

        // store lengths of consecutive groups
        for (int i = 1; i < s.size(); i++) {

            if (s[i] == s[i - 1]) {
                count++;
            } else {
                groups.push_back(count);
                count = 1;
            }
        }

        groups.push_back(count);

        int ans = 0;

        // valid substrings come from adjacent groups
        for (int i = 1; i < groups.size(); i++) {
            ans += min(groups[i - 1], groups[i]);
        }

        return ans;
    }
};