/*
Copyright (C) 2018 Adrian D. Finlay. All rights reserved.

Licensed under the MIT License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://opensource.org/licenses/MIT

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER INCLUDING AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
==============================================================================
**/

package src.main.java;

import java.lang.reflect.*;
import java.lang.annotation.*;

//Type Annotation
@Target (ElementType.TYPE_USE) //So we can use it with Types
@Retention(RetentionPolicy.RUNTIME) //So we can perform reflection
@interface MutatesMember { //So we can define the annotation
	boolean truth() default true; //We'll assume it mutates member
}

public class AnnotatedReceiver {
	private int member =0;

	private void doX (@MutatesMember AnnotatedReceiver this) { this.member = 9;}
	private void doY (@MutatesMember(truth = false) AnnotatedReceiver this) { }

	public static void main (String [] args) throws NoSuchMethodException {
		// Perform Reflection to tell us what the result is
		// The method is private so we need getDeclaredMethod()
		Method m = AnnotatedReceiver.class.getDeclaredMethod("doX");
		Method m2 = AnnotatedReceiver.class.getDeclaredMethod("doY");

		AnnotatedType a = m.getAnnotatedReceiverType();
		AnnotatedType a2 = m2.getAnnotatedReceiverType();

		Annotation[] anno = new Annotation[2];
		anno[0] = a.getDeclaredAnnotation(MutatesMember.class);
		anno[1] = a2.getDeclaredAnnotation(MutatesMember.class);

		System.out.println();
		for (Annotation an: anno) { System.out.println(an); }
		System.out.println();
	}

}