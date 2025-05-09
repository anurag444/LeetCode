class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        double[][] pair = new double[n][2];

        for(int i = 0; i < n; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Double.compare(a[0], b[0]));

        double time = 0;
        int fleet = 0;

        for (int i = n - 1; i >= 0; i--) {
            double currTime = (target - pair[i][0]) /pair[i][1];

            if(time < currTime){
                fleet++;
                time = currTime;
            }
        }

        return fleet;
    }
}