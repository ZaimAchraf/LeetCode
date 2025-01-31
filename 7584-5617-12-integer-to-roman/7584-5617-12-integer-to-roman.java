// class Solution {
//     public String intToRoman(int num) {
//         String[] Roman = {"I", "V", "X", "L", "C", "D", "M"};
//         int j = 0;
//         StringBuilder str = new StringBuilder();

//         for (int i = 6; i >= 0; i--) {
//             if (i % 2 == 0) 
//             {
//                 j =  num / (int) Math.pow(10, i/2);

//                 if(j == 0) continue;

//                 if (j == 4) {
//                     str.append(Roman[i]);
//                     str.append(Roman[i+1]);

//                 }else {
//                     str.append(Roman[i].repeat(j));
//                 }
//                 num -= j * Math.pow(10, i/2);
                
//             }else {
//                 j = num / ((int) Math.pow(10, (i+1)/2)/2);

//                 System.out.println((num / (int)(Math.pow(10, (i-1)/2))));

//                 if(j == 0) continue;

//                 if ((num / (int)(Math.pow(10, (i-1)/2))) == 9) {
//                     str.append(Roman[i-1]);
//                     str.append(Roman[i+1]);
//                     num -= (int) Math.pow(10, (i-1)/2)*9;
//                     i--;
//                     continue;
//                 }

//                 str.append(Roman[i]);
//                 num -= (int) Math.pow(10, (i+1)/2)/2;
//             }
            
//         }

//         return str.toString();
//     }
// }

class Solution {
    public String intToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                str.append(symbols[i]);
                num -= values[i];
            }
        }
        return str.toString();
    }
}
