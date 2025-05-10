class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int currentSize = -1, nbrWords = 0, spaces = 0, q , r, s = 0;
        List<String> result = new ArrayList<String>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i <= words.length; i++) {

            if (i == words.length || (currentSize + 1 + (s = words[i].length()) > maxWidth)) {

                spaces = maxWidth - currentSize + nbrWords - 1;

                if (nbrWords > 1) {
                    q = spaces/(nbrWords - 1);
                    r = spaces % (nbrWords - 1);
                }else {
                    q = spaces;
                    r = 0;
                }

                if (i == words.length) {
                    for (int j = (i - nbrWords); j < i - 1; j++) {
                        str.append(words[j]);
                        str.append(' ');
                        spaces--;
                    }
                    str.append(words[i - 1]);
                    if (spaces > 0) {
                        for (int k = 0; k < spaces; k++) {
                            str.append(' ');
                        }
                    }

                }else {

                    for (int j = (i - nbrWords); j < i; j++) {
                        str.append(words[j]);
                        if (r > 0) {
                            str.append(' ');
                            spaces--;
                            r--;
                        }
                        if (spaces > 0) {
                            for (int k = 0; k < q; k++) {
                                str.append(' ');
                                spaces--;
                            }
                        }
                        
                    }

                }

                
                result.add(str.toString());
                currentSize = -1;
                nbrWords = 0;
                str.setLength(0);
            }

            currentSize += s + 1;
            nbrWords += 1;
        }

        return result;

    }
}