import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;
import org.junit.Test;

public class Test201909 {

    /**
     * 二分查找
     */
    @Test
    public void test() {

    }

    /**
     * 二分查找算法
     *
     * 时间复杂度 log(N)
     * @param data
     * @param x
     * @return
     */
    private int binarySearch(int data[], int x) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (x == data[mid]) {
                return mid;
            } else if (x < data[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 递归实现二分法查找、
     *
     * 时间复杂度 log(N)
     * @param data
     * @param x
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int data[], int x, int low, int high) {
        if (x < data[low] || x > data[high] || low > high) return -1;
        int mid = (low + high) / 2;
        if(x < data[mid]){
            return binarySearch(data, x, low, mid-1);
        }else if( x > data[mid]){
            return binarySearch(data, x, mid+1, high);
        }else return mid;
    }

}
