class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] triplet = new int[3];
        Arrays.fill(triplet, Integer.MIN_VALUE);
        for(int[] trp: triplets) {
            if(trp[0]<=target[0]&&trp[1]<=target[1]&&trp[2]<=target[2]) {
                triplet[0] = Math.max(trp[0], triplet[0]);
                triplet[1] = Math.max(trp[1], triplet[1]);
                triplet[2] = Math.max(trp[2], triplet[2]);
            }
        }
        return triplet[0]==target[0]
            && triplet[1]==target[1]
            && triplet[2]==target[2];
    }
}
