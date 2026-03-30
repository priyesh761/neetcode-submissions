class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for(int i=0;i<n;i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b)-> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        int i=cars.length-1, count=0;
        while(i>=0) {
            int j=i;
            while(i>=0 && compTimeReq(target, cars[j], cars[i])) i--;
            count++;
        }
        return count;
    }

    private boolean compTimeReq(int target, int[] p1, int[] p2) {
        return (target - p1[0]) * p2[1] >= (target - p2[0]) * p1[1];
    }
}
