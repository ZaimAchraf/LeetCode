class Solution {

    public List<Integer> exist = new ArrayList<>();

    public List<Integer> numslist = new ArrayList<>();
    public List<Integer> subset = new ArrayList<>();
    public Integer count = 0;

    public int beautifulSubsets(int[] nums, int k) 
    {
        this.numslist = Arrays.stream(nums).boxed().collect(Collectors.toList());
        
        rec (0,  k);

        return this.count;

    }

    private void rec (Integer index, int k) {

        if (index == this.numslist.size()) {
            // System.out.println(this.subset.toString());
            if (this.subset.size() == 0) 
                return;
            this.count++;
            return;
        }


        if (subset.isEmpty() || (!this.subset.contains(this.numslist.get(index) + k) && !this.subset.contains(this.numslist.get(index) - k))) 
        {
            this.subset.add(this.numslist.get(index));
            rec (index + 1,  k);
            this.subset.remove(this.subset.size() - 1);
        }

        rec (index + 1,  k);
    }


}
