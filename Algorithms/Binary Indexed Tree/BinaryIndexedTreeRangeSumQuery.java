class BIT {
    int[] tree;
    int[] nums;
    int n;
    BIT (int[] nums) {
        n = nums.length + 1;
        this.nums = nums;
        tree = new int[n];
        for (int i = 0; i < n - 1; i++) {
            updateTree(i + 1, nums[i]);
        }
    }
    void update(int node, int val) {
        updateTree(node + 1, val - nums[node]);
        nums[node] = val;
    }
    int query(int x, int y) {
        return query(y + 1) - query(x);
    }
    int query(int node) {
        if (node == 0) return 0;
        return tree[node] + query(getParent(node));
    }
    void updateTree(int node, int val) {
        if (node >= n) return;
        tree[node] += val;
        updateTree(getNext(node), val);
    }
    int getParent(int x) {
        return x - (x & -x);
    }
    int getNext(int x) {
       return x + (x & -x);
    }
}
class BinaryIndexedTreeRangeSumQuery {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        BIT bit = new BIT(nums);
        System.out.println(bit.query(3, 4));
        bit.update(4, 10);
        System.out.println(bit.query(0, 4));
    }
}
