package arch.design.buddylogger.di;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

/**
 * Created by kurjakov on 24/08/2018.
 */

@Module
public abstract class AppComponentModule {

    @Binds
    abstract Context provideContext(Application application);
}
