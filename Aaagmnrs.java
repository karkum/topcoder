import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author karthik.kumar
 */
public class Aaagmnrs {

    public String[] anagrams(String[] phrases) {
        Set<Phrase> phraseSet = new HashSet<>();
        for (String s : phrases) {
            phraseSet.add(new Phrase(s));
        }

        String[] result = new String[phraseSet.size()];
        int i = 0;
        for (Phrase p : phraseSet) {
            result[i++] = p.phrase;
        }

        return result;
    }

    private static class Phrase {
        String phrase;
        Map<Character, Integer> charCount = new HashMap<>();

        public Phrase(String phrase) {
            this.phrase = phrase;
            computeCharCount(phrase);
        }

        private void computeCharCount(String phrase) {
            String fixedPhrase = phrase.toLowerCase().replace(" ", "");
            for (char c : fixedPhrase.toCharArray()) {
                Integer count = this.charCount.get(c);
                if (count == null) {
                    this.charCount.put(c, 1);
                }
                else {
                    this.charCount.put(c, ++count);
                }
            }
        }

        @Override
        public boolean equals(Object other) {
            Phrase otherPhrase = (Phrase)other;
            return this.charCount.equals(otherPhrase.charCount);
        }

        @Override
        public int hashCode() {
            return this.charCount.hashCode();
        }
    }

}
