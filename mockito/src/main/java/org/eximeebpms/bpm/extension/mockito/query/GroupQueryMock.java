package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.IdentityService;
import org.eximeebpms.bpm.engine.identity.Group;
import org.eximeebpms.bpm.engine.identity.GroupQuery;

public class GroupQueryMock extends AbstractQueryMock<GroupQueryMock, GroupQuery, Group, IdentityService> {

  public GroupQueryMock() {
    super(GroupQuery.class, IdentityService.class);
   }

}
