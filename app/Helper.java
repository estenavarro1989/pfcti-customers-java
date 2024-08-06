public class Helper {
    public static String formatResponse(String res) {
        return res.replace("},{", "}\n{")
            .replace("\",\"", "\"\n\"")
            .replace("{", "")
            .replace("}", "\n")
            .replace("[", "")
            .replace("]", "")
            .replace("\"", "")
            .replace(":", ": ");
    }

    public static String formatErrors(String res) {
        return res.replace("\"errors\":", "")
            .replace("\",\"", "\"\n\"")
            .replace("{", "")
            .replace("}", "")
            .replace("[", "")
            .replace("]", "")
            .replace("\"", "");
    }
}
