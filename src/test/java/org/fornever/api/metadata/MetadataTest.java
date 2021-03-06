package org.fornever.api.metadata;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.fornever.api.guice.GuiceBindings;
import org.fornever.api.types.SchemaMetadata;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.inject.Guice;
import com.google.inject.Inject;

public class MetadataTest {
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	SchemaMetadata metadata;

	@Inject
	private DataSource datasource;

	@After
	public void setDown() {
	}

	@Before
	public void setUp() {
		Guice.createInjector(new GuiceBindings()).injectMembers(this);
	}

	@Test
	public void testTableMetadatas() throws SQLException {
		SchemaMetadata metadata = new SchemaMetadata();
		assert metadata.getTables().size() > 0;
		logger.info("demo metadata information :\n{}", JSON.toJSONString(metadata));
	}
}
