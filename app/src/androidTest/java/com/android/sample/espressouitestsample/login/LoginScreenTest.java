package com.android.sample.espressouitestsample.login;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.android.sample.espressouitestsample.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by mayowa.adegeye on 01/06/2016.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginScreenTest {
    @Rule
    public ActivityTestRule<LoginActivity> mLoginActivityTestRule =
            new ActivityTestRule<LoginActivity>(LoginActivity.class);
    String email = "username@email.com";
    String password = "password";

    @Test
    public void clickLoginButton_showsSuccessScreenAfterLogin() {


        //type in email
        onView(withId(R.id.edit_text_email)).perform(typeText(email), closeSoftKeyboard());

        //type in password
        onView(withId(R.id.edit_text_password)).perform(typeText(password), closeSoftKeyboard());

        //click on login button
        onView(withId(R.id.button_login)).perform(click());

        //verify that success screen shows
        String successString = InstrumentationRegistry.getTargetContext().getString(R.string.text_login_successful);
        onView(withText(successString)).check(matches(isDisplayed()));
    }

    @Test
    public void clickLoginButton_emailvalidation() {
        String e = "username@email.com";

        // all statements test the same
        assertThat(e, equalTo(email));
        assertThat(e, is(equalTo(email)));
        assertThat(e, is(email));
    }


}
