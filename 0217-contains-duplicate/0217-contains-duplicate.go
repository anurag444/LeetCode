func containsDuplicate(nums []int) bool {
    mapD := make(map[int]bool) // map to track duplicate numbers

    for _, num := range nums {
        if _, exists := mapD[num]; exists{
            return true;
        } else {
            mapD[num] = true;
        }
    }


    return false;
}