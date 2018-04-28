#! /usr/bin/env python3

"""
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
"""

#A Python Class
class OOP:
	'''Some basic OOP in Python'''

	#Static Variable
	stat_var = 'My Class'

	#Object Initialization Method (Constructor)
	def __init__(self, name):
		self.name = name

	#Method
	def print_member (self):
		print('This is an object member:  "' + self.name + '"')
	#Function
	@staticmethod
	def print_class ():
		print('This is a static member:   "' + OOP.stat_var + '"')

#A Python Function, main()
def main ():
	print()
	oop = OOP('My Object') #Object Initialization

	oop.print_member() #Object Access
	OOP.print_class() #Class Access
	print()


#Let's run it
if __name__ == "__main__":
	main()