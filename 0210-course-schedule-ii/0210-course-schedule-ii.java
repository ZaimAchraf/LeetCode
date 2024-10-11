class Solution {

    int[] result ;
    boolean[] exist ;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        result = new int[numCourses];
        exist = new boolean[numCourses];

        if (rec(0, numCourses, prerequisites)) {
            return result;
        }

        return new int[0];
    }

    private boolean rec(int index, int numCourses, int[][] prerequisites ) {
        
        boolean valid = true;

        if (index == numCourses) {
            return true;
        }

        for (int i = 0; i < numCourses; i++) {

            valid = true;

            // System.out.println("index : " + i + " " + exist[i]);

            if (exist[i])
                continue;

            for (int[] pair : prerequisites){
                // System.out.println("pair[0] : " + pair[0] );
                // System.out.println("pair[1] : " + pair[1] );
                if (pair[0] == i && !exist[pair[1]]){
                    valid = false;
                    break;
                }
                    
            }

            // System.out.println("valid : " + valid);

            if (valid) {
                exist[i] = true;
                result[index] = i;
                return rec(index + 1, numCourses, prerequisites);
            }
        }

        return false;
    }
}