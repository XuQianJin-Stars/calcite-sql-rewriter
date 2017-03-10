package org.apache.calcite.adapter.jdbc;

import io.pivotal.beach.calcite.programs.BasicForcedRule;
import org.apache.calcite.adapter.jdbc.tools.JdbcRelBuilderFactory;
import org.apache.calcite.rel.RelNode;
import org.apache.calcite.rel.core.TableModify;
import org.apache.calcite.rel.logical.LogicalProject;
import org.apache.calcite.rel.logical.LogicalTableModify;

public class JournalledDeleteRule implements BasicForcedRule {
	@Override
	public RelNode apply(RelNode originalRel, JdbcRelBuilderFactory relBuilderFactory) {
		if (!(originalRel instanceof LogicalTableModify)) {
			return null;
		}

		LogicalTableModify tableModify = (LogicalTableModify) originalRel;

		if (!tableModify.getOperation().equals(TableModify.Operation.DELETE)) {
			return null;
		}

		if (!(tableModify.getInput() instanceof LogicalProject)) {
			return null;
		}

		return null; // TODO
	}
}