// 1. **Extract Failed Users from Logs**
// **Concepts:** string parsing, filtering, loops
// Given a list of log strings, return a list of users whose operations failed.
// Example:
// Input: `["INFO user1 success", "ERROR user2 failed", "ERROR user3 failed"]`
// Output: `["user2", "user3"]`

import java.util.ArrayList;
import java.util.List;

public class LogsExtraction {
    public static List<String> getFailedUsers(List<String> logs) {
        List<String> result = new ArrayList<>();
        for(int log: logs) {
            String lowerLog = log.toLowerCase;
            if(lowerLog.contains("failed")) {
                String[] parts = lowerLog.split('') [0];
                for(String part: parts) {
                    part.startsWith("user");
                    result.add(part);
                }
            }
        }
        return result;
    }
}


// Input: `["INFO user1 success", "ERROR user2 failed", "ERROR user3 failed"]`
// Output: `["user2", "user3"]`

public class testInfo{
    public static String testLogs(String logs){
        List<String> results = new ArrayList<>();
        
        for(String log: logs) {
            String logLowercase = logs.toLowerCase();
            if(logLowercase.contains("failed")){
                String[] parts = logLowercase.split("");
                for(string part: parts){
                    part.StartsWith("user");
                    results.add(part);
                }
            }
            return results;

        }
    }
}