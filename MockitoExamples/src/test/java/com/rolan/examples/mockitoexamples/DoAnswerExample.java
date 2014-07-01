package com.rolan.examples.mockitoexamples;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.doAnswer;

@RunWith(MockitoJUnitRunner.class)
public class DoAnswerExample {

    @Spy
    @InjectMocks
    private App app = new App();
    @Mock
    private Callback<SomeClass> callback;

    @Test
    public void testFirstTime() {
        SomeClass someClass = new SomeClass(2L, "testFirstTime");
        createAnswer(someClass);
        app.someMethod(callback);
    }

    @Test
    public void testSecondTime() {
        SomeClass someClass = new SomeClass(3L, "testSecondTime");
        createAnswer(someClass);
        app.someMethod(callback);
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
        }).when(app).someMethod(Matchers.<Callback<SomeClass>>any());
    }
}
