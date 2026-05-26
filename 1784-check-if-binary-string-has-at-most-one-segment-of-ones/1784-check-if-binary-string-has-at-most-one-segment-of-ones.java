class Solution {

    public boolean checkOnesSegment(String s) {

        // if "01" exists,
        // then another segment of 1s starts later
        return !s.contains("01");
    }
}