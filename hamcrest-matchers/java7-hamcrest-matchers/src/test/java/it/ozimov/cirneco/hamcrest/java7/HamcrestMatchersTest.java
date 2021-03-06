package it.ozimov.cirneco.hamcrest.java7;

import org.hamcrest.Matchers;

import org.junit.Test;

import it.ozimov.cirneco.hamcrest.SameCallerMatchersTest;

import javassist.CtMethod;

public class HamcrestMatchersTest extends SameCallerMatchersTest {

    @Override
    public String setFullyQualifiedSourceClass() {
        return HamcrestMatchers.class.getCanonicalName();
    }

    @Test
    public void testStaticMethodCallsRightMethod() throws Exception {
        for (final CtMethod method : getAllDeclaredMethods()) {
            testMethodCallsRightMethod(Matchers.class, method);
        }
    }

}
