package org.cirneco.assertions.hamcrest.iterable;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.Comparator;
import java.util.Iterator;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.cirneco.assertions.hamcrest.iterable.utils.IterableUtils.listCopy;
import static org.cirneco.assertions.hamcrest.iterable.utils.IterableUtils.sortedListCopy;
import static org.cirneco.assertions.hamcrest.iterable.utils.IterableUtils.sortedReversedListCopy;

/**
 * Is the {@linkplain Iterable} sorted according to the given {@linkplain Comparator}?
 * <p>
 * Observe that the matcher can be used also with an instance of {@linkplain com.google.common.collect.Ordering},
 * thus enabling for powerful assertions based on that extension of <code>Comparator</code>.
 */
public class IsSortedIterableWithComparator<K> extends TypeSafeMatcher<Iterable<K>> {

    private final Comparator<K> comparator;
    private final boolean reversed;

    public IsSortedIterableWithComparator(final Comparator<K> comparator, final boolean reversed) {
        checkNotNull(comparator);

        this.comparator = comparator;
        this.reversed = reversed;
    }

    /**
     * Creates a matcher for {@link Iterable}s matching when the examined {@linkplain Iterable} has
     * the elements sorted according to the given {@linkplain Comparator}.
     */
    public static <K> Matcher<Iterable<K>> sorted(final Comparator<K> comparator) {
        return new IsSortedIterableWithComparator(comparator, false);
    }

    /**
     * Creates a matcher for {@link Iterable}s matching when the examined {@linkplain Iterable} has
     * the elements sorted according to the given {@linkplain Comparator}, but in a reverse order.
     */
    public static <K> Matcher<Iterable<K>> sortedReversed(final Comparator<K> comparator) {
        return new IsSortedIterableWithComparator(comparator, true);
    }

    @Override
    public boolean matchesSafely(final Iterable<K> actual) {
        final Iterator<K> iterator = actual.iterator();

        K previous = null;
        while (iterator.hasNext()) {
            final K current = iterator.next();
            if (previous != null &&
                    ((!reversed && comparator.compare(previous, current) >= 0) ||
                            (reversed && comparator.compare(previous, current) <= 0))) {
                return false;
            }
            previous = current;
        }
        return true;
    }

    @Override
    public void describeMismatchSafely(final Iterable<K> iterable, final Description mismatchDescription) {
        mismatchDescription.appendText("iterable was ").appendValueList("[", ", ", "]", listCopy(iterable))
                .appendText(", while expected iterable with ordering ")
                .appendValueList("[", ", ", "]",
                        reversed ? sortedReversedListCopy(iterable, comparator) : sortedListCopy(iterable, comparator));
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("iterable sorted according to given comparator");
        if (reversed)
            description.appendText(" in reverse order");
    }


}