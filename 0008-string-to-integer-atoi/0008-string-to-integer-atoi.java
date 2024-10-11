class Solution {
    public int myAtoi(String s) {
        
        int max = (int) Math.pow(2, 31);
        int sign = 1;

        StringBuilder sb = new StringBuilder();

        int index = 1;
        int result = 0;

        // System.out.println( max);
        s = s.trim();
        // System.out.println((int) '9');

        for (int i = 0; i < s.length(); i++) {

            if (i == 0 && s.charAt(i) == '-') {
                sign = -1;
                continue;
            }

            if (i == 0 && s.charAt(i) == '+') {
                continue;
            }

            // if (s.charAt(i) == '0')
            //     continue;
            
            if (!((int) s.charAt(i) >= 48 &&  (int) s.charAt(i) <= 57)) {
                break;
            }else {
                sb.append(s.charAt(i));
            }
        }

        if (sb.toString().isEmpty())
            return 0;

        Double res = Double.parseDouble(sb.toString());

        res *= sign;

        if (res > max ) {
            return max;
        }

        if (res < (-1 * max - 1)) {
            // System.out.println( -1 * max - 1);
            return (-1 * max - 1);
        }


        return (int) (1 * res);
    }

}