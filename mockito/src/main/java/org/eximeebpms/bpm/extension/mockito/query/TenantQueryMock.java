package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.IdentityService;
import org.eximeebpms.bpm.engine.identity.Tenant;
import org.eximeebpms.bpm.engine.identity.TenantQuery;

public class TenantQueryMock extends AbstractQueryMock<TenantQueryMock, TenantQuery, Tenant, IdentityService> {

  public TenantQueryMock() {
    super(TenantQuery.class, IdentityService.class);
   }

}
