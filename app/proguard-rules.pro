# ----------------------------------------
# Android Support Library
# ----------------------------------------
-dontwarn android.support.**
-keep class android.support.** { *; }

# ----------------------------------------
# RxJava
# ----------------------------------------
-dontwarn rx.internal.util.unsafe.**
-keep class rx.schedulers.Schedulers {
    public static <methods>;
}
-keep class rx.schedulers.ImmediateScheduler {
    public <methods>;
}
-keep class rx.schedulers.TestScheduler {
    public <methods>;
}
-keep class rx.schedulers.Schedulers {
    public static ** test();
}
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
    long producerIndex;
    long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    long producerNode;
    long consumerNode;
}

# ----------------------------------------
# Retrofit and OkHttp
# ----------------------------------------
-dontwarn com.squareup.okhttp3.**
-dontwarn okio.**
-dontwarn retrofit2.**

# ----------------------------------------
# Retrolambda
# ----------------------------------------
-dontwarn java.lang.invoke.*

# ----------------------------------------
# Butterknife
# ----------------------------------------
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

# ----------------------------------------
# Gson
# ----------------------------------------
-keepattributes Signature
-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
