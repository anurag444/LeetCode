func twoSum(nums []int, target int) []int {
    numMap := make(map[int]int) // Step 1: Create a map to store numbers and their indices.
    for i, num := range nums {
        // Step 2: Calculate the complement for each number during iteration.
        if j, ok := numMap[target-num]; ok {
            return []int{j, i} // Step 3: If the complement exists, return the indices.
        }
        numMap[num] = i // Step 4: Add the current number and its index to the map.
    }
    // Step 5: If no pair sums up to the target, return nil.
    return nil
}