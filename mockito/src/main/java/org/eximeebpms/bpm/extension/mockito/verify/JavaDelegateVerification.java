package org.eximeebpms.bpm.extension.mockito.verify;

import static org.mockito.Mockito.verify;

import org.eximeebpms.bpm.engine.delegate.DelegateExecution;
import org.eximeebpms.bpm.engine.delegate.JavaDelegate;
import org.mockito.verification.VerificationMode;

public class JavaDelegateVerification extends AbstractMockitoVerification<JavaDelegate, DelegateExecution> {

  public JavaDelegateVerification(final JavaDelegate mock) {
    super(mock, DelegateExecution.class);
  }

  @Override
  protected void doVerify(final VerificationMode verificationMode) throws Exception {
    verify(mock, verificationMode).execute(argumentCaptor.capture());
  }

}
