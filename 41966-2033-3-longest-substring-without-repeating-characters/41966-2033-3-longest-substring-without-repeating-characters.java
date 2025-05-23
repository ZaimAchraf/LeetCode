// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int size = 0, maxSize = 0, left = 0, right = 0;
//         Map<Character, Integer> map = new HashMap<>();

//         while (right != s.length()) {
//             map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
//             size++;

//             while (map.get(s.charAt(right)) > 1) {
//                 map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
//                 left++;
//                 size--;
//             }

//             maxSize = size > maxSize ? size : maxSize;

//             right++;
//         }

//         return maxSize;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0, left = 0, right = 0;

        while (right < s.length()) {
            char current = s.charAt(right);
            if (!set.contains(current)) {
                set.add(current);
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
}
