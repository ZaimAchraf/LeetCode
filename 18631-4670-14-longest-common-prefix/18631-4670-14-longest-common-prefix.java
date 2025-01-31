class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        
        String prefix = strs[0]; // Start with the first string as the prefix
        
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) { // Check if prefix is at the start
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        
        return prefix;
    }
}

// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         int resultSize = strs[0].length();

//         for (int i = 1; i < strs.length; i++) {
//             if (resultSize == 0) return "";

//             while (strs[i].length() < resultSize){
//                 resultSize--;
//             }

//             for (int j = resultSize - 1; j >= 0; j--) {
//                 if (strs[i].charAt(j) != strs[0].charAt(j)) {
//                     resultSize = j;
//                 }
//             }
//         }

//         return strs[0].substring(0, resultSize);

//     }
// }