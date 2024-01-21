class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;

        for(int i = 1; i <= n; i++){
            int num = i;

            if(num % 2 == 0){
                res[num] = res[num/2];
            }else{
                res[num] = res[num/2] + 1;
            }
        }

        return res;
    }

    // O(n log(k)) solution 

    // public int[] countBits(int n) {
    //     int[] res = new int[n+1];

    //     for(int i = 0; i <= n; i++){
    //         int num = i;
    //         int count = 0;
    //         while(num != 0){
    //             count++;
    //             num = num & (num - 1);
    //         }
    //         res[i] = count;
    //     }

    //     return res;
    // }

    
}