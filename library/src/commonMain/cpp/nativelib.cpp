#include <jni.h>
#include <iostream>
#include <cmath>

extern "C"
JNIEXPORT jlong JNICALL
Java_more_math_native_model_NativeProvider_cppFactorial(JNIEnv *env, jobject thiz, jint number) {
    unsigned long long result = 1;

    for (int i = 2; i <= number; ++i) {
        result *= i;

        if (result > 9223372036854775807ULL) {
            return -1;
        }
    }

    return static_cast<jlong>(result);
}

extern "C"
JNIEXPORT jlong JNICALL
Java_more_math_native_model_NativeProvider_cppLongFactorial(JNIEnv *env, jobject thiz, jlong number) {
    unsigned long long result = 1;

    for (int i = 2; i <= number; ++i) {
        result *= i;

        if (result > 9223372036854775807ULL) {
            return -1;
        }
    }

    return static_cast<jlong>(result);
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_more_math_native_model_NativeProvider_cppAverage(JNIEnv *env, jobject thiz, jintArray numbers) {
    jsize length = env->GetArrayLength(numbers);
    if (length == 0) {
        return 0.0;
    }

    jint *elements = env->GetIntArrayElements(numbers, nullptr);

    jint sum = 0;
    for (jsize i = 0; i < length; i++) {
        sum += elements[i];
    }

    env->ReleaseIntArrayElements(numbers, elements, 0);
    delete elements;

    return static_cast<jdouble>(sum) / length;
}

extern "C"
JNIEXPORT jdouble JNICALL
Java_more_math_native_model_NativeProvider_cppStandardDeviation(JNIEnv *env, jobject thiz, jdoubleArray numbers) {
    jsize length = env->GetArrayLength(numbers);
    if (length < 2) {
        return 0.0;
    }

    jdouble *elements = env->GetDoubleArrayElements(numbers, nullptr);


    jdouble sum = 0.0;
    for (jsize i = 0; i < length; i++) {
        sum += elements[i];
    }
    jdouble avg = sum / length;

    jdouble sumOfSquares = 0.0;
    for (jsize i = 0; i < length; i++) {
        sumOfSquares += (elements[i] - avg) * (elements[i] - avg);
    }

    env->ReleaseDoubleArrayElements(numbers, elements, 0);
    delete elements;


    return sqrt(sumOfSquares / (length - 1));
}