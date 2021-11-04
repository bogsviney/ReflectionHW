package com.luxoft.reflection;

import org.junit.jupiter.api.Test;
import java.lang.reflect.*;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionTest {

    @Test
    void testCreateObjectBasedOnDefaultConstructor() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object object = Reflection.create(Alien.class);
        assertNotNull(object);
        assertEquals(Alien.class, object.getClass());
        Alien egg = (Alien) object;
        assertEquals(true, ((Alien) egg).isCreated);
    }

    @Test
    void testchangePrivateValuesToDefault() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Alien alien = new Alien("Name",12);
        Reflection.changePrivateValues(alien);
        assertEquals(null,alien.getName());
        assertEquals(0,alien.getAge());
        assertEquals(0.0d,alien.getAverageSpeed());
        assertEquals(false,alien.isHungry());
    }
}