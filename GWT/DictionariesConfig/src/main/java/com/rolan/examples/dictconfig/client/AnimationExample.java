package com.rolan.examples.dictconfig.client;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;


public class AnimationExample extends Composite {

    @UiField
    Button startAnimation;
    @UiField
    Label animationLabel;

    private static final AnimationExampleUiBinder ourUiBinder = GWT.create(AnimationExampleUiBinder.class);
    private MyAnimation animation = new MyAnimation();

    public AnimationExample() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    private class MyAnimation extends Animation {

        @Override
        protected void onUpdate(double progress) {
            animationLabel.setText(String.valueOf(progress));
        }

        @Override
        protected void onComplete() {
            super.onComplete();
            animationLabel.setText(" ");
        }
    }

    @UiHandler("startAnimation")
    public void handleClick(ClickEvent event) {
        Object source = event.getSource();
        if (source == startAnimation) {
            if (!animation.isRunning()) {
                animation.run(2000);
            }
        }
    }

    interface AnimationExampleUiBinder extends UiBinder<Widget, AnimationExample> {
    }
}