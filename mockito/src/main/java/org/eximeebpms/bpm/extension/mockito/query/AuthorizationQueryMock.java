package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.AuthorizationService;
import org.eximeebpms.bpm.engine.authorization.Authorization;
import org.eximeebpms.bpm.engine.authorization.AuthorizationQuery;

public class AuthorizationQueryMock extends AbstractQueryMock<AuthorizationQueryMock, AuthorizationQuery, Authorization, AuthorizationService> {

  public AuthorizationQueryMock() {
    super(AuthorizationQuery.class, AuthorizationService.class);
   }

}
