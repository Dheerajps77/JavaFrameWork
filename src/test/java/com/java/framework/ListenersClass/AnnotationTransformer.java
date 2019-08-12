package com.java.framework.ListenersClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer iRetryAnalyzer = annotation.getRetryAnalyzer();

		if (iRetryAnalyzer == null) {
			annotation.setRetryAnalyzer(RetryListeners.class);
		}
	}
}
