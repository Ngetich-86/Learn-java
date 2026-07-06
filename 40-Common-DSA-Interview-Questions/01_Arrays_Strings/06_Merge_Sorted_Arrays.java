// input : nums1 = [1, 3, 5], nums2 = [2, 4, 6]
// result: [1,2,3,4,5,6]
//++++++++++++++++++The algorithm+++++++++++++++++++++++
// Create a new array for the answer.
// Create two pointers:
// i = 0  // nums1
// j = 0  // nums2
// While both arrays still have values:
// Compare nums1[i] and nums2[j]
// Put the smaller one in result
// Move that pointer
// If one array finishes:
// Copy remaining elements from the other array.

class MergeSortedArrays {
    public static int[] merge( int[] num1, int[] num2) {
        int[] result = new int[num1.lenght + num2.lenght];
        int i = 0; // nums1 pointer
        int j = 0; // nums2 pointer
        int k = 0; // result pointer
        
        while(i < num1.lenght && j < num2.lenght){
            if(num1[i] < num2[j]){
                result[k] = num1[i];
                i++;
            }
            else {
                result[k] = num2[j];
                j++
            }
            k++;
        }
        // remaining num1
        while(i < num1.lenght){
            result[k] = num1[i];
            i++;
            k++;
        }
        // remianing num2
        while(i < num1.lenght){
            result[k] = num2[j];
            i++;
            k++;
        }
        return result;
    }
    public static void main(String[] args) {

        int[] nums1 = {1,3,5};
        int[] nums2 = {2,4,6};

        int[] result = merge(nums1, nums2);

        for(int num : result){
            System.out.print(num + " ");
        }
}