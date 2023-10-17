/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = mountainArr.length();
        int l = 0;
        int r = len-1;
        int mid = l + (r-l)/2;;
        
        int targetIndex = Integer.MAX_VALUE;
        // find top:
        while (l <= r) {
            mid = l + (r-l)/2;
            int curr, prev;
            if (map.containsKey(mid)) {
                curr = map.get(mid);
            } else {
                curr = mountainArr.get(mid);
                map.put(mid, curr);
            }
            if (mid > 0) {
                if (map.containsKey(mid-1)) {
                    prev = map.get(mid-1);
                } else {
                    prev = mountainArr.get(mid-1);
                    map.put(mid-1, prev);
                }
            } else {
                prev = -1;
            }


            if (curr < prev) {
                // we are in the right side of the mountain
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        int topPoint = mid;

        // search in left side:
        l = 0;
        r = topPoint;
        while (l <= r) {
            mid = l + (r-l)/2;
            int curr, prev;

            if (map.containsKey(mid)) {
                curr = map.get(mid);
            } else {
                curr = mountainArr.get(mid);
                map.put(mid, curr);
            }

            if (curr == target) {
                targetIndex = Math.min(targetIndex, mid);
                break;
            } else if (curr < target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        if (targetIndex != Integer.MAX_VALUE) {
            return targetIndex;
        }

        // search in right side:
        l = topPoint;
        r = len-1;
        while (l <= r) {
            mid = l + (r-l)/2;
            int curr, prev;

            if (map.containsKey(mid)) {
                curr = map.get(mid);
            } else {
                curr = mountainArr.get(mid);
                map.put(mid, curr);
            }

            if (curr == target) {
                targetIndex = Math.min(targetIndex, mid);
                break;
            } else if (curr > target) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        if (targetIndex == Integer.MAX_VALUE) {
            targetIndex = -1;
        }
        return targetIndex;
    }
}