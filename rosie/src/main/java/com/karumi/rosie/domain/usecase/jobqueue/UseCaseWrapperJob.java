/*
 * The MIT License (MIT) Copyright (c) 2014 karumi Permission is hereby granted, free of charge,
 * to any person obtaining a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to
 * do so, subject to the following conditions: The above copyright notice and this permission
 * notice shall be included in all copies or substantial portions of the Software. THE SOFTWARE
 * IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.karumi.rosie.domain.usecase.jobqueue;

import com.karumi.rosie.domain.usecase.UseCaseWrapper;
import com.path.android.jobqueue.Job;
import com.path.android.jobqueue.Params;

/**
 * Job extension created to be able to execute a use case using android-priority-job-queue.
 */
class UseCaseWrapperJob extends Job {
  private static final int PRIORITY_NORMAL = 3;
  private static final String TAG = "UseCaseWrapperJob";
  private final UseCaseWrapper useCaseWrapper;

  public UseCaseWrapperJob(UseCaseWrapper useCaseWrapper) {
    super(new Params(PRIORITY_NORMAL));
    this.useCaseWrapper = useCaseWrapper;
  }

  @Override public void onAdded() {

  }

  @Override public void onRun() throws Throwable {
    useCaseWrapper.execute();
  }

  @Override protected void onCancel() {

  }

  @Override protected boolean shouldReRunOnThrowable(Throwable throwable) {
    return false;
  }
}