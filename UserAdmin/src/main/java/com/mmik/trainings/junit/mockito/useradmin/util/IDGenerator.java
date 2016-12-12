package com.mmik.trainings.junit.mockito.useradmin.util;

public final class IDGenerator {

	private static long i;

	public IDGenerator() {
		
	}

	public static long generateID(){
		return i++;
	}
}
