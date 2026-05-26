class Solution {

    private int count = 0;
    private String answer = "";

    public String getHappyString(int n, int k) {

        backtrack("", n, k);

        return answer;
    }

    private void backtrack(String current, int n, int k) {

        // already found answer
        if (!answer.equals("")) {
            return;
        }

        // completed happy string
        if (current.length() == n) {

            count++;

            if (count == k) {
                answer = current;
            }

            return;
        }

        char[] chars = {'a', 'b', 'c'};

        for (char ch : chars) {

            if (current.length() > 0 &&
                current.charAt(current.length() - 1) == ch) {
                continue;
            }

            backtrack(current + ch, n, k);
        }
    }
}