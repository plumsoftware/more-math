#include <jni.h>
#include <iostream>
#include <cmath>
#include "hyperoperator.h"

extern "C" {
JNIEXPORT jlong JNICALL
Java_more_math_native_model_NativeProvider_cppFactorial(JNIEnv *env, jobject thiz, jint number) {
    return static_cast<jlong>(factorial(number));
}
JNIEXPORT jlong JNICALL
Java_more_math_native_model_NativeProvider_cppLongFactorial(JNIEnv *env, jobject thiz, jlong number) {
    return static_cast<jlong>(factorial_(static_cast<long>(number)));
}

JNIEXPORT jdouble JNICALL
Java_more_math_native_model_NativeProvider_cppAverage(JNIEnv *env, jobject thiz,jintArray numbers) {

    jsize length = env->GetArrayLength(numbers);
    jint* elements = env->GetIntArrayElements(numbers, nullptr);
    if (elements == nullptr) {
        return 0.0;
    }

    double avg = average(elements, length);

    env->ReleaseIntArrayElements(numbers, elements, 0);

    return avg;
}

JNIEXPORT jdouble JNICALL
Java_more_math_native_model_NativeProvider_cppStandardDeviation(JNIEnv *env, jobject thiz,
                                                                jdoubleArray numbers) {
    jsize length = env->GetArrayLength(numbers);

    jdouble *elements = env->GetDoubleArrayElements(numbers, nullptr);
    if (elements == nullptr) {
        return 0.0;
    }

    double stddev = standardDeviation(elements, length);

    env->ReleaseDoubleArrayElements(numbers, elements, 0);

    return stddev;
}

JNIEXPORT jdouble JNICALL
Java_more_math_native_model_NativeProvider_cppTetraction(JNIEnv *env, jobject thiz, jdouble number,
                                                         jint other) {
    return tetraction(static_cast<double>(number), static_cast<int>(other));
}

JNIEXPORT jint JNICALL
Java_more_math_native_model_NativeProvider_cppGcd(JNIEnv *env, jobject thiz, jint a, jint b) {
    return gcd(a, b);
}
}
