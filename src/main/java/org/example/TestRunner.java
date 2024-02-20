package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class TestRunner {

    public static void start(Class<?> clazz) {
        try {
            // Отримання всіх методів класу
            Method[] methods = clazz.getDeclaredMethods();

            // Фільтрація методів з анотацією @BeforeSuite та @AfterSuite
            ArrayList<Method> beforeSuiteMethods = new ArrayList<>();
            ArrayList<Method> afterSuiteMethods = new ArrayList<>();
            ArrayList<Method> testMethods = new ArrayList<>();
            for (Method method : methods) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    beforeSuiteMethods.add(method);
                } else if (method.isAnnotationPresent(AfterSuite.class)) {
                    afterSuiteMethods.add(method);
                } else if (method.isAnnotationPresent(Test.class)) {
                    testMethods.add(method);
                }
            }

            // Перевірка, що єдиний метод з анотацією @BeforeSuite
            if (beforeSuiteMethods.size() > 1) {
                throw new RuntimeException("There should be only one method annotated with @BeforeSuite");
            }

            // Перевірка, що єдиний метод з анотацією @AfterSuite
            if (afterSuiteMethods.size() > 1) {
                throw new RuntimeException("There should be only one method annotated with @AfterSuite");
            }

            // Сортування методів тестів за пріоритетом
            testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));

            // Виконання методу з анотацією @BeforeSuite
            if (!beforeSuiteMethods.isEmpty()) {
                beforeSuiteMethods.get(0).invoke(null);
            }

            // Виконання методів тестів
            for (Method method : testMethods) {
                method.invoke(null);
            }

            // Виконання методу з анотацією @AfterSuite
            if (!afterSuiteMethods.isEmpty()) {
                afterSuiteMethods.get(0).invoke(null);
            }

        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
