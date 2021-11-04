package com.luxoft.reflection;

import java.lang.reflect.*;

public class Reflection {
    //      Метод принимает класс и возвращает созданный объект этого класса
    static Object create(Class clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor constructor = clazz.getConstructor();
        Object result = constructor.newInstance();
        return result;
    }
    //    Метод принимает object и вызывает у него все методы без параметров
    static void callMethodsWithoutParameters(Object object) {
        Class clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            try {
                method.setAccessible(true);
                method.invoke(object);
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
//    Метод принимает object и выводит на экран все сигнатуры методов в который есть final
    static void printAllFinalMethodsSignatures(Object object) throws InvocationTargetException, IllegalAccessException {
        Class clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (Modifier.isFinal(method.getModifiers())) {
                method.invoke(object);
                System.out.println(method);
            }
        }
    }
//    Метод принимает Class и выводит все не публичные методы этого класса

    static void showAllNotPublicMethods(Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (!Modifier.isPublic(method.getModifiers())) {
                System.out.println(method);
            }
        }
    }
//    Метод принимает объект и меняет всего его приватные поля на их нулевые значение (null, 0, false etc)+
    static void changePrivateValues(Object object) throws IllegalAccessException {        //вывело все и приватные и неприватные
        Class clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            Object fieldType = field.getType().getSimpleName();
            if (field.toString().startsWith("private")) {
                field.setAccessible(true);
                if (fieldType.equals("int")) {
                    field.set(object, 0);
                    System.out.println(fieldType + " " + field.getName() + " value changed to " + field.get(object));
                } else if (fieldType.equals("boolean")) {
                    field.set(object, false);
                    System.out.println(fieldType + " " + field.getName() + " value changed to " + field.get(object));
                } else if (fieldType.equals("double")) {
                    field.set(object, 0.0d);
                    System.out.println(fieldType + " " + field.getName() + " value changed to " + field.get(object));
                } else if (fieldType.equals("long")) {
                    field.set(object, 0L);
                    System.out.println(fieldType + " " + field.getName() + " value changed to " + field.get(object));
                } else if (fieldType.equals("char")) {
                    field.set(object, '\u0000');
                    System.out.println(fieldType + " " + field.getName() + " value changed to " + field.get(object));
                } else {
                    field.set(object, null);
                    System.out.println(fieldType + " " + field.getName() + " value changed to " + field.get(object));
                }
            }
        }
    }
//    Метод принимает Class и выводит всех предков класса и все интерфейсы которое класс имплементирует

}

