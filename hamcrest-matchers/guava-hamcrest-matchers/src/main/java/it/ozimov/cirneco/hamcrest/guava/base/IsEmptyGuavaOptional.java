package it.ozimov.cirneco.hamcrest.guava.base;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import com.google.common.base.Optional;

/**
 * Is the given {@linkplain Optional} instance empty?
 *
 * @since  version 0.1 for JDK7
 */
public class IsEmptyGuavaOptional extends TypeSafeMatcher<Optional> {

    /**
     * Creates a matcher that matches when the examined {@linkplain Optional} contains no object.
     */
    public static Matcher<Optional> emptyGuavaOptional() {
        return new IsEmptyGuavaOptional();
    }

    @Override
    protected boolean matchesSafely(final Optional actual) {
        return !actual.isPresent();
    }

    @Override
    protected void describeMismatchSafely(final Optional item, final Description mismatchDescription) {
        mismatchDescription.appendValue(item).appendText(" is not an empty optional");
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("an optional with no content");
    }

}
