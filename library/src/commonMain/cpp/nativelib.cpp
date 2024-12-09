#include <jni.h>

extern "C"
JNIEXPORT jlong JNICALL
Java_more_math_native_model_NativeProvider_factorial(JNIEnv *env, jobject thiz, jint number) {
    unsigned long long result = 1;

    for (int i = 2; i <= number; ++i) {
        result *= i;

        if (result > 9223372036854775807ULL) {
            return -1;
        }
    }

    return static_cast<jlong>(result);
}