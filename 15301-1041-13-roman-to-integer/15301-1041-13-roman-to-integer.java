class Solution {
    public int romanToInt(String s) {
        int number = 0, i;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (i = 0; i < s.length() - 1; i++) {
            
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                number += map.get(s.charAt(i));
            }else {
                number += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i++;
            }
        }

        if (i == s.length() - 1)
            number += map.get(s.charAt(s.length() - 1));

        return number;
    }
}