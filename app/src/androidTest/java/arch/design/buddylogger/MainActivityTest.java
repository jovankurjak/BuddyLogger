package arch.design.buddylogger;

import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static arch.design.buddylogger.ScreenRobot.withRobot;

/**
 * Created by kurjakov on 23/08/2018.
 */


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> activityRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void shouldDisplayNotesHeader(){
        withRobot(MainActivityRobot.class)
                .checkAreHeadersDisplayed();
    }

    @Test
    public void shouldMatchHintOfNotesEditText(){
        withRobot(MainActivityRobot.class)
                .checkIfHeaderHintIsPresent();
    }

    @Test
    public void shouldClearDefaultTextWhenClickOnNotes(){
        withRobot(MainActivityRobot.class)
                .checkIfNotesEditTextIsDisplayed()
                .checkIfNotesEditTextIsEmptyOnClick();
    }

    public static class MainActivityRobot extends ScreenRobot<MainActivityRobot>{

        public MainActivityRobot checkAreHeadersDisplayed(){
            return checkIsDisplayed(R.id.debug_notification_tv);
        }

        public MainActivityRobot checkIfHeaderHintIsPresent(){
            return checkViewHasHint(R.id.main_edit_text, R.string.main_edit_text);
        }

        public MainActivityRobot checkIfNotesEditTextIsDisplayed(){
            return checkIsDisplayed(R.id.main_edit_text);
        }

        public MainActivityRobot checkIfNotesEditTextIsEmptyOnClick(){
            return clickOkOnView(R.id.main_edit_text)
                    .checkViewHasText(R.id.main_edit_text, "");
        }

    }
}
