class Solution {
    public int hammingWeight(int n) {
        int counter = 0;
        String binary_n = Integer.toBinaryString(n);
        
        for (int i = 0; i < binary_n.length(); i++) {
            if (binary_n.charAt(i) == '1') {
                counter++;
            }
        }
        return counter;
    }
}