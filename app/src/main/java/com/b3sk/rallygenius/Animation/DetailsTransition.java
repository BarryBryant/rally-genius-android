package com.b3sk.rallygenius.Animation;

import android.annotation.TargetApi;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionSet;

import java.lang.annotation.Target;

/**
 * Created by Joopkins on 5/29/16.
 */

@TargetApi(21)
public class DetailsTransition extends TransitionSet {

    public DetailsTransition() {
        setOrdering(ORDERING_TOGETHER);
        addTransition(new ChangeBounds()).
                addTransition(new ChangeTransform()).
                addTransition(new ChangeImageTransform());
    }
}
