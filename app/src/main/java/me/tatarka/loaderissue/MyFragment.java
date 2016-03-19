package me.tatarka.loaderissue;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;

public class MyFragment extends Fragment implements LoaderManager.LoaderCallbacks<Object> {
    private static final String TAG = "MyFragment";

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Object> onCreateLoader(int id, Bundle args) {
        return new MyLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<Object> loader, Object data) {
        Log.d(TAG, "received result: " + data);
    }

    @Override
    public void onLoaderReset(Loader<Object> loader) {

    }

    public static class MyLoader extends Loader<Object> {
        public MyLoader(Context context) {
            super(context);
        }

        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Override
        protected void onForceLoad() {
            deliverResult("foo");
        }
    }
}
