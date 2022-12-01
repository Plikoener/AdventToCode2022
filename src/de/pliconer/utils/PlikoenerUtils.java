package de.pliconer.utils;



 public class PlikoenerUtils {

 public static void debugLog(String message, boolean isDebug)
 {
     if (isDebug)
     {
         String timestamp = "["+java.time.Instant.now().toString()+"]";
         Class<?> caller = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
                 .getCallerClass();



         System.out.println(timestamp+"["+caller.getSimpleName()+"]"+message);
     }
 }
 public static void debugLog(String message)
 {
     debugLog(message,true);
 }
}
