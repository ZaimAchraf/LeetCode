class Solution {

    int[] result;
    boolean[] exist;
    int maxSize;
    int originalNumber;

    public int[] constructDistancedSequence(int n) {

        this.maxSize = 1 + (n - 2 + 1)*2;
        this.result = new int[maxSize];
        this.exist = new boolean[n + 1];
        this.exist[0] = true;
        originalNumber = n;
        
        rec(0);
        
        return result;
    }

    private boolean rec(int index) 
    {
        if (index == maxSize)
            return true;

        if (this.result[index] != 0) {
            return rec(index + 1);
        }
            

        for (int i = 0; i < originalNumber; i++) 
        {
            if (this.exist[originalNumber - i]) {
                continue;
            }

            if ((originalNumber - i) != 1 && (((index + originalNumber - i) > maxSize - 1) || (this.result[index + originalNumber - i] != 0)))
                continue;

            this.result[index] = originalNumber - i;

            if ((originalNumber - i) != 1)
                this.result[index + originalNumber - i] = originalNumber - i;

            this.exist[originalNumber - i] = true;

            if (rec(index + 1)) {
                return true;
            }
            
            this.result[index] = 0;
            this.exist[originalNumber - i] = false;
            if ((originalNumber - i) != 1) this.result[index + originalNumber - i] = 0;

        }

        return false;
        
    }
}