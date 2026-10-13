# Production ProGuard & R8 Rules for Tenoch Girón | AI & Mobile Studio
# Security, Obfuscation and Google Play Integrity

# WebView and JavaScript security rules
-keepattributes JavascriptInterface
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# Preserve WebView classes
-keepclassmembers class * extends android.webkit.WebViewClient {
    public void *(android.webkit.WebView, java.lang.String);
    public void *(android.webkit.WebView, java.lang.String, android.graphics.Bitmap);
    public boolean *(android.webkit.WebView, android.webkit.WebResourceRequest);
}
-keepclassmembers class * extends android.webkit.WebChromeClient {
    public *;
}

# Strip logging statements in production builds to prevent diagnostic data leakage
-assumenosideeffects class android.util.Log {
    public static boolean isLoggable(java.lang.String, int);
    public static int v(...);
    public static int d(...);
    public static int i(...);
}

# Preserve Compose Runtime
-keepclassmembers class * extends androidx.activity.ComponentActivity {
    <init>();
}
