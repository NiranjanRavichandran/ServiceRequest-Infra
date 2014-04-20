package com.nttdata.dbfw;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultMapper {
	public Object mapRow(ResultSet resSet) throws SQLException;
}
