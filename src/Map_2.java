import java.util.HashMap;
import java.util.Map;

public class Map_2 {
    /*
    Maps with bulk data and loops.
     */
    class Word0 {
        /* Given an array of strings, return a Map<String, Integer> containing a key for
        every different string in the array, always with the value 0. For example the string
        "hello" makes the pair "hello":0.
        We'll do more complicated counting later, but for this problem the value is simply 0.

        word0(["a", "b", "a", "b"]) → {"a": 0, "b": 0}
        word0(["a", "b", "a", "c", "b"]) → {"a": 0, "b": 0, "c": 0}
        word0(["c", "b", "a"]) → {"a": 0, "b": 0, "c": 0}
         */

        public Map<String, Integer> word0(String[] strings) {
            Map<String, Integer> map = new HashMap();
            for (String s : strings) {
                map.put(s, 0);
            }
            return map;
        }
    }

    class WordLen {
       /*  Given an array of strings, return a Map<String, Integer>
       containing a key for every different string in the array, and the value is that string's length.

       wordLen(["a", "bb", "a", "bb"]) → {"bb": 2, "a": 1}
       wordLen(["this", "and", "that", "and"]) → {"that": 4, "and": 3, "this": 4}
       wordLen(["code", "code", "code", "bug"]) → {"code": 4, "bug": 3}
        */

        public Map<String, Integer> wordLen(String[] strings) {
            Map<String, Integer> map = new HashMap();
            for (String s : strings) {
                map.put(s, s.length());
            }
            return map;
        }
    }

    class Pairs {
        /* Given an array of non-empty strings, create and return a Map<String, String> as follows:
        for each string add its first character as a key with its last character as the value.

        pairs(["code", "bug"]) → {"b": "g", "c": "e"}
        pairs(["man", "moon", "main"]) → {"m": "n"}
        pairs(["man", "moon", "good", "night"]) → {"g": "d", "m": "n", "n": "t"}
         */

        public Map<String, String> pairs(String[] strings) {
            Map<String, String> map = new HashMap();
            for (String s : strings) {
                map.put(s.substring(0, 1), s.substring(s.length() - 1));
            }
            return map;
        }
    }

    class WordCount {
        /* The classic word-count algorithm: given an array of strings, return a Map<String, Integer>
        with a key for each different string, with the value the number of
        times that string appears in the array.

        wordCount(["a", "b", "a", "c", "b"]) → {"a": 2, "b": 2, "c": 1}
        wordCount(["c", "b", "a"]) → {"a": 1, "b": 1, "c": 1}
        wordCount(["c", "c", "c", "c"]) → {"c": 4}
         */

        public Map<String, Integer> wordCount(String[] strings) {
            Map<String, Integer> map=new HashMap();
            for(int i=0;i<strings.length;i++){
                String test=strings[i];
                if(map.containsKey(test)){
                    int count=map.get(test);
                    map.put(test,count+1);
                } else{
                    map.put(test,1);
                }
            }
            return map;
        }
    }

    class FirstChar {
        /* Given an array of non-empty strings, return a Map<String, String> with a key for every
        different first character seen, with the value of
        all the strings starting with that character appended together in the order they appear in the array.

        firstChar(["salt", "tea", "soda", "toast"]) → {"s": "saltsoda", "t": "teatoast"}
        firstChar(["aa", "bb", "cc", "aAA", "cCC", "d"]) → {"a": "aaaAA", "b": "bb", "c": "cccCC", "d": "d"}
        firstChar([]) → {}
         */

        public Map<String, String> firstChar(String[] strings) {
            Map<String, String> map = new HashMap();
            for (String s : strings) {
                String key = String.valueOf(s.charAt(0));
                if (map.containsKey(key)) {
                    String value = map.get(key);
                    map.put(key, value + s);
                } else {
                    map.put(key, s);
                }
            }
            return map;
        }
    }

