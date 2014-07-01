package com.rolan.examples.mockitoexamples;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;


@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticInnerClass.class)
public class DoAnswerPowerMockExample {

    @Spy
    @InjectMocks
    private App app = new App();
    @Mock
    private Callback<SomeClass> callback;
    @Mock
    private StaticInnerClass staticInnerClass;

    @Before
    public void before() {
        PowerMockito.mockStatic(StaticInnerClass.class);
        org.powermock.api.mockito.PowerMockito.when(StaticInnerClass.getInstance()).thenReturn(staticInnerClass);
    }

    @Test
    public void testFirstTime() {
        SomeClass someClass = new SomeClass(2L, "testFirstTime");
        createAnswer(someClass);
        app.callStaticMethod(callback);
        verify(callback).callBack(someClass);
    }

    @Test
    public void testSecondTime() {
        SomeClass someClass = new SomeClass(3L, "testSecondTime");
        createAnswer(someClass);
        app.callStaticMethod(callback);
        verify(callback).callBack(someClass);
    }

    private void createAnswer(final SomeClass someClass) {
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                Callback<SomeClass> callback = (Callback<SomeClass>) invocationOnMock.getArguments()[0];
                callback.callBack(someClass);
                System.out.println(someClass);
                return null;
            }
        }).when(staticInnerClass).someMethod(Matchers.<Callback<SomeClass>>any());
    }
}
