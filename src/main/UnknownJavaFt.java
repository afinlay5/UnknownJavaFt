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

package src.main;

import java.io.*;
import src.main.java.ThisEG;
import src.main.java.ThisCheck;
import src.main.java.AnnotatedReceiver;
import static java.lang.System.out;

public class UnknownJavaFt {
	public static void main (String [] args) throws NoSuchMethodException, IOException {
		String msg1 = "OOP.py";
		String msg2 = "ThisEG.java";
		String msg3 = "AnnotatedReceiver.java";

		//OOP.py
		out.println("----------------------------");
		out.println(msg1);
		out.println("----------------------------");
		Process proc; //Java being pedantic. We're adults! Most of us...
		if (new File(System.getProperty("user.dir"), "src/main/python/OOP.py").exists()) {
			proc = Runtime.getRuntime().exec("python3 src/main/python/OOP.py");
		}
		else {
			System.err.println("The script could not be found."); 
			System.exit(0);
			proc = null; //Ridiculous that we even have to do this.
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(proc.getInputStream()))) {
				String output = br.readLine();
				if (output == null) {
					System.err.println("An error occured in printing the stream.");
					System.exit(0);
				}
				else {
					System.out.println(output);
					while( (output = br.readLine()) != null) { 
						System.out.println(output); 
					}
				}
		}

		//ThisEG.java
		out.println("----------------------------");
		out.println(msg2);
		out.println("----------------------------\n");
		ThisEG.main(null);
		
		//AnnotatedReceiver.java
		out.println("\n----------------------------");
		out.println(msg3);
		out.println("----------------------------");
		new AnnotatedReceiver().main(null);
		
		//End
		out.println("----------------------------");
		out.println("----------------------------");
	}
}