package com.example.annotations;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

public class LogProcessor {

    public static Object invoke(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getMethod(methodName, int.class, int.class);

        if (method.isAnnotationPresent(Loggable.class)) {
            System.out.println("Heure: " + LocalDateTime.now());
            System.out.println("Paramètres: " + Arrays.toString(args));
        }

        Object result = method.invoke(obj, args);

        if (method.isAnnotationPresent(Loggable.class)) {
            System.out.println("Valeur de retour: " + result);
        }

        return result;
    }
}
