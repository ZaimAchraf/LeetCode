class RandomizedSet {

    private Map<Integer, Integer> valIndexes;
    private List<Integer> vals;
    private Random random;


    public RandomizedSet() {
        valIndexes = new HashMap<Integer, Integer>();
        vals = new ArrayList<Integer>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (!valIndexes.containsKey(val)){ 
            vals.add(val);
            valIndexes.put(val, vals.size() - 1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (valIndexes.containsKey(val)) { 
            Integer index = valIndexes.get(val);
            Integer lastVal = vals.get(vals.size() - 1);

            // Swap the value to remove with the last value
            vals.set(index, lastVal);

            // Update the map for the last value
            valIndexes.put(lastVal, index);

            // Remove the last element and update the map
            vals.remove(vals.size() - 1);
            valIndexes.remove(val);

            return true;
        }
        return false;
    }

    
    public int getRandom() {
        // System.out.println(vals.get(0));
        Integer index = random.nextInt(vals.size());
        return vals.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */