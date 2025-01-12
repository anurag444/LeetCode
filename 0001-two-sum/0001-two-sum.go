func twoSum(nums []int, target int) []int {
    var m map[int]int

    // create a slice of array with 2 elements
    res := make([]int, 2)

    m = make(map[int]int)

    for i, num := range nums {
        x, ok := m[target - num];

        if ok {
            res[0] = i;
            res[1] = x;

            break;
        }

        m[num] = i;


    }

    return res;
    
}