package arch.design.buddylogger;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import arch.design.buddylogger.di.AppComponent;
import arch.design.buddylogger.di.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import timber.log.Timber;

/**
 * Created by kurjakov on 22/08/2018.
 */

public class AppLogBuddy extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent
                .builder()
                .application(this)
                .build();
        appComponent.inject(this);

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree(){
                // Add the line number to the tag
                @Override
                protected @Nullable String createStackElementTag(@NotNull StackTraceElement element) {
                    return super.createStackElementTag(element) + ':' + element.getLineNumber();
                }
            });
        }
        return appComponent;
    }
}
