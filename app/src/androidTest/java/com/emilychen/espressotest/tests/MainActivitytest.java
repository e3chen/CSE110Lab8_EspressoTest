package com.emilychen.espressotest.tests;

import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.emilychen.espressotest.MainActivity;
import com.emilychen.espressotest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by emilychen on 5/24/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivitytest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testText() {
        String expectedTest = "Hello World!";
        onView(withId(R.id.textView)).check(matches(withText(expectedTest)));
    }

    @Test
    public void sayHello() {
        onView(withId(R.id.editText)).perform(typeText("emily"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        String expectedText = "emily";
        onView(withId(R.id.textView)).check(matches(withText(expectedText)));
    }

    @Test
    public void reverse() {
        onView(withId(R.id.editText)).perform(typeText("CSE 110"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.button2)).perform(click());
        String reverseText = "011 ESC";
        onView(withId(R.id.textView)).check(matches(withText(reverseText)));
    }
}
