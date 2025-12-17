package com.example.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void processClass(Class<?> clazz) {
        System.out.println("Traitement de la classe: " + clazz.getName());

        // Vérifier si la classe a l'annotation Author
        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Auteur: " + author.name());
            System.out.println("Date: " + author.date());
        }

        // Vérifier si la classe a l'annotation Version
        if (clazz.isAnnotationPresent(Version.class)) {
            Version version = clazz.getAnnotation(Version.class);
            System.out.println("Version: " + version.value());
        }

        // Afficher toutes les annotations de la classe
        System.out.println("\nToutes les annotations:");
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // Traiter les méthodes
        System.out.println("\nTraitement des méthodes:");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);

                System.out.println("Méthode: " + method.getName());
                System.out.println("Description: " + methodInfo.description());
                System.out.println("Tags: " + String.join(", ", methodInfo.tags()));
                System.out.println("Révision: " + methodInfo.revision());
                System.out.println();
            }
        }
    }

    public static void processClassWithBugs(Class<?> clazz) {
        System.out.println("\nTraitement des bugs pour: " + clazz.getName());

        // Bugs sur la classe
        Bug[] classBugs = clazz.getAnnotationsByType(Bug.class);

        if (classBugs.length > 0) {
            System.out.println("Bugs trouvés sur la classe: " + classBugs.length);
            for (Bug bug : classBugs) {
                System.out.println("ID: " + bug.id());
                System.out.println("Description: " + bug.description());
                System.out.println("Statut: " + bug.status());
                System.out.println();
            }
        } else {
            System.out.println("Aucun bug trouvé sur la classe");
        }

        // Bugs sur les méthodes (optionnel mais utile)
        System.out.println("Bugs trouvés sur les méthodes:");
        for (Method method : clazz.getDeclaredMethods()) {
            Bug[] methodBugs = method.getAnnotationsByType(Bug.class);
            for (Bug bug : methodBugs) {
                System.out.println("- Méthode: " + method.getName());
                System.out.println("  ID: " + bug.id());
                System.out.println("  Description: " + bug.description());
                System.out.println("  Statut: " + bug.status());
            }
        }
    }

    public static void main(String[] args) {
        // Traiter la classe AnnotatedClass
        processClass(AnnotatedClass.class);

        // Traiter les bugs
        processClassWithBugs(AnnotatedClass.class);
    }
}