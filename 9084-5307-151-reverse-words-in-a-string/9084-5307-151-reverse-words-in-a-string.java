class Solution {
    public String reverseWords(String s) {
        int i, j = -1;
        StringBuilder result = new StringBuilder();

        for (i = s.length() -1; i >= 0; i--) {
            if (j == -1 && s.charAt(i) != ' '){
                j = i;
            }

            if (s.charAt(i) == ' ' && j != -1) {
                result.append(s.substring(i + 1, j + 1));
                result.append(" ");
                j = -1;
            }
        }

        if (j != -1) {
            result.append(s.substring(0, j + 1));
            return result.toString();
        }else {
            return result.toString().trim();
        }
    }
}

// class Solution {
//     public String reverseWords(String s) {
//         String[] words = s.trim().split("\\s+");
//         StringBuilder result = new StringBuilder();

//         for (int i = words.length - 1; i >= 0; i--) {
//             result.append(words[i]).append(" ");
//         }

//         return result.toString().trim();
//     }
// }