    class WordAppend {
        /* Loop over the given array of strings to build a result string like this:
        when a string appears the 2nd, 4th, 6th, etc. time in the array,
        append the string to the result. Return the empty string if no string appears a 2nd time.

        wordAppend(["a", "b", "a"]) → "a"
        wordAppend(["a", "b", "a", "c", "a", "d", "a"]) → "aa"
        wordAppend(["a", "", "a"]) → "a"
         */

        public String wordAppend(String[] strings) {
            Map<String, Integer> map = new HashMap();
            String result = "";

            for (int i = 0; i < strings.length; i++) {
                String key = strings[i];
                if (map.containsKey(key)) {
                    int value = map.get(key);
                    value++;
                    if (value % 2 == 0) {
                        result += key;
                    }
                    map.put(key, value);
                } else {
                    map.put(key, 1);
                }
            }
            return result;
        }
    }

    class WordMultiple {
        /* Given an array of strings, return a Map<String, Boolean> where each
        different string is a key and its value is true if that string appears
        2 or more times in the array.

        wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
        wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
        wordMultiple(["c", "c", "c", "c"]) → {"c": true}
         */

        public Map<String, Boolean> wordMultiple(String[] strings) {
            Map<String, Boolean> map = new HashMap();
            for (String s : strings) {
                if (map.containsKey(s)) {
                    map.put(s, true);
                } else {
                    map.put(s, false);
                }
            }
            return map;
        }
    }

    class AllSwap {
        /* We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
        Loop over and then return the given array of non-empty strings as follows:
        if a string matches an earlier string in the array, swap the 2 strings in the array.
        When a position in the array has been swapped, it no longer matches anything. Using a map,
        this can be solved making just one pass over the array. More difficult than it looks.

        allSwap(["ab", "ac"]) → ["ac", "ab"]
        allSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "azz", "aaa"]
        allSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "aj", "ai", "by", "bx"]
         */

        public String[] allSwap(String[] strings) {
            Map<String, Integer> map = new HashMap();
            for (int i=0; i<strings.length; i++) {
                String key = strings[i].substring(0, 1);
                if (map.containsKey(key)) {
                    int match = map.get(key);
                    String temp = strings[match];  // swap strings at match/i
                    strings[match] = strings[i];
                    strings[i] = temp;
                    map.remove(key);  // so this old one won't match anything
                }
                else {
                    map.put(key, i);
                }
            }
            return strings;
        }
    }

    class FirstSwap {
        /* We'll say that 2 strings "match" if they are non-empty and their first chars are the same.
        Loop over and then return the given array of non-empty strings as follows:
        if a string matches an earlier string in the array, swap the 2 strings in the array.
        A particular first char can only cause 1 swap, so once a char has caused a swap,
        its later swaps are disabled. Using a map,
        this can be solved making just one pass over the array. More difficult than it looks.

        firstSwap(["ab", "ac"]) → ["ac", "ab"]
        firstSwap(["ax", "bx", "cx", "cy", "by", "ay", "aaa", "azz"]) → ["ay", "by", "cy", "cx", "bx", "ax", "aaa", "azz"]
        firstSwap(["ax", "bx", "ay", "by", "ai", "aj", "bx", "by"]) → ["ay", "by", "ax", "bx", "ai", "aj", "bx", "by"]
         */

        public String[] firstSwap(String[] strings) {
            Map<String, Integer> map = new HashMap();
            for (int i=0; i<strings.length; i++) {
                String key = strings[i].substring(0, 1);
                if (map.containsKey(key) && map.get(key) != -1) {
                    int match = map.get(key);
                    String temp = strings[match];  // swap strings at match/i
                    strings[match] = strings[i];
                    strings[i] = temp;
                    map.put(key, -1);  // so this old one won't match anything
                } else if (map.containsKey(key) && map.get(key) == -1) {
                    continue;
                }
                else {
                    map.put(key, i);
                }
            }
            return strings;
        }
    }
}
