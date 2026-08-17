package org.eximeebpms.bpm.extension.mockito.query;

import org.eximeebpms.bpm.engine.FilterService;
import org.eximeebpms.bpm.engine.filter.Filter;
import org.eximeebpms.bpm.engine.filter.FilterQuery;

public class FilterQueryMock extends AbstractQueryMock<FilterQueryMock, FilterQuery, Filter, FilterService> {

  public FilterQueryMock() {
    super(FilterQuery.class, FilterService.class);
   }

}
