package collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExtensieMap {

    public static void main(String[] args) {
        Map<String, String> openWith =
                new HashMap<String, String>();

        // Add some elements to the Map. There are no
        // duplicate keys, but some of the values are duplicates.
        openWith.put("txt", "notepad.exe");
        openWith.put("bmp", "paint.exe");
        openWith.put("dib", "paint.exe");
        openWith.put("rtf", "wordpad.exe");
        // put overwrites the value if there is already
        // an element with the given key:
        openWith.put("txt", "winword.exe");

        System.out.format("For key = \"rtf\", value = %1$s.\n",
                openWith.get("rtf"));

        // method get returns null if the given key is
        // not in the Map.
        String value = openWith.get("tif");
        if (value == null) {
            System.out.println("no value with key \"tif\" found.");
        } else {
            System.out.format("For key = \"tif\", value = %1$s.\n",
                    value);
        }

        // method containsKey checks if a given key exists in the Map
        if (!openWith.containsKey("tif")) {
            System.out.println("key \"tif\" not found.");
        } else {
            System.out.format("For key = \"tif\", value = %1$s.\n",
                    openWith.get("tif"));
        }

        System.out.println();
        // iterate over key-value pairs in Map
        Set<String> keys = openWith.keySet();
        for (String key : keys) {
            System.out.format("Key = %1$s, Value = %2$s\n",
                    key, openWith.get(key));
        }

        System.out.println();
        // To get the values alone, use the values method.
        Collection<String> values = openWith.values();
        for (String s : values) {
            System.out.format("Value = %1$s\n", s);
        }

        // Use the Remove method to remove a key/value pair.
        System.out.println("\nRemoving(\"doc\")...");
        openWith.remove("doc");
        if (!openWith.containsKey("doc")) {
            System.out.println("Key \"doc\" is not found after removal.");
        }
    }
}
