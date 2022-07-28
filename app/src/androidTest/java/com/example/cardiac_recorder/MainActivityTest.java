package com.example.cardiac_recorder;

import static org.junit.Assert.*;

import android.os.SystemClock;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

import android.os.SystemClock;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

/**
 * Consists of all the functions required for UI Test
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {



    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /**
     * Checks the application name matching or not
     */
    @Test
    public void test1checkappname(){
        onView(withText("CardiacRecorder")).check(matches(isDisplayed()));
    }
    /**
     * Checks the User Interface and all the functionalities required to Add a measurement data in the Recyclerview step by step
     */
    @Test
    public void test2add(){
        SystemClock.sleep(5000);
        onView(withId(R.id.add_msr)).perform(click());
        onView(withId(R.id.edit_date)).perform(ViewActions.typeText("22/07/2022"));
        onView(withId(R.id.edit_time)).perform(ViewActions.typeText("8:15"));
        onView(withId(R.id.edit_sys_pr)).perform(ViewActions.typeText("130"));
        onView(withId(R.id.edit_dais_pr)).perform(ViewActions.typeText("90"));
        Espresso.pressBack();
        Espresso.onView(withId(R.id.edit_heat_rate)).perform(ViewActions.typeText("60"));
        Espresso.pressBack(); //Back button
        onView(withId(R.id.edit_comment)).perform(ViewActions.typeText("Normal"));
        Espresso.pressBack(); //Back button
        onView(withId(R.id.button_save)).perform(click());
        onView(withId(R.id.measurement)).check(matches(isDisplayed()));

        SystemClock.sleep(5000);
        onView(withId(R.id.add_msr)).perform(click());

        onView(withId(R.id.edit_date)).perform(ViewActions.typeText("22/07/2022"));
        onView(withId(R.id.edit_time)).perform(ViewActions.typeText("9:30"));
        onView(withId(R.id.edit_sys_pr)).perform(ViewActions.typeText("150"));
        onView(withId(R.id.edit_dais_pr)).perform(ViewActions.typeText("100"));
        Espresso.pressBack();
        onView(withId(R.id.edit_heat_rate)).perform(ViewActions.typeText("80"));
        Espresso.pressBack(); //Back button
        onView(withId(R.id.edit_comment)).perform(ViewActions.typeText("High Pressure"));
        Espresso.pressBack(); //Back button
        onView(withId(R.id.button_save)).perform(click());
        onView(withId(R.id.measurement)).check(matches(isDisplayed()));

    }
    /**
     * Checks the User Interface and all the functionalities required to Update a measurement data from the Recyclerview step by step
     */
    @Test
    public void test3update(){
        SystemClock.sleep(5000);
        onView(withId(R.id.measurement)).perform(click());

        SystemClock.sleep(5000);

        onView(withId(R.id.cddate)).perform(clearText()).perform(ViewActions.typeText("31/06/2022"));
        onView(withId(R.id.cdtime)).perform(clearText()).perform(ViewActions.typeText("11:30"));
        onView(withId(R.id.cdsyspr)).perform(clearText()).perform(ViewActions.typeText("130"));
        onView(withId(R.id.cddiaspr)).perform(clearText()).perform(ViewActions.typeText("100"));
        Espresso.pressBack(); //Back button
        onView(withId(R.id.cdheartrate)).perform(clearText()).perform(ViewActions.typeText("60"));
        Espresso.pressBack(); //Back button
        onView(withId(R.id.cdcomment)).perform(clearText()).perform(ViewActions.typeText("Normal"));
        Espresso.pressBack(); //Back button
        SystemClock.sleep(2000);
        onView(withId(R.id.button_edit)).perform(click());
        SystemClock.sleep(3000);
    }
    /**
     * Checks the User Interface and all the functionalities required to Delete a measurement data from the Recyclerview step by step
     */
    @Test
    public void test4delete(){
        SystemClock.sleep(5000);
        onView(withId(R.id.measurement)).perform(click());
        SystemClock.sleep(3000);
        onView(withId(R.id.button_delete)).perform(click());
        SystemClock.sleep(5000);

    }
}