package com.ubaidsample.SBJPAMYSQLJSP.Enum;

/*
 * @author Muhammad Ubaid Ur Raheem aka Shahbaz Haroon
 */

public enum Title {
	Mr("Mr"),
	Ms("Ms"),
	Mrs("Mrs");

	// Variable for getting values
	private String title;

	/*
	 * 	enum class’s object can’t be create explicitly, so for initializing we use parameterized constructor.
		And the constructor cannot be the public or protected. It must have private or default modifiers.
		Why?
		If we create public or protected, it will allow initializing more than one objects.
		This is totally against enum concept.

	 */
	// enum constructor - cannot be public or protected
	private Title(String s) {
		this.title = s;
	}

	// Getter method
	public String getTitle() {
		return title;
	}
}