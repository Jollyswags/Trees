class Solution {
     public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> buttons = Map.of(
                '2', List.of("a", "b", "c"),
                '3', List.of("d", "e", "f"),
                '4', List.of("g", "h", "i"),
                '5', List.of("j", "k", "l"),
                '6', List.of("m", "n", "o"),
                '7', List.of("p", "q", "r", "s"),
                '8', List.of("t", "u", "v"),
                '9', List.of("w", "x", "y", "z")
        );

        List<String> result = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            char digit = digits.charAt(i);
            List<String> symbols = buttons.get(digit);
            int previousResultSize = result.size();
            if (previousResultSize == 0) {
                result.addAll(symbols);
            } else {
                for (int j = 0; j < previousResultSize; j++) {
                    for (String symbol : symbols) {
                        result.add(result.get(0) + symbol);
                    }
                    result.remove(0);
                }
            }
        }
        return result;
    }
}