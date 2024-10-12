class Solution {
    
    public List<Integer> findSubstring(String s, String[] words) {
        
        int word_len = words[0].length();
        int len = words.length * word_len;
        Map<String, Integer> s_map = new HashMap<>();
        Map<String, Integer> words_map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        String sub;
        String word;
        
        for (String w : words) {
            words_map.put(w, words_map.getOrDefault(w, 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - len;i++) {
            sub = s.substring(i, i + len);
            s_map.clear();
            
            for (int j = 0; j < len; j += word_len) {
                word = sub.substring(j, j + word_len);
                s_map.put(word, s_map.getOrDefault(word, 0) + 1);
            }
            
            if(s_map.equals(words_map)) {
                result.add(i);
            }
        }
        
        return result;
    }

}