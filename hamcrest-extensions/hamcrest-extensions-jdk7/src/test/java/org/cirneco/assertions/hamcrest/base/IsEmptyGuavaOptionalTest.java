package org.cirneco.assertions.hamcrest.base;

import com.google.common.base.Optional;
import org.cirneco.assertions.hamcrest.BaseMatcherTest;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class IsEmptyGuavaOptionalTest extends BaseMatcherTest {

    public Matcher<Optional> isEmptyGuavaOptionalMatcher;

    public String getMatcherSimpleName() {
        return IsEmptyGuavaOptional.class.getSimpleName();
    }

    @Before
    public void setup() {
        //Arrange
        isEmptyGuavaOptionalMatcher = IsEmptyGuavaOptional.emptyOptional();
    }

    @Test
    public void testDescribeMismatchSafely() throws Exception {
        assertHasMismatchDescription("<Optional.of()> is not an empty optional",
                isEmptyGuavaOptionalMatcher, Optional.of(""));
    }

    @Test
    public void testDescribeTo() throws Exception {
        assertIsDescribedTo("an optional with no content", isEmptyGuavaOptionalMatcher);
    }

    @Test
    public void testGivenAnEmptyOptionalWhenMatchesIsCalledThenTrueIsReturned() throws Exception {
        //Arrange
        final Optional emptyOptional = Optional.absent();

        //Act
        boolean isEmpty = isEmptyGuavaOptionalMatcher.matches(emptyOptional);

        //Assert
        assertThat("Expected to be empty", isEmpty, is(true));
    }

    @Test
    public void testGivenANonEmptyOptionalWhenMatchesIsCalledThenFalseIsReturned() throws Exception {
        //Arrange
        final Optional nonEmptyOptional = Optional.of("");

        //Act
        boolean isEmpty = isEmptyGuavaOptionalMatcher.matches(nonEmptyOptional);

        //Assert
        assertThat("Expected to contains an object", isEmpty, is(false));
    }

}