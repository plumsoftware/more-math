#include <jni.h>
#include <string>


extern "C" JNIEXPORT jlong JNICALL
Java_ru_plumsoftware_nativelib_NativeLib_00024HyperOperators_nativeFactorial(JNIEnv *env, jobject obj, jint n) {
    unsigned long long result = 1;

    for (int i = 2; i <= n; ++i) {
        result *= i;

        if (result > 9223372036854775807ULL) {
            return -1;
        }
    }

    return static_cast<jlong>(result);;
}
