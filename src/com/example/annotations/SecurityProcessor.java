package com.example.annotations;

import java.lang.reflect.Method;

public class SecurityProcessor {

	public static void execute(Object obj, String methodName) throws Exception {
		Method method = obj.getClass().getMethod(methodName);

		if (method.isAnnotationPresent(RequiresRole.class)) {
			String role = method.getAnnotation(RequiresRole.class).value();

			if (!SecurityContext.currentRole.equals(role)) {
				throw new SecurityException("Accès refusé");
			}
		}

		method.invoke(obj);
	}
}
