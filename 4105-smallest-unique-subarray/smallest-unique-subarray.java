import java.util.*;

class Solution {

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int[] sa = buildSuffixArray(nums);
        int[] lcp = buildLCP(nums, sa);
        int ans = n;
        for (int rank = 0; rank < n; rank++) {
            int maxLcp = 0;
            if (rank > 0) {
                maxLcp = Math.max(maxLcp, lcp[rank - 1]);
            }
            if (rank < n - 1) {
                maxLcp = Math.max(maxLcp, lcp[rank]);
            }
            int start = sa[rank];
            int suffixLength = n - start;
            int uniqueLength = maxLcp + 1;
            if (uniqueLength <= suffixLength) {
                ans = Math.min(ans, uniqueLength);
            }
        }
        return ans;
    }

    private int[] buildSuffixArray(int[] nums) {
        int n = nums.length;
        int m = n + 1;
        int[] a = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
        }
        a[n] = 0;
        int[] sa = new int[m];
        int[] rank = new int[m];
        int[] tmpRank = new int[m];
        int[] tmpSa = new int[m];
        int maxValue = Math.max(100000, m) + 1;
        int[] count = new int[maxValue];
        for (int x : a) {
            count[x]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = m - 1; i >= 0; i--) {
            sa[--count[a[i]]] = i;
        }
        int classes = 1;
        rank[sa[0]] = 0;
        for (int i = 1; i < m; i++) {
            if (a[sa[i]] != a[sa[i - 1]]) {
                classes++;
            }
            rank[sa[i]] = classes - 1;
        }
        for (int len = 1; len < m; len *= 2) {
            for (int i = 0; i < m; i++) {
                tmpSa[i] = sa[i] - len;

                if (tmpSa[i] < 0) {
                    tmpSa[i] += m;
                }
            }
            Arrays.fill(count, 0, classes, 0);
            for (int i = 0; i < m; i++) {
                count[rank[tmpSa[i]]]++;
            }
            for (int i = 1; i < classes; i++) {
                count[i] += count[i - 1];
            }
            for (int i = m - 1; i >= 0; i--) {
                int x = tmpSa[i];
                sa[--count[rank[x]]] = x;
            }
            tmpRank[sa[0]] = 0;
            int newClasses = 1;
            for (int i = 1; i < m; i++) {
                int cur = sa[i];
                int prev = sa[i - 1];
                int curSecond = (cur + len) % m;
                int prevSecond = (prev + len) % m;
                if (rank[cur] != rank[prev] ||
                        rank[curSecond] != rank[prevSecond]) {

                    newClasses++;
                }
                tmpRank[cur] = newClasses - 1;
            }
            int[] swap = rank;
            rank = tmpRank;
            tmpRank = swap;
            classes = newClasses;
            if (classes == m) {
                break;
            }
            if (len > m / 2) {
                break;
            }
        }
        int[] result = new int[n];
        int idx = 0;
        for (int x : sa) {
            if (x != n) {
                result[idx++] = x;
            }
        }
        return result;
    }

    private int[] buildLCP(int[] nums, int[] sa) {
        int n = nums.length;
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }
        int[] lcp = new int[n - 1];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int r = rank[i];
            if (r == n - 1) {
                k = 0;
                continue;
            }
            int j = sa[r + 1];
            while (i + k < n &&
                    j + k < n &&
                    nums[i + k] == nums[j + k]) {
                k++;
            }
            lcp[r] = k;
            if (k > 0) {
                k--;
            }
        }
        return lcp;
    }
}