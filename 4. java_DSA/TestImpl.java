// merge in assending order
// input :  arr1: -1,1,3,5,7,9
//          arr2: -2,2,3,5,6
// output: 


public class TestImpl implements TestIfc {
    public int[] mergeArrays(int[] arr1, int[arr2]){
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[arr1.length + arr2.length];
        while(i < arr1.length && j <arr2.lenght){
            if(arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            }
            else{
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }
        while(j < arr2.length) {
            result[k] = arr1[j];
            j++;
            k++;
        }
        return results;
    }
    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {};
        int[] merged = mergeArrays(arr1, arr2);
        for(int num: merged) {
            System.out.println(num + "");
        }
    }
}