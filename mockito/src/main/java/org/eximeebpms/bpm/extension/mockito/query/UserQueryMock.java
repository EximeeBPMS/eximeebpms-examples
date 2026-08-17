package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.IdentityService;
import org.eximeebpms.bpm.engine.identity.User;
import org.eximeebpms.bpm.engine.identity.UserQuery;

public class UserQueryMock extends AbstractQueryMock<UserQueryMock, UserQuery, User, IdentityService> {

  public UserQueryMock() {
    super(UserQuery.class, IdentityService.class);
   }

}
