package api.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonFileReader {

    // Read the JSON file  as a string
    public static String getPayload(String fileName) throws IOException {
        String filePath = "src/test/resources/payloads/" + fileName;
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    // Extract the JSON object by name from the file content
    public static String getPayloadByName(String fileName, String payloadName) throws IOException {
        String jsonContent = getPayload(fileName);
        String target = "\"" + payloadName + "\":";
        int startIndex = jsonContent.indexOf(target) + target.length();
        int endIndex = jsonContent.indexOf("}", startIndex) + 1;
        return jsonContent.substring(startIndex, endIndex).trim();
    }
}

