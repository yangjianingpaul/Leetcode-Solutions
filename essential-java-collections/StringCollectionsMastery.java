import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCollectionsMastery {
    public void stringOperations() {
        // String s = "hello";
        // char[] chars = s.toCharArray();
        // List<Character> charList = s.chars().mapToObj(c -> (char)
        // c).collect(Collectors.toList());
        // String fromArray = String.valueOf(chars);
        // String join = String.join("",
        // charList.stream().map(String::valueOf).collect(Collectors.toList()));

        // StringBuilder sb = new StringBuilder();
        // sb.append("hello");
        // sb.append(' ');
        // sb.insert(0, "start ");
        // sb.deleteCharAt(0);
        // sb.reverse();
        // String result = sb.toString();

        String[] split = "a,b,c".split(",");
        String joined2 = String.join(",", split);
        List<String> words = Arrays.asList(split);
        String joined3 = String.join(",", words);
    }
}
