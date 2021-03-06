package it.ozimov.cirneco.hamcrest.java7.collect;

import static it.ozimov.cirneco.hamcrest.java7.collect.utils.IterableUtils.listCopy;
import static it.ozimov.cirneco.hamcrest.java7.collect.utils.IterableUtils.size;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Is the {@linkplain Iterable} with distinct elements?
 *
 * <p>
 * <p>
 * <p>
 * <p>To verify that only distinct elements are in the {@code Iterable},
 *
 * @since  version 0.2 for JDK7
 */
public class IsIterableWithDistinctElements<E> extends TypeSafeMatcher<Iterable<? extends E>> {

    /**
     * Creates a matcher for {@linkplain Iterable}s that matches when the examined {@linkplain Iterable} has only
     * distinct elements.
     *
     * <p>
     * <p>
     * <p>
     * <p>For example:
     *
     * <p>
     * <p>
     * <p>
     * <pre>assertThat(new ArrayList<>(), empty())</pre>
     *
     * returns <code>true</code>.
     */
    public static <E> Matcher<Iterable<? extends E>> hasDistinctElements() {
        return new IsIterableWithDistinctElements<>();
    }

    @Override
    public boolean matchesSafely(final Iterable<? extends E> actual) {
        return new HashSet<>(listCopy(actual)).size() == size(actual);
    }

    @Override
    public void describeMismatchSafely(final Iterable<? extends E> actual, final Description mismatchDescription) {
        final Collection<E> collection = listCopy(actual);
        final Set<E> elements = new HashSet<>(collection);
        final Set<E> nonDistinctElements = new HashSet<>();

        for (final E element : elements) {

            if (Collections.frequency(collection, element) > 1) {
                nonDistinctElements.add(element);
            }
        }

        mismatchDescription.appendText(" non distinct elements are ").appendValueList("[", ", ", "]",
            nonDistinctElements);
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("an iterable with all distinct elements");
    }
}
