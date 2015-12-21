package org.cirneco.assertions.hamcrest.iterable;

import org.cirneco.assertions.hamcrest.BaseMatcherTest;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IsIterableWithSizeTest extends BaseMatcherTest {

    public static Iterable<Object> createIterableWithSize(final int expectedSize) {
        final Collection<Object> iterable = new ArrayList<>();
        for (int i = 0; i < expectedSize; i++) {
            iterable.add(new Object());
        }
        return iterable;
    }


    @Test
    public void testHasSizeOne() throws Exception {
        //Arrange
        final int expectedSize = 1;
        final Iterable<Object> iterableWithExpectedSize = createIterableWithSize(expectedSize);
        final Iterable<Object> iterableWithDifferentSize = createIterableWithSize(expectedSize + 1);
        final Matcher<Iterable<Object>> isIterableWithSizeMatcher = IsIterableWithSize.hasSizeOne();

        //Act
        final boolean matchesOnSameSize = isIterableWithSizeMatcher.matches(iterableWithExpectedSize);
        final boolean matchesOnDifferentSize = isIterableWithSizeMatcher.matches(iterableWithDifferentSize);

        //Assert
        assertMatches(matchesOnSameSize);
        assertDoesNotMatch(matchesOnDifferentSize);
    }

    @Test
    public void testHasSizeTwo() throws Exception {
        //Arrange
        final int expectedSize = 2;
        final Iterable<Object> iterableWithExpectedSize = createIterableWithSize(expectedSize);
        final Iterable<Object> iterableWithDifferentSize = createIterableWithSize(expectedSize + 1);
        final Matcher<Iterable<Object>> isIterableWithSizeMatcher = IsIterableWithSize.hasSizeTwo();

        //Act
        final boolean matchesOnSameSize = isIterableWithSizeMatcher.matches(iterableWithExpectedSize);
        final boolean matchesOnDifferentSize = isIterableWithSizeMatcher.matches(iterableWithDifferentSize);

        //Assert
        assertMatches(matchesOnSameSize);
        assertDoesNotMatch(matchesOnDifferentSize);
    }

    @Test
    public void testHasSizeThree() throws Exception {
        //Arrange
        final int expectedSize = 3;
        final Iterable<Object> iterableWithExpectedSize = createIterableWithSize(expectedSize);
        final Iterable<Object> iterableWithDifferentSize = createIterableWithSize(expectedSize + 1);
        final Matcher<Iterable<Object>> isIterableWithSizeMatcher = IsIterableWithSize.hasSizeThree();

        //Act
        final boolean matchesOnSameSize = isIterableWithSizeMatcher.matches(iterableWithExpectedSize);
        final boolean matchesOnDifferentSize = isIterableWithSizeMatcher.matches(iterableWithDifferentSize);

        //Assert
        assertMatches(matchesOnSameSize);
        assertDoesNotMatch(matchesOnDifferentSize);
    }

    @Test
    public void testHasSizeFour() throws Exception {
        //Arrange
        final int expectedSize = 4;
        final Iterable<Object> iterableWithExpectedSize = createIterableWithSize(expectedSize);
        final Iterable<Object> iterableWithDifferentSize = createIterableWithSize(expectedSize + 1);
        final Matcher<Iterable<Object>> isIterableWithSizeMatcher = IsIterableWithSize.hasSizeFour();

        //Act
        final boolean matchesOnSameSize = isIterableWithSizeMatcher.matches(iterableWithExpectedSize);
        final boolean matchesOnDifferentSize = isIterableWithSizeMatcher.matches(iterableWithDifferentSize);

        //Assert
        assertMatches(matchesOnSameSize);
        assertDoesNotMatch(matchesOnDifferentSize);
    }

    @Test
    public void testHasSizeFive() throws Exception {
        //Arrange
        final int expectedSize = 5;
        final Iterable<Object> iterableWithExpectedSize = createIterableWithSize(expectedSize);
        final Iterable<Object> iterableWithDifferentSize = createIterableWithSize(expectedSize + 1);
        final Matcher<Iterable<Object>> isIterableWithSizeMatcher = IsIterableWithSize.hasSizeFive();

        //Act
        final boolean matchesOnSameSize = isIterableWithSizeMatcher.matches(iterableWithExpectedSize);
        final boolean matchesOnDifferentSize = isIterableWithSizeMatcher.matches(iterableWithDifferentSize);

        //Assert
        assertMatches(matchesOnSameSize);
        assertDoesNotMatch(matchesOnDifferentSize);
    }

    @Test
    public void testHasSize() throws Exception {
        //Arrange
        final int expectedSize = 100;
        final Iterable<Object> iterableWithExpectedSize = createIterableWithSize(expectedSize);
        final Iterable<Object> iterableWithDifferentSize = createIterableWithSize(expectedSize + 1);
        final Matcher<Iterable<Object>> isIterableWithSizeMatcher = IsIterableWithSize.hasSize(expectedSize);

        //Act
        final boolean matchesOnSameSize = isIterableWithSizeMatcher.matches(iterableWithExpectedSize);
        final boolean matchesOnDifferentSize = isIterableWithSizeMatcher.matches(iterableWithDifferentSize);

        //Assert
        assertMatches(matchesOnSameSize);
        assertDoesNotMatch(matchesOnDifferentSize);
    }

    @Test
    public void testFeatureValueOf() throws Exception {
        //Arrange
        final int expectedSize = 100;
        final Iterable<Object> iterableWithExpectedSize = createIterableWithSize(expectedSize);
        final IsIterableWithSize<Object> isIterableWithSizeMatcher = new IsIterableWithSize(expectedSize);

        //Act
        final int calculatedSize = isIterableWithSizeMatcher.featureValueOf(iterableWithExpectedSize);

        //Assert
        assertThat(calculatedSize, is(expectedSize));
    }

}