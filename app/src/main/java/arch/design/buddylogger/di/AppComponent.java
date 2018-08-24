package arch.design.buddylogger.di;

import android.app.Application;

import arch.design.buddylogger.AppLogBuddy;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by kurjakov on 24/08/2018.
 */

@Component( modules ={
        AndroidSupportInjectionModule.class,
        AppComponentModule.class,
        ActivityBuilder.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication>{

    void inject(AppLogBuddy appLogBuddy);

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
