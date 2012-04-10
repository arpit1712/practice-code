public class Arrays
{
    public static int rotatedBinSearch(int[] arr, int key)
    {
        //assuming arr is sorted and rotated
        
        //first find the pivot, then search in both the arrays
        int pivot = findPivot(arr, 0, arr.length - 1);

        if(key < arr[pivot]) return -1;

        if(key >= arr[0])
        {
            return binarySearch(arr, 0, pivot -1, key);
        }
        else
        {
            return binarySearch(arr, pivot, arr.length - 1, key);
        }
    }

    private static int findPivot(int[] arr, int start, int end)
    {
        int mid = (end + start)/2;

        if(arr[mid-1] > arr[mid])
        {
            return mid;
        }
        else if(arr[mid] > arr[end])
        {
            return findPivot(arr, mid + 1, end);
        }
        else
        {
            return findPivot(arr, 0, mid - 1);
        }
    }

    public static int binarySearch(int[] arr, int start, int end, int key)
    {
        if(arr[start] > arr[end])
        {
            return -2;  //array not sorted
        }

        if(start > end)
        {
            return -1;  //not found
        }

        int mid = (end + start)/2;
        
        if(arr[mid] == key)
        {
            return mid;
        }
        else if(key < arr[mid])
        {
            return binarySearch(arr, start, mid -1, key);
        }
        return binarySearch(arr, mid + 1, end, key);
    }

    public static void main(String[] args)
    {
        if(args.length < 1) return;
        int[] arr = {1,2,3,4,5};
        System.out.println("arr={1,2,3,4,5}:: binSearch = " + Arrays.binarySearch(arr, 0, arr.length - 1, Integer.parseInt(args[0])));
        int[] arr2 = {3,4,5,1,2};
        System.out.println("arr={3,4,5,1,2}:: rotatedBinSearch = " + Arrays.rotatedBinSearch(arr2, Integer.parseInt(args[0])));
    }

}
