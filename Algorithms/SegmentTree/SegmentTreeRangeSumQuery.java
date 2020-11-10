import java.util.*;
class SegmentTree {
    int[] values;
    int[] tree;
    int n;
    SegmentTree(int[] nums) {
        n = nums.length + 1;
        values = new int[n];
        for (int i = 0; i < n - 1; i++) {
            values[i + 1] = nums[i];
        }
        tree = new int[4 * n];
        build(1, 1, n - 1);
    }
    public void build(int node, int low, int high) {
        if (low > high) return;
        if (low == high) {
            tree[node] = values[low];
            return;
        }
        int p = low + (high - low) / 2;
        build(node * 2, low, p);
        build(node * 2 + 1, p + 1, high);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
    public void update(int index, int val) {
        int diff = val - values[index + 1];
        values[index + 1] += diff;
        updateTree(1, 1, n - 1, index + 1, diff);
    }
    public void updateTree(int node,int low, int high, int index, int diff) {
        if (index < low || index > high) return;
        tree[node] += diff;
        if (low != high) {
            int p = low + (high - low) / 2;
            updateTree(node * 2, low, p, index, diff);
            updateTree(node * 2 + 1, p + 1, high, index, diff);
        }
    }
    public int query(int qlow, int qhigh) {
        return queryTree(1, 1, n - 1, qlow + 1, qhigh + 1);
    }
    public int queryTree(int node, int low, int high, int qlow, int qhigh) {
        if (low > qhigh || high < qlow) return 0;
        if (low >= qlow && high <= qhigh) return tree[node];
        int p = low + (high - low ) / 2;
        return queryTree(node * 2, low, p, qlow, qhigh) + queryTree(node * 2 + 1, p + 1, high, qlow, qhigh);
   }
}
class SegmentTreeRangeSumQuery {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5};
		SegmentTree st = new SegmentTree(nums);
		System.out.println(st.query(2, 4));
		st.update(3, 7);
		System.out.println(st.query(2, 4));
	}
